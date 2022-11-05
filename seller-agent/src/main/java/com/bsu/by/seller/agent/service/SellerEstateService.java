package com.bsu.by.seller.agent.service;

import com.bsu.by.seller.agent.dto.request.EstateDto;
import com.bsu.by.seller.agent.event.EventType;
import com.bsu.by.seller.agent.event.estate.NewEstateEvent;
import com.bsu.by.seller.agent.exception.badrequest.FileNotProvidedException;
import com.bsu.by.seller.agent.message.EventSender;
import com.bsu.by.seller.agent.util.EventPayloadUtil;
import com.bsu.by.seller.agent.util.EventUtil;
import com.bsu.by.seller.agent.util.SellerEstateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.mime.MimeTypeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SellerEstateService {
    private static final int VERSION = 1;
    @Value("${upload.path}")
    private String uploadPath;

    private final SellerEstateUtil sellerEstateUtil;
    private final EventUtil eventUtil;
    private final EventPayloadUtil eventPayloadUtil;
    private final EventSender eventSender;

    @Transactional
    public void saveEstate(EstateDto estateDto, MultipartFile file) throws IOException, MimeTypeException {
        Path root = Paths.get(uploadPath);
        if (!Files.exists(root)) {
            sellerEstateUtil.init();
        }
        if (!Objects.isNull(file)) {
            String originalFilename = file.getOriginalFilename();
            if (!Objects.isNull(originalFilename) && !originalFilename.equals("")) {
                sellerEstateUtil.checkExtension(file);

                String entityId = UUID.randomUUID().toString();
                String fileName = UUID.randomUUID().toString();
                String extension = originalFilename.substring(originalFilename.indexOf(".") + 1);
                Files.copy(file.getInputStream(), root.resolve(fileName + "." + extension));

                NewEstateEvent.Payload payload = eventPayloadUtil.createNewEstateEventPayload(estateDto, fileName, extension);
                NewEstateEvent event = NewEstateEvent.builder().build();
                eventUtil.populateEventFields(event, EventType.NEW_ESTATE_EVENT, entityId, VERSION, payload);
                eventSender.send(event);
            }
        } else {
            throw new FileNotProvidedException();
        }
    }
}
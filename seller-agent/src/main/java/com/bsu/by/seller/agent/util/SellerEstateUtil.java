package com.bsu.by.seller.agent.util;

import com.bsu.by.seller.agent.dto.request.EstateDto;
import com.bsu.by.seller.agent.exception.conflict.FolderCreationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.apache.tika.mime.MimeTypeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class SellerEstateUtil {
    @Value("${upload.path}")
    private String uploadPath;

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(Paths.get(uploadPath));
        } catch (IOException e) {
            throw new FolderCreationException(uploadPath);
        }
    }

    public void checkExtension(MultipartFile file) throws IOException, MimeTypeException {
        Tika tika = new Tika();
        String fileType = tika.detect(file.getBytes());
        if (!(Objects.equals(fileType, MediaType.IMAGE_PNG_VALUE)
                || Objects.equals(fileType, MediaType.IMAGE_JPEG_VALUE))
        ) {
            throw new MimeTypeException(String.format("Invalid file extension '%s'", fileType));
        }
    }

    public EstateDto parseJsonToEstate(String estateJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(estateJson, EstateDto.class);
    }
}

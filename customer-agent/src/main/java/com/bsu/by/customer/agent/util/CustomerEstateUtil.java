package com.bsu.by.customer.agent.util;

import com.bsu.by.customer.agent.dto.request.EstateFilter;
import com.bsu.by.customer.agent.dto.response.success.EstateDto;
import com.bsu.by.customer.agent.exception.FileReadException;
import com.bsu.by.customer.agent.exception.notfound.EstateNotFoundException;
import com.bsu.by.customer.agent.model.Estate;
import com.bsu.by.customer.agent.repository.EstateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomerEstateUtil {
    @Value("${upload.path}")
    private String uploadPath;

    private final EstateRepository estateRepository;

    public byte[] getFile(String fileName) {
        File file = new File(uploadPath + File.separator + fileName);
        byte[] result;
        try {
            result = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            throw new FileReadException(e.getMessage());
        }
        return result;
    }

    public EstateDto createEstateDto(Estate estate) {
        return EstateDto.builder()
                .id(estate.getId())
                .apartment(estate.isApartment())
                .location(estate.getLocation())
                .area(estate.getArea())
                .description(estate.getDescription())
                .build();
    }

    public EstateFilter createEstateFilter(boolean apartment, String location,
                                           double minArea, double maxArea) {
        return EstateFilter.builder()
                .apartment(apartment)
                .location(location)
                .minArea(minArea)
                .maxArea(maxArea)
                .build();
    }

    public Estate findEstateById(String estateId) {
        return estateRepository.findById(estateId)
                .orElseThrow(() -> {
                    log.error("Estate with id='{}' not found", estateId);
                    throw new EstateNotFoundException(estateId);
                });
    }
}

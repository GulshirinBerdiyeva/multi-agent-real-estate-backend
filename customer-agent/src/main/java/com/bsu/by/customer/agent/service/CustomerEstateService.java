package com.bsu.by.customer.agent.service;

import com.bsu.by.customer.agent.dto.request.EstateFilter;
import com.bsu.by.customer.agent.dto.response.success.EstateDto;
import com.bsu.by.customer.agent.model.Estate;
import com.bsu.by.customer.agent.repository.EstateRepository;
import com.bsu.by.customer.agent.util.CustomerEstateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerEstateService {
    private final CustomerEstateUtil customerEstateUtil;
    private final EstateRepository estateRepository;

    @Transactional(readOnly = true)
    public List<EstateDto> getEstates(EstateFilter estateFilter, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Estate> estates = estateRepository.findAll(pageable);

        List<Estate> filteredEstates;
        boolean apartment = estateFilter.isApartment();
        filteredEstates = estates.stream()
                .filter(estate -> estate.isApartment() == apartment)
                .toList();

        String location = estateFilter.getLocation();
        if (!Objects.isNull(location)) {
            filteredEstates = filteredEstates.stream()
                    .filter(estate -> estate.getLocation().toLowerCase().contains(location.toLowerCase()))
                    .toList();
        }

        double minArea = estateFilter.getMinArea();
        double maxArea = estateFilter.getMaxArea();
        if (minArea > 0 && maxArea > 0) {
            filteredEstates = filteredEstates.stream()
                    .filter(estate -> estate.getArea() >= minArea && estate.getArea() <= maxArea)
                    .toList();
        }

        List<EstateDto> estateDtoList = new ArrayList<>();
        filteredEstates.forEach(estate -> estateDtoList.add(customerEstateUtil.createEstateDto(estate)));

        return estateDtoList;
    }

    @Transactional(readOnly = true)
    public byte[] getFile(String id) {
        Estate estate = customerEstateUtil.findEstateById(id);
        return customerEstateUtil.getFile(estate.getFileName());
    }
}

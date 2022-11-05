package com.bsu.by.customer.agent.controller;

import com.bsu.by.customer.agent.dto.request.EstateFilter;
import com.bsu.by.customer.agent.dto.response.success.EstateDto;
import com.bsu.by.customer.agent.service.CustomerEstateService;
import com.bsu.by.customer.agent.util.CustomerEstateUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/v1/estates")
@RequiredArgsConstructor
@Slf4j
public class CustomerEstateController {
    private static final int MIN_PAGE_VALUE = 0;
    private static final int MIN_SIZE_VALUE = 1;

    private final CustomerEstateService customerEstateService;
    private final CustomerEstateUtil customerEstateUtil;

    @GetMapping
    @PreAuthorize("hasAuthority(T(com.bsu.by.customer.agent.security.AuthorityType).VIEW_ESTATE)")
    @Operation(summary = "View estates")
    public List<EstateDto> getEstates(@RequestParam(defaultValue = "true") boolean apartment,
                                      @RequestParam(defaultValue = "Minsk") String location,
                                      @RequestParam(defaultValue = "30") double minArea,
                                      @RequestParam(defaultValue = "100") double maxArea,
                                      @RequestParam(defaultValue = "0") @Min(MIN_PAGE_VALUE) int page,
                                      @RequestParam(defaultValue = "10") @Min(MIN_SIZE_VALUE) int size) {
        EstateFilter estateFilter = customerEstateUtil.createEstateFilter(apartment, location, minArea, maxArea);
        return customerEstateService.getEstates(estateFilter, page, size);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @PreAuthorize("hasAuthority(T(com.bsu.by.customer.agent.security.AuthorityType).VIEW_ESTATE)")
    @Operation(summary = "View estate photo")
    public byte[] getFile(@PathVariable String id) {
        return customerEstateService.getFile(id);
    }
}

package com.bsu.by.seller.agent.controller;

import com.bsu.by.seller.agent.dto.request.EstateDto;
import com.bsu.by.seller.agent.dto.response.SuccessResponse;
import com.bsu.by.seller.agent.service.SellerEstateService;
import com.bsu.by.seller.agent.util.SellerEstateUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.mime.MimeTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/estates")
@RequiredArgsConstructor
@Slf4j
public class SellerEstateController {
    private final SellerEstateService sellerEstateService;
    private final SellerEstateUtil sellerEstateUtil;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAuthority(T(com.bsu.by.seller.agent.security.AuthorityType).SELL_ESTATE)")
    @Operation(summary = "Save new estate")
    public SuccessResponse saveEstate(@Valid @RequestPart("estateJson") String estateJson,
                                      @RequestParam("file") MultipartFile file) throws IOException, MimeTypeException {
        EstateDto estateDto = sellerEstateUtil.parseJsonToEstate(estateJson);
        sellerEstateService.saveEstate(estateDto, file);
        return new SuccessResponse("Estate saved successfully");
    }
}
package com.bsu.by.seller.agent.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstateDto {
    @NotNull
    @Schema(example = "true|false")
    private boolean apartment;

    @NotNull
    @Schema(example = "Minsk")
    private String location;

    @NotNull
    @Schema(example = "50")
    private double area;

    @NotNull
    @Schema(example = "your best choice...")
    private String description;
}

package com.bsu.by.customer.agent.dto.response.success;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstateDto {
    private String id;
    private boolean apartment;
    private String location;
    private double area;
    private String description;
}

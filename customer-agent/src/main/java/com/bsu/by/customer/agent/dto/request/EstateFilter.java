package com.bsu.by.customer.agent.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstateFilter {
    private boolean apartment;
    private String location;
    private double minArea;
    private double maxArea;
}

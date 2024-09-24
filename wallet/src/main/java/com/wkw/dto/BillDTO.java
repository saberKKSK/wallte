package com.wkw.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillDTO {
    private BigDecimal price;

    private Float duration;

    private String rank;
}

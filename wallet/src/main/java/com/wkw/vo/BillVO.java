package com.wkw.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillVO {
    private BigDecimal price;
    private Float duration;
    private String rank;
}

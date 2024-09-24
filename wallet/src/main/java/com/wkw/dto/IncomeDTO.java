package com.wkw.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class IncomeDTO {
   private BigDecimal Income;
   private List <BillDTO> billDTOS;
}

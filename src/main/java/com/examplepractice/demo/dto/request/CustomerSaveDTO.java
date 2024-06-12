package com.examplepractice.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerSaveDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
//    private int contactNumbers;
    private String customerNic;
    private boolean activeState;

}

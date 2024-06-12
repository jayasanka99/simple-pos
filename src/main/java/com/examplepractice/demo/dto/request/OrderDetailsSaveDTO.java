package com.examplepractice.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDetailsSaveDTO {

    private String itemName;
    private double amount;
    private double qty;
    private int order;
    private int item;

}

package com.examplepractice.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDTO {
    //customer
    private String customerName;
    private String customerAddress;
    private String customerNic;

    //order
    private Date date;
    private Double total;
}

package com.examplepractice.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderSaveDTO {

    private int customerId;
    private Date date;
    private Double total;
    private List<OrderDetailsSaveDTO> orderDetails;
    private boolean activeState;

}

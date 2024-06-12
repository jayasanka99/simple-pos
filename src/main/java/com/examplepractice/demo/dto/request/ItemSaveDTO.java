package com.examplepractice.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemSaveDTO {

    private int itemId;
    private String itemName;
    private String measureType;
    private int totalQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;

}

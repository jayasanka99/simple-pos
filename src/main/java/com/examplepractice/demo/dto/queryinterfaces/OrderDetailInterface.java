package com.examplepractice.demo.dto.queryinterfaces;

import java.util.Date;

public interface OrderDetailInterface {

    String getCustomerName();
    String getCustomerAddress();
    String getCustomerNic();
    Date getDate();
    Double getTotal();

}

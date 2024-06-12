package com.examplepractice.demo.service;


import com.examplepractice.demo.dto.request.OrderSaveDTO;
import com.examplepractice.demo.paginated.PaginatedOrderDetailsResponseDTO;

public interface OrderService {

    String addOrder(OrderSaveDTO orderSaveDTO);

    PaginatedOrderDetailsResponseDTO getOrderDetails(boolean state, int page, int size);
}

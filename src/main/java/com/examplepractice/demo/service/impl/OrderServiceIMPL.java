package com.examplepractice.demo.service.impl;

import com.examplepractice.demo.dto.queryinterfaces.OrderDetailInterface;
import com.examplepractice.demo.dto.request.OrderSaveDTO;
import com.examplepractice.demo.dto.response.OrderDetailsDTO;
import com.examplepractice.demo.entity.Order;
import com.examplepractice.demo.entity.OrderDetails;
import com.examplepractice.demo.paginated.PaginatedOrderDetailsResponseDTO;
import com.examplepractice.demo.repo.CustomerRepo;
import com.examplepractice.demo.repo.ItemRepo;
import com.examplepractice.demo.repo.OrderDetailRepo;
import com.examplepractice.demo.repo.OrderRepo;
import com.examplepractice.demo.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceIMPL implements OrderService {

    private final OrderRepo orderRepo;
    private final ModelMapper modelMapper;
    private final CustomerRepo customerRepo;
    private final OrderDetailRepo orderDetailRepo;
    private final ItemRepo itemRepo;

    @Override
    @Transactional
    public String addOrder(OrderSaveDTO orderSaveDTO) {
        Order order = new Order(
                customerRepo.getById(orderSaveDTO.getCustomerId()),
                orderSaveDTO.getDate(),
                orderSaveDTO.getTotal()
        );
        orderRepo.save(order);

        if (orderRepo.existsById(order.getOrderId())) {
            List<OrderDetails> orderDetailsList = modelMapper
                    .map(orderSaveDTO.getOrderDetails(), new TypeToken<List<OrderDetails>>() {
                    }
                            .getType());
            for (int i = 0; i < orderDetailsList.size(); i++) {
                orderDetailsList.get(i).setOrder(order);
                orderDetailsList.get(i).setItem(itemRepo.getById(orderSaveDTO.getOrderDetails().get(i).getItem()));
            }
            if (orderDetailsList.size() > 0) {
                orderDetailRepo.saveAll(orderDetailsList);
            }
            return "Saved";
        }
        return null;
    }

    @Override
    public PaginatedOrderDetailsResponseDTO getOrderDetails(boolean state, int page, int size) {
//repo ekt call krla OrderDetailsDTO ekt data add kara ganna ba (table dekakin data ena nisa) ekta interface ekk use karnawa (OrderDetailInterface)
        List<OrderDetailInterface> orderDetailsInterface = orderRepo.getOrderDetails(state, PageRequest.of(page, size));
//        System.out.println("come " +orderDetailsDTOS.get(0).getCustomerName());
//        service ----> controller(DTO)
//orderDetailsInterface (Type method data) ---> OrderDetailsDTO (DTO type)
        List<OrderDetailsDTO> list = modelMapper.map(orderDetailsInterface, new TypeToken<List<OrderDetailsDTO>>() {}.getType());

//        for (OrderDetailInterface o : orderDetailsDTOS) {
//            OrderDetailsDTO r = new OrderDetailsDTO(
//                    o.getCustomerName(),
//                    o.getCustomerAddress(),
//                    o.getCustomerNic(),
//                    o.getDate(),
//                    o.getTotal()
//            );
//            list.add(r);
//        }
        PaginatedOrderDetailsResponseDTO paginatedOrderDetailsResponseDTO = new PaginatedOrderDetailsResponseDTO(
//              List<OrderDetailsDTO> of PaginatedOrderDetailsResponseDTO
                list,
                orderRepo.countAllOrders(state)
        );
//row 71 wla create krpu list eka return karanna ba mokd apen illanne PaginatedOrderDetailsResponseDTO type nisa.
        return paginatedOrderDetailsResponseDTO;
    }
}

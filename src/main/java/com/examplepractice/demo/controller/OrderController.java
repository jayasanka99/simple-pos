package com.examplepractice.demo.controller;

import com.examplepractice.demo.dto.request.OrderSaveDTO;
import com.examplepractice.demo.paginated.PaginatedOrderDetailsResponseDTO;
import com.examplepractice.demo.service.OrderService;
import com.examplepractice.demo.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/order")
@RequiredArgsConstructor

public class OrderController {

    private final OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody OrderSaveDTO orderSaveDTO) {
       String id = orderService.addOrder(orderSaveDTO);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"Success",id),
                HttpStatus.CREATED);
    }

    @GetMapping(
            params = {"stateType","page","size"},
            path = {"/get-order-details"}
    )
    public ResponseEntity<StandardResponse> getOrderDetails(
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ){
        PaginatedOrderDetailsResponseDTO p = new PaginatedOrderDetailsResponseDTO();
        if (stateType.equalsIgnoreCase("active")| stateType.equalsIgnoreCase("inactive")) {
            boolean state = stateType.equalsIgnoreCase("active");
            p = orderService.getOrderDetails(state,page,size);
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",p)
                ,HttpStatus.OK
        );
    }
}

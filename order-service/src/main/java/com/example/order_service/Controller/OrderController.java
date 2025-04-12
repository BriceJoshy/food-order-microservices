package com.example.order_service.Controller;


import com.example.order_service.Dto.ResponseDto;
import com.example.order_service.Entity.OrderModel;
import com.example.order_service.Service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createOrder(@Valid @RequestBody OrderModel orderModel){
        var orders = OrderModel.builder()
                        .customerName(orderModel.getCustomerName())
                        .foodList(orderModel.getFoodList()).build();
        var res = orderService.createOrder(orders);
        var response = getResponseDto("Order created with id: " + res.getId(),
                HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private static ResponseDto getResponseDto(Object message, HttpStatus status) {
        var response = ResponseDto.builder()
                .message(message)
                .status(status)
                .build();
        return response;
    }
}

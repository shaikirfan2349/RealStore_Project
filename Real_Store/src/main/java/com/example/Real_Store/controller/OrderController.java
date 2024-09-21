package com.example.Real_Store.controller;

import com.example.Real_Store.dto.BookingDTO;
import com.example.Real_Store.dto.ProductDTO;
import com.example.Real_Store.entity.Product;
import com.example.Real_Store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    public OrderService orderService;

    @PostMapping ("/addProductToOrder")
    public String  addProductToorder(@RequestBody List<ProductDTO> productDTOList){
        return orderService.addProductToOrder(productDTOList);
    }

    @PostMapping("/getOrderConfirmation")
    public String getOrderConfirmation(@RequestParam("orderId") Long orderId){
        return orderService.getOrderConfirm(orderId);
    }

    //delete
}

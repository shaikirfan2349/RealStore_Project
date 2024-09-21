package com.example.Real_Store.service;

import com.example.Real_Store.dto.BookingDTO;
import com.example.Real_Store.dto.ProductDTO;

import java.util.List;

public interface OrderService {
    String addProductToOrder(List<ProductDTO> productDTOList);

    String getOrderConfirm(Long orderId);
}

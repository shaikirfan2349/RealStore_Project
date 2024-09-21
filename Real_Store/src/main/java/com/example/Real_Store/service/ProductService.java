package com.example.Real_Store.service;

import com.example.Real_Store.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO addProductToCategory(ProductDTO productDTO,Long categoryId) throws Exception;

    ProductDTO getProductById(Long productId) throws Exception;

    List<ProductDTO> getAllProduct();

    String addProductToCustomer(Long productId, Long customerId) throws Exception;

    String deleteProductById(Long productId);

    ProductDTO updateProductByDTO(ProductDTO productDTO);
}

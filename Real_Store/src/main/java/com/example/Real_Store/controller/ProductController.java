package com.example.Real_Store.controller;

import com.example.Real_Store.dto.ProductDTO;
import com.example.Real_Store.service.CustomerService;
import com.example.Real_Store.service.ProductService;
import com.example.Real_Store.service.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    public ProductService productService;

    @PostMapping("/addProduct")
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO, @RequestParam("categoryId") Long categoryId) throws Exception {
        return productService.addProductToCategory(productDTO,categoryId);
    }

    @PostMapping("/addProductToCustomer")
    public String addProductToCustomer(@RequestParam("productId") Long productId, @RequestParam("customerId") Long customerId) throws Exception {
        return productService.addProductToCustomer(productId,customerId);
    }

    @GetMapping("/getProductById")
    public ProductDTO getProductById(@RequestParam ("productId") Long productId) throws Exception {
        return productService.getProductById(productId);
    }

    @GetMapping("/getAllProducts")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProduct();
    }

    @DeleteMapping("/deleteProductById")
    public String deleteProduct(@RequestParam("productId")Long productId){
        return productService.deleteProductById(productId);
    }

    @PutMapping("/updateProduct")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO){
        return productService.updateProductByDTO(productDTO);
    }

}

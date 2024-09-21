package com.example.Real_Store.service.serviceImpl;

import com.example.Real_Store.constants.RealStoreConstants;
import com.example.Real_Store.conversion.ConversionClass;
import com.example.Real_Store.dto.ProductDTO;
import com.example.Real_Store.entity.Booking;
import com.example.Real_Store.entity.Category;
import com.example.Real_Store.entity.Customer;
import com.example.Real_Store.entity.Product;
import com.example.Real_Store.enumeration.StockStatus;
import com.example.Real_Store.repository.CategoryRepository;
import com.example.Real_Store.repository.CustomerRepository;
import com.example.Real_Store.repository.OrderRepository;
import com.example.Real_Store.repository.ProductRepository;
import com.example.Real_Store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.Real_Store.constants.RealStoreConstants.ACTIVE;
import static com.example.Real_Store.constants.RealStoreConstants.INACTIVE;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    public ConversionClass conversionClass;
    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public CustomerRepository customerRepository;
    @Autowired
    public OrderRepository orderRepository;

    @Override
    public ProductDTO addProductToCategory(ProductDTO productDTO, Long categoryId) throws Exception {
        Category category = categoryRepository.findById(categoryId).get();
        try{
            if(Objects.nonNull(category)){
                Product product = conversionClass.ProductDTO_To_Product(productDTO);
                product.setCategory(category);
                product.setProductStatus(ACTIVE);
                product.setStockStatus(StockStatus.In_Stock);
                productRepository.save(product);
                ProductDTO product1 = conversionClass.Product_To_ProductDTO(product);
                return product1;
            }
        }catch (Exception e){
            throw new Exception("categoryId not found",e);
        }
        return null;
    }

    @Override
    public ProductDTO getProductById(Long productId) throws Exception {
        try{
            if(productId!=null){
                Product product = productRepository.findById(productId).get();
//                Category category = product.getCategory();
                ProductDTO productDTO = conversionClass.Product_To_ProductDTO(product);
//                productDTO.setCategoryName(category.getName());   ---> method2
                return productDTO;
            }
        }catch (Exception e){
            throw new Exception("productId not found");
        }
        return null;
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        return productList.
                stream().
                map(product -> conversionClass.Product_To_ProductDTO(product)).
                collect(Collectors.toList());
    }

    @Override
    public String addProductToCustomer(Long productId, Long customerId) throws Exception {
        Product product = productRepository.findById(productId).get();

        Customer customer = customerRepository.findById(customerId).get();
        if(product.getProductStatus().equals(ACTIVE) ) {
            if (product.getStockQuantity() > 0 && product.getStockStatus().equals(StockStatus.In_Stock)) {
                customer.getProductList().add(product);
                customerRepository.save(customer);

                return "product added to customer";
            } else {
                product.setStockStatus(StockStatus.Out_Stock);
                productRepository.save(product);
                return "product is Out of Stock";
            }

        }

        return  "product is InActive";
    }

    @Override
    public String deleteProductById(Long productId) {
        Product product = productRepository.findById(productId).get();
        product.setProductStatus(INACTIVE);
        productRepository.save(product);
        return "Product has been deleted";
    }

    @Override
    public ProductDTO updateProductByDTO(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getProductid()).get();
        return setProductAttributes(product,productDTO);

    }

    private ProductDTO setProductAttributes(Product product, ProductDTO productDTO) {
        product.setProductId(productDTO.getProductid());

        if(productDTO.getName() != null){
            product.setName(productDTO.getName());
        }
        if (productDTO.getDescription() != null) {
            product.setDescription(productDTO.getDescription());
        }
        if (productDTO.getStockQuantity() != '\0') {
            product.setStockQuantity(productDTO.getStockQuantity());
            product.setStockStatus(StockStatus.In_Stock);
        }
        if (productDTO.getPrice() != 0) {
            product.setPrice(productDTO.getPrice());
        }

        productRepository.save(product);
        return conversionClass.Product_To_ProductDTO(product);
    }


}

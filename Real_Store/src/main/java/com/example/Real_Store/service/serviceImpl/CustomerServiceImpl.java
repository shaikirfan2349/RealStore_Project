package com.example.Real_Store.service.serviceImpl;

import com.example.Real_Store.conversion.ConversionClass;
import com.example.Real_Store.dto.CustomerDTO;
import com.example.Real_Store.entity.Booking;
import com.example.Real_Store.entity.Customer;
import com.example.Real_Store.repository.CustomerRepository;
import com.example.Real_Store.repository.OrderRepository;
import com.example.Real_Store.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    public ConversionClass conversionClass;
    @Autowired
    public CustomerRepository customerRepository;
    @Autowired
    public OrderRepository orderRepository;

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) throws Exception {
        if(Objects.nonNull(customerDTO)){
            Customer customer = conversionClass.CustomerDTO_To_CustomerEntity(customerDTO);
            customerRepository.save(customer);
            return conversionClass.CustomerEntity_To_CustomerDTO(customer);
        }else{
            throw new Exception("customerDTO should not be Null");
        }
    }

    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById (customerId).get();
        return conversionClass.CustomerEntity_To_CustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.
                findAll().stream().
                map(customer -> convertCustomerToCustomerDTO(customer)).toList();
    }

    @Override
    public void addOrderToCustomer(Long customerId, Long orderId) {
        Customer customer = customerRepository.findById(customerId).get();
        Booking booking = orderRepository.findById(orderId).get();
        customer.getOrderList().add(booking);
        booking.setCustomer(customer);
        orderRepository.save(booking);
    }

    public CustomerDTO convertCustomerToCustomerDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setPhoneNo(customer.getPhoneNo());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setAddress(customer.getAddress());
        return customerDTO;
    }


}

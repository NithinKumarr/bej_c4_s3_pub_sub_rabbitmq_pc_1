package com.example.C13_S3_demo.service;


import org.json.simple.JSONObject;
import com.example.C13_S3_demo.config.ProductDTO;
import com.example.C13_S3_demo.domain.Product;
import com.example.C13_S3_demo.domain.User;
import com.example.C13_S3_demo.exception.CustomerAlreadyExistsException;
import com.example.C13_S3_demo.exception.CustomerNotFoundException;
//import com.example.C13_S3_demo.proxy.UserProxy;
import com.example.C13_S3_demo.repository.ICustomerRepository;
import lombok.AllArgsConstructor;
import org.bson.json.JsonObject;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {
ICustomerRepository userRepository;

    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;
//UserProxy userProxy;
    @Override
    public User addCustomer(User customer) throws CustomerAlreadyExistsException {
    if(userRepository.findById(customer.getEmailId()).isEmpty()){
//        userProxy.saveUser(customer);
        return userRepository.save(customer);
    }
    throw new CustomerAlreadyExistsException();
}

    @Override
    public User saveUserProductToList(Product product, String email) throws CustomerNotFoundException {

        if(userRepository.findById(email).isEmpty()){
            throw new CustomerNotFoundException();
        }
        User user=userRepository.findById(email).get();
        if(user.getProduct()!=null){
            user.getProduct().add(product);
        }
        else {
            user.setProduct(new ArrayList<>());
            user.getProduct().add(product);
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public List<Product> getAllProductsUser(String email) throws CustomerNotFoundException {

        if(userRepository.findById(email).isEmpty()){
            throw new CustomerNotFoundException();
        }
        List<Product> allProducts=userRepository.findById(email).get().getProduct();
        List<Product> notInterested=new ArrayList<>();
        for(Product c: allProducts){
            if(!c.isInterested()){
                notInterested.add(c);
            }
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("product_list",notInterested);
        jsonObject.put("email",email);

        ProductDTO productDTO=new ProductDTO(jsonObject);
        rabbitTemplate.convertAndSend(directExchange.getName(),"product_routing",productDTO);
//        System.out.println("SEND SUCCESSFULLY"+directExchange.getName()+productDTO);
        return allProducts;

    }


    @Override
    public List<User> getAllCustomer() {
        return userRepository.findAll();
    }

//    @Override
//    public boolean deleteCustomer(String customerId) throws CustomerNotFoundException {
//       if(customerRepository.findById(customerId).isEmpty()){
//           throw new CustomerNotFoundException();
//       }
//       customerRepository.deleteById(customerId);
//       return true;
//    }
//    @Override
//    public List<User> getAllCustomerByproductName(String productName) {
//        return customerRepository.findTheCustomerByproductName(productName);
//    }
}

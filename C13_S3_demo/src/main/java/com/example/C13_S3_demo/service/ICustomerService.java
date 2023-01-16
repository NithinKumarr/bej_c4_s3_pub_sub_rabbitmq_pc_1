package com.example.C13_S3_demo.service;

import com.example.C13_S3_demo.domain.Product;
import com.example.C13_S3_demo.domain.User;
import com.example.C13_S3_demo.exception.CustomerAlreadyExistsException;
import com.example.C13_S3_demo.exception.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {
    public User addCustomer(User customer) throws CustomerAlreadyExistsException;
    public User saveUserProductToList(Product product,String email) throws CustomerNotFoundException;
    public List<Product> getAllProductsUser(String email) throws CustomerNotFoundException;

    public List<User> getAllCustomer();
//    public List<User> getAllCustomerByproductName(String city);

}

package com.example.C13_S3_demo.controller;

import com.example.C13_S3_demo.domain.Product;
import com.example.C13_S3_demo.domain.User;
import com.example.C13_S3_demo.exception.CustomerAlreadyExistsException;
import com.example.C13_S3_demo.exception.CustomerNotFoundException;
import com.example.C13_S3_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productservice")
public class CustomerController {
    CustomerService customerService;
    ResponseEntity responseEntity;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveCustomer(@RequestBody User customer) throws CustomerAlreadyExistsException {
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }
    @GetMapping("/customers")
    public ResponseEntity<?> getCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }


    @PostMapping("/User/{email}")
    public ResponseEntity<?> saveUserProductToList(@RequestBody Product product, @PathVariable String email)  {
        try {
            responseEntity = new ResponseEntity<>(customerService.saveUserProductToList(product, email), HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return responseEntity;
    }
    @GetMapping("/User/{email}")
    public ResponseEntity<?> getAllProductMovies(@PathVariable String email) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.getAllProductsUser(email),HttpStatus.OK);

    }
//    @DeleteMapping("customer/{id}")
//    public ResponseEntity<?> deleteCustomers(@PathVariable String id) throws CustomerNotFoundException {
//        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
//    }
//    @GetMapping("/customers/{name}")
//    public ResponseEntity<?> getAllTheCustomersByCity(@PathVariable String name){
//        return new ResponseEntity<>(customerService.getAllCustomerByproductName(name), HttpStatus.OK);
//    }
}

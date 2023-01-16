//package com.example.C13_S3_demo.repositoryTest;
//
//import com.example.C13_S3_demo.domain.User;
//import com.example.C13_S3_demo.domain.Product;
//import com.example.C13_S3_demo.repository.ICustomerRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class CustomerRepositoryTest {
//    @Autowired
//    private ICustomerRepository customerRepository;
//    private User customer;
//    private Product product;
//    private User customer1;
//    private Product product1;
//    private List<User> customerList;
//
//    @BeforeEach
//    public void setUp(){
//        this.product=new Product(1001,"mobile","good product");
//        this.customer=new User(101,"sam",897654321,product);
//        this.product1=new Product(1003,"laptop","good product");
//        this.customer1=new User(103,"peter",897654321,product1);
//    }
//
//    @Test
//    @DisplayName("Test to save customer")
//    public void SaveCustomerShouldReturnCustomer(){
//        customerRepository.save(customer);//save
//        User c1=customerRepository.findById(customer.getCustomerId()).get();//fetch
//        assertEquals(customer,c1);
//    }
//    @Test
//    @DisplayName("Test to delete the customers")
//    public void GivenCustomerToDeleteShouldDeleteIt(){
//        customerRepository.save(customer);
//        User c1=customerRepository.findById(customer.getCustomerId()).get();
//        customerRepository.delete(c1);
//        assertEquals(Optional.empty(),customerRepository.findById(customer.getCustomerId()));
//    }
//
//    @Test
//    @DisplayName("Test to get all customer data")
//    public void givenCustomerReturnAllTheCustomer(){
//        customerRepository.deleteAll();
//        customerRepository.save(customer);
//        customerRepository.save(customer1);
//        List<User> allCustomers=customerRepository.findAll();
//        assertEquals(2,allCustomers.size());
//    }
//
//    @Test
//    @DisplayName("Test to get Customer by Product name")
//    public void givenProductNameReturnCustomers(){
//        customerRepository.deleteAll();
//        customerRepository.save(customer);
//        customerRepository.save(customer1);
//        List<User> allCustomers=customerRepository.findTheCustomerByproductName("mobile");
//        assertEquals(1,allCustomers.size());
//    }
//    @AfterEach
//    public void clean(){
//        this.product=null;
//        this.customer=null;
//    }
//}

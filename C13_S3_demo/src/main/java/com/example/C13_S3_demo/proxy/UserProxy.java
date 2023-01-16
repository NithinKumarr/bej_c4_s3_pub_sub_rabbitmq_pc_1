//package com.example.C13_S3_demo.proxy;
//
//import com.example.C13_S3_demo.domain.User;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@FeignClient(name="User-service",url = "localhost:8039")
//public interface UserProxy {
//
//    @PostMapping("/api/userService/register")
//    public ResponseEntity<?> saveUser(@RequestBody User user);
//}

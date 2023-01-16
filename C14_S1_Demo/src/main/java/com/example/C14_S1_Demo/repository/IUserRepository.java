package com.example.C14_S1_Demo.repository;

import com.example.C14_S1_Demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,String> {
}

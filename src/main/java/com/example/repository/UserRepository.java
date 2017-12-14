package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByAddress(String address);

    User findByNameAndAddress(String name,String address);

    User withEmailAndPasswordQuery(@Param("email")String email,@Param("password")String password);

//    User withNameAndAddressNamedQuery(String name,String address);

}

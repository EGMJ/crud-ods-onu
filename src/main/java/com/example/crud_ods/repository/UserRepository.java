package com.example.crud_ods.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.crud_ods.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}

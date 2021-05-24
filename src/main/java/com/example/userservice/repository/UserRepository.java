package com.example.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.userservice.Entity.User;

public interface UserRepository extends MongoRepository<User, Integer> {


}

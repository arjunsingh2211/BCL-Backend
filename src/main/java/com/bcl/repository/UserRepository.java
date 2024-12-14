package com.bcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcl.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

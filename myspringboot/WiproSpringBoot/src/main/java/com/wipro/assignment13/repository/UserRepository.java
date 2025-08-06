package com.wipro.assignment13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.assignment13.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
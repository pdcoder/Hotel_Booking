package com.example.demo.Repository;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}

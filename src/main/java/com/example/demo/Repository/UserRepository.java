package com.example.demo.Repository;

import com.example.demo.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Contact,Long> {
}

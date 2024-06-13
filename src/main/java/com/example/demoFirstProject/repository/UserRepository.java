package com.example.demoFirstProject.repository;

import com.example.demoFirstProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

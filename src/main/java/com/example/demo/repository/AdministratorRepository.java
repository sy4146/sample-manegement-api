package com.example.demo.repository;

import com.example.demo.domain.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    // 標準的なCRUDメソッドが使える
}
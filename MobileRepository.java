package com.example.demo.repository;

import com.example.demo.model.MobileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<MobileModel, Long> {
}
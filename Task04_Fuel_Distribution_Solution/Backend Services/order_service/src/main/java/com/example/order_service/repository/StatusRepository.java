package com.example.order_service.repository;

import com.example.order_service.model.Order_status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Order_status,Integer> {
}

package com.example.order_service.repository;

import com.example.order_service.model.Order_fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order_fuel,Integer> {
}

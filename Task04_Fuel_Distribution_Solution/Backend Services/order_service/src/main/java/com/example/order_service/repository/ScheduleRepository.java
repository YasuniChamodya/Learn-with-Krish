package com.example.order_service.repository;

import com.example.order_service.model.Schedule_orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule_orders,Integer> {
}

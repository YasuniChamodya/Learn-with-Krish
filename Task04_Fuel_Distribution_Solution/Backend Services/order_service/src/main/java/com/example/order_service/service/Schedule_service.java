package com.example.order_service.service;

import com.example.order_service.model.Schedule_orders;

import java.util.Optional;

public interface Schedule_service {
    Schedule_orders save(Schedule_orders schedule_orders);

    Schedule_orders findById(int id);
}

package com.example.order_service.service;

import com.example.order_service.model.Order_status;

import java.util.List;
import java.util.Optional;


public interface StatusService {
    Order_status save(Order_status order_status);
    List<Order_status> findAll();
    Order_status findById(int id);
    Order_status updateDeliverStatus(int id);
}

package com.example.order_service.service;

import com.example.order_service.Order_Model.Order_Data;
import com.example.order_service.model.Order_fuel;

import java.util.List;
import java.util.Optional;

public interface Order_service {
    Order_fuel save(Order_fuel order);
    List<Order_fuel> findAll();
    Optional<Order_fuel> findById(int id);
    List<Order_Data> findStatusSuccessData();
    List<Order_Data> findDispatchedOrders();
    List<Order_Data> findDeliveredOrders();
    List<Order_Data> findOrdersByGasStationId(String id);

}

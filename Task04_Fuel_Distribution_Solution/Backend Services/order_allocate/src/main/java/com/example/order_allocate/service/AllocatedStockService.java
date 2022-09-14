package com.example.order_allocate.service;//package com.example.allocation_service.service;


import com.example.order_allocate.model.Allowcated_stock;

import java.util.List;

public interface AllocatedStockService {
    Allowcated_stock save(Allowcated_stock order);

    double allocatedOrders();
    List<Allowcated_stock> findAll();
    void delete(int id);
}

package com.example.order_allocate.service;//package com.example.allocation_service.service;




import com.example.order_allocate.model.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    Stock save(Stock stock);
   Optional<Stock> get(int id);
   List<Stock> findAll();


}

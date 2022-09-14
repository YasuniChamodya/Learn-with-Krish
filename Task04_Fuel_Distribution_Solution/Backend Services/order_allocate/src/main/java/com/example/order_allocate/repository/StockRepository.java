package com.example.order_allocate.repository;//package com.example.allocation_service.repository;


import com.example.order_allocate.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StockRepository extends JpaRepository<Stock,Integer> {
}

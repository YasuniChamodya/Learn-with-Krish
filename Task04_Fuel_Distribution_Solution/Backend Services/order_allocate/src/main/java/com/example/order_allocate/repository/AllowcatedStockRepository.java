package com.example.order_allocate.repository;//package com.example.allocation_service.repository;


import com.example.order_allocate.model.Allowcated_stock;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AllowcatedStockRepository extends JpaRepository<Allowcated_stock,Integer> {
}

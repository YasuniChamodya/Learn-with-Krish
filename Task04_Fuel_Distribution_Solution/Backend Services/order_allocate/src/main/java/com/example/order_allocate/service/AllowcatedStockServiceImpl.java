package com.example.order_allocate.service;


import com.example.order_allocate.model.Allowcated_stock;
import com.example.order_allocate.repository.AllowcatedStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllowcatedStockServiceImpl implements AllocatedStockService{
    @Autowired
 private AllowcatedStockRepository allowcatedStockRepository;
    @Override
    public Allowcated_stock save(Allowcated_stock order) {
        return allowcatedStockRepository.save(order);
    }

    @Override
    public double allocatedOrders() {
        double d=0;
        List<Allowcated_stock> allowcated_stocks =allowcatedStockRepository.findAll();
        for (Allowcated_stock a:allowcated_stocks){
            d+=a.getQty();

        }
        System.out.println(d+"     value");
        return d;
    }

    @Override
    public List<Allowcated_stock> findAll() {
        return allowcatedStockRepository.findAll();
    }

    @Override
    public void delete(int id) {
        allowcatedStockRepository.deleteById(id);
    }


}

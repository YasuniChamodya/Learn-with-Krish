package com.example.order_allocate.controller;



import com.example.order_allocate.ObjectModel.StockObject;
import com.example.order_allocate.model.Stock;
import com.example.order_allocate.service.AllocatedStockService;
import com.example.order_allocate.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class StockController {



@Autowired
StockService stockService;
@Autowired
AllocatedStockService allocatedStockService;
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public double placeOrder(){
        System.out.println("call rest api");

       return allocatedStockService.allocatedOrders();

    }
    @CrossOrigin
    @RequestMapping(value = "/stock",method = RequestMethod.GET)
    public List<StockObject> getStock(){
        List<StockObject> stockObjectList=new ArrayList<>();
        List<Stock> stock=stockService.findAll();

        for(Stock s:stock){
            StockObject stockObject=new StockObject();
            stockObject.setStockId(s.getStockId());
            stockObject.setType(s.getType());
            stockObject.setAvalableStock(s.getAvalableStock());
            stockObject.setProgress(s.getAvalableStock()*100/50000);
            stockObjectList.add(stockObject);

        }

        return stockObjectList;
    }





}

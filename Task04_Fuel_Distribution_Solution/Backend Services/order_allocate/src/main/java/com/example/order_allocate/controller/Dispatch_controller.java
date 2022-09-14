package com.example.order_allocate.controller;



import com.example.order_allocate.Types.Event;
import com.example.order_allocate.kafka_service.Producer_dispatch;
import com.example.order_allocate.model.Allowcated_stock;
import com.example.order_allocate.model.Dispatch;
import com.example.order_allocate.model.Stock;
import com.example.order_allocate.service.AllocatedStockService;
import com.example.order_allocate.service.Dispatch_service;
import com.example.order_allocate.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@Transactional
public class Dispatch_controller {
    @Autowired
    Dispatch_service dispatch_service;
    @Autowired
    AllocatedStockService allocatedStockService;
    @Autowired
    StockService stockService;
    @Autowired
    Producer_dispatch producer_dispatch;
@CrossOrigin
    @RequestMapping(value = "/dispatch",method = RequestMethod.POST)
    public Dispatch save(@RequestBody Dispatch dispatch){
       List<Allowcated_stock> allowcated_stocks=allocatedStockService.findAll();
       for(Allowcated_stock stock:allowcated_stocks){
           if(stock.getId()==dispatch.getOrderId()){
               System.out.println("not Equal");

               Optional<Stock> stock1=stockService.get(Integer.parseInt(stock.getStockId()));
               double avalableStock=stock1.get().getAvalableStock();
               double dispatchQty=stock.getQty();
               double finalStock=avalableStock-dispatchQty;
               Stock updatedStock=new Stock();
               updatedStock.setStockId(stock1.get().getStockId());
               updatedStock.setAvalableStock(finalStock);
               updatedStock.setType(stock1.get().getType());

                       stockService.save(updatedStock);
                       allocatedStockService.delete(stock.getAllowcatedId());
                       producer_dispatch.publishToTopic(new Event("Dispatch", "complete_dispatch", String.valueOf(dispatch.getOrderId()), "", String.valueOf(dispatch.getOrderId()), String.valueOf(stock1.get().getStockId()), "Success"));
           }

       }


      return dispatch_service.save(dispatch);



    }

    @RequestMapping(value = "/dispatch",method = RequestMethod.GET)
    public List<Dispatch> findAll(){
       return dispatch_service.findAll();

    }

    @RequestMapping(value = "/dispatch",method = RequestMethod.PUT)
    public Dispatch updateReceived(@RequestBody Dispatch dispatch) {
        List<Dispatch> list = dispatch_service.findAll();
        Dispatch newOb = new Dispatch();
        for (Dispatch d : list) {
            if (d.getOrderId() == dispatch.getOrderId()) {

                newOb.setId(d.getId());
                newOb.setOrderId(d.getOrderId());
                newOb.setStatus("Received");
                newOb.setGasStationId(d.getGasStationId());

            }
        }
        return dispatch_service.save(newOb);
    }

}

package com.example.order_allocate.kafka_service;

//import com.example.allocation_service.model.Stock;
//import com.example.allocation_service.service.StockService;
import com.example.order_allocate.Types.Event;
import com.example.order_allocate.model.Allowcated_stock;
import com.example.order_allocate.model.Stock;
import com.example.order_allocate.service.AllocatedStockService;
import com.example.order_allocate.service.StockService;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class Consumer {
    @Autowired
    StockService stockService;
    @Autowired
    AllocatedStockService allocatedStockService;
    @Autowired
    private Producer producer;
    @Autowired
    private Producer_schedule producer_schedule;


    @KafkaListener(topics = "new_order", groupId = "finance-group")
    public void readMsg(String msg) {
        Event event = new Gson().fromJson(msg, Event.class);
        if (event.getType().equals("Place_new_order")) {
            Optional<Stock> stock = stockService.get(Integer.parseInt(event.getStockid()));

            if (stock.isPresent()) {
                double orderQty = Double.parseDouble(event.getQty());
                double availableQty = stock.get().getAvalableStock();
                if (availableQty >= orderQty) {

                    if (availableQty >= allocatedStockService.allocatedOrders()+orderQty) {


                        Allowcated_stock allowcated_stock = new Allowcated_stock();
                        allowcated_stock.setId(Integer.parseInt(event.getOrderid()));
                        allowcated_stock.setQty(Double.parseDouble(event.getQty()));
                        allowcated_stock.setStockId(event.getStockid());
                        allocatedStockService.save(allowcated_stock);
                        log.info("save allocated order");

                        producer.publishToTopic(new Event("Allocation_service", "complete_allocation", event.getKey(), event.getQty(), event.getOrderid(), event.getStockid(), "Success"));
                        producer_schedule.publishToTopic(new Event("Allocation_service", "complete_allocation", event.getKey(), event.getQty(), event.getOrderid(), event.getStockid(), "Success"));
                    } else {
                        System.out.println("No stock");
                       log.info("No stock avalable");
                    }


                } else {

                    System.out.println("No stock");
                    log.info("No stock avalable for allowcate order");
                }


            }





        }
    }
}

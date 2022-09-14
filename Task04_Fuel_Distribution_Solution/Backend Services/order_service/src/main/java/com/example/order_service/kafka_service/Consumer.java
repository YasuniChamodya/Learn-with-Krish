package com.example.order_service.kafka_service;

import com.example.order_service.Types.Event;
import com.example.order_service.model.Order_status;
import com.example.order_service.service.StatusService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Consumer {
    @Autowired
    Producer producer;

    @Autowired
    StatusService statusService;

    @KafkaListener(topics = "new_order_response", groupId = "finance-group")
    public void readMsg(String msg){
        Event event=new Gson().fromJson(msg,Event.class);
        if(event.getFrom().equals("Allocation_service") && event.getType().equals("complete_allocation")){
            if(event.getResult().equals("Success")){
                List<Order_status> list=statusService.findAll();
                for(Order_status o:list){
                    if(o.getOrderId()==Integer.parseInt(event.getOrderid())){
                        Order_status order_status=new Order_status();
                        order_status.setOrderStatusId(o.getOrderStatusId());
                        order_status.setAllocation("Success");
                        order_status.setDispatch(o.getDispatch());
                        order_status.setOrderId(o.getOrderId());
                        order_status.setDiliver(o.getDiliver());
                        order_status.setSchedule(o.getSchedule());

                        statusService.save(order_status);
                    }
                }
            }else{

            }

        }
    }
}

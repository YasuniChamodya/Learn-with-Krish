package com.example.order_service.kafka_service;

import com.example.order_service.Types.Event_schedule;
import com.example.order_service.model.Order_fuel;
import com.example.order_service.model.Order_status;
import com.example.order_service.model.Schedule_orders;
import com.example.order_service.service.Order_service;
import com.example.order_service.service.Schedule_service;
import com.example.order_service.service.StatusService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Consumer_schedule {
    @Autowired
    StatusService statusService;
    @Autowired
    Order_service order_service;
    @Autowired
    Schedule_service schedule_service;

    @KafkaListener(topics = "schedule-response", groupId = "finance-group")
    public void readMsg(String msg){
        Event_schedule event= new Gson().fromJson(msg,Event_schedule.class);
        System.out.println("incoming msg from schedule service  "+msg);

        if(event.getFrom().equals("schedule_service") && event.getType().equals("complete_schedule") && event.getResult().equals("Success")){
            List<Order_status> list=statusService.findAll();
            List<Order_fuel> orderList=order_service.findAll();
            for(Order_status o:list){
                if(o.getOrderId()==Integer.parseInt(event.getOrderid())){
                    Order_status order_status=new Order_status();
                    order_status.setOrderStatusId(o.getOrderStatusId());
                    order_status.setAllocation(event.getResult());
                    order_status.setDispatch(o.getDispatch());
                    order_status.setOrderId(o.getOrderId());
                    order_status.setDiliver(o.getDiliver());
                    order_status.setSchedule("Success");
                    statusService.save(order_status);
                }
            }

//            for(Order_fuel order_fuel:orderList){
//                if(order_fuel.getId()==Integer.parseInt(event.getOrderid())){
//                        Order_fuel order_fuel1=new Order_fuel();
//                        order_fuel1.setId(order_fuel.getId());
//                        order_fuel1.setAddress(order_fuel.getAddress());
//                        order_fuel1.setDate(order_fuel.getDate());
//                        order_fuel1.setFuelStationId(order_fuel.getFuelStationId());
//                        order_fuel1.setMobile(order_fuel.getMobile());
//                        order_fuel1.setName(order_fuel.getName());
//                        order_fuel1.setQty(order_fuel.getQty());
//                        order_fuel1.setScheduleDate(event.getDate());
//                        order_fuel1.setTime(event.getTime());
//                        order_fuel1.setStockId(order_fuel.getStockId());
//                        order_service.save(order_fuel1);
//                }
//            }
            Schedule_orders schedule_orders=new Schedule_orders();
            schedule_orders.setOrderId(Integer.parseInt(event.getOrderid()));
            schedule_orders.setDate(event.getDate());
            schedule_orders.setTime(event.getTime());
            schedule_service.save(schedule_orders);


        }else{

        }
        }
    }


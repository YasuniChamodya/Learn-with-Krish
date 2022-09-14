package com.example.order_service.service;

import com.example.order_service.model.Order_fuel;
import com.example.order_service.model.Order_status;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService{
    @Autowired
    StatusRepository statusRepository;


    @Override
    public Order_status save(Order_status order_status) {
        return statusRepository.save(order_status);
    }

    @Override
    public List<Order_status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Order_status findById(int id) {
       List<Order_status> list=statusRepository.findAll();
       Order_status order_status=new Order_status();
       for(Order_status o:list){
           if(o.getOrderId()==id){
               order_status.setOrderStatusId(o.getOrderStatusId());
               order_status.setOrderId(o.getOrderId());
               order_status.setSchedule(o.getSchedule());
               order_status.setAllocation(o.getAllocation());
               order_status.setDispatch(o.getDispatch());
               order_status.setDiliver(o.getDiliver());
               order_status.setDiliverDate(o.getDiliverDate());
           }
       }
       return order_status;
    }

    @Override
    public Order_status updateDeliverStatus(int id) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date=new Date();
        Order_status order_status=new Order_status();
        Order_status returnObj=null;
        List<Order_status> list=statusRepository.findAll();
        for(Order_status o:list){
            if(o.getOrderId()==id){
                order_status.setOrderStatusId(o.getOrderStatusId());
                order_status.setAllocation(o.getAllocation());
                order_status.setOrderId(o.getOrderId());
                order_status.setSchedule(o.getSchedule());
                order_status.setDispatch(o.getDispatch());
                order_status.setDiliver("Success");
                order_status.setDiliverDate(formatter.format(date));
                returnObj=statusRepository.save(order_status);
            }
        }
        return returnObj;
    }
}

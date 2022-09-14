package com.example.order_service.service;

import com.example.order_service.model.Schedule_orders;
import com.example.order_service.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements Schedule_service {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public Schedule_orders save(Schedule_orders schedule_orders) {
        return scheduleRepository.save(schedule_orders);
    }

    @Override
    public Schedule_orders findById(int id) {
        List<Schedule_orders> list=scheduleRepository.findAll();
        Schedule_orders schedule_orders=new Schedule_orders();
        for(Schedule_orders s:list){
            if(s.getOrderId()==id){
                schedule_orders.setScheduleId(s.getScheduleId());
                schedule_orders.setOrderId(s.getOrderId());
                schedule_orders.setTime(s.getTime());
                schedule_orders.setDate(s.getDate());

            }
        }


        return schedule_orders;
    }


}

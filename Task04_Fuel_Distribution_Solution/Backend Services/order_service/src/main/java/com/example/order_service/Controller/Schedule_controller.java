package com.example.order_service.Controller;

import com.example.order_service.model.Order_status;
import com.example.order_service.model.Schedule_orders;
import com.example.order_service.service.Schedule_service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class Schedule_controller {
    @Autowired
    Schedule_service schedule_service;
  @CrossOrigin
    @RequestMapping(value = "/schedule",method = RequestMethod.GET)
    public Schedule_orders getScheduleData(@RequestParam int id){
        log.info("Executing getScheduleData() from controller");
        return schedule_service.findById(id);

    }
}

package com.example.order_service.Controller;

import com.example.order_service.model.Order_fuel;
import com.example.order_service.model.Order_status;
import com.example.order_service.repository.StatusRepository;
import com.example.order_service.service.StatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class Status_controller {
    @Autowired
    StatusService statusService;

    @RequestMapping(value = "/status",method = RequestMethod.GET)
    public List<Order_status> getStatus(){
        log.info("Executing getStatus() from controller");
        return statusService.findAll();

    }
    @CrossOrigin
    @RequestMapping(value = "/statusid",method = RequestMethod.GET)
    public Order_status getStatusById(@RequestParam("id") int id){
        log.info("Executing getStatusById() from controller");
        return statusService.findById(id);
    }

}

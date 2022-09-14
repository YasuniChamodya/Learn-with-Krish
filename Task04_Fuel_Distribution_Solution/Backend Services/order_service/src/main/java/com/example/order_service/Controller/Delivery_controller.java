package com.example.order_service.Controller;

import com.example.order_service.model.Order_status;
import com.example.order_service.service.StatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class Delivery_controller {
    @Autowired
    StatusService statusService;
    @CrossOrigin
    @RequestMapping(value = "/delivery",method = RequestMethod.GET)
    public Order_status deliverOrder(@RequestParam("id") int id){
    return statusService.updateDeliverStatus(id);
    }
}

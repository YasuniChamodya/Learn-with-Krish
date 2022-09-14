package com.example.order_service.Controller;

import com.example.order_service.Order_Model.Order_Data;
import com.example.order_service.Types.Event;
import com.example.order_service.model.Order_fuel;
import com.example.order_service.kafka_service.Producer;
import com.example.order_service.model.Order_status;
import com.example.order_service.service.Order_service;
import com.example.order_service.service.StatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
public class Order_controller {
    @Autowired
    private Producer producer;
    @Autowired
    Order_service order_service;
    @Autowired
    StatusService statusService;
    @CrossOrigin
    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public List<Order_fuel> getOrders(){
    log.info("Executing getOrder() method");
    return order_service.findAll();

    }


    @CrossOrigin
    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public Order_fuel save(@RequestBody Order_fuel order){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date=new Date();

        order.setDate(formatter.format(date));
        order.setId((int) (System.currentTimeMillis() & 0xfffffff));
        log.info("new ID created ");
          producer.publishToTopic(new Event("order_service", "Place_new_order",String.valueOf(order.getId()),order.getQty(),String.valueOf(order.getId()),order.getStockId(),"Pending"));
          Order_status order_status=new Order_status();
          order_status.setOrderId(order.getId());
          order_status.setAllocation("Pending");
          order_status.setSchedule("Pending");
          order_status.setDispatch("Pending");
          order_status.setDiliver("Pending");

          statusService.save(order_status);
          log.info("status save success");
          log.info("order save success");
          return order_service.save(order);
    }

    @CrossOrigin
    @RequestMapping(value = "/orderid",method = RequestMethod.GET)
    public Optional<Order_fuel> getById(@RequestParam("id") int id){
        log.info("getById() method call in controller");
        return order_service.findById(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/orderData",method = RequestMethod.GET)
    public List<Order_Data> findOrderDetails(){
        log.info("findOrderDetails() method call in controller");
        return order_service.findStatusSuccessData();
    }


    @CrossOrigin
    @RequestMapping(value = "/dispatched_orders",method = RequestMethod.GET)
    public List<Order_Data> findDispatchedOrders(){
        log.info("findOrderDetails() method call in controller");
        return order_service.findDispatchedOrders();
    }

    @CrossOrigin
    @RequestMapping(value = "/delivered_orders",method = RequestMethod.GET)
    public List<Order_Data> findDeliveredOrders(){
        log.info("findDeliveredOrders() method call in controller");
        return order_service.findDeliveredOrders();
    }

    @CrossOrigin
    @RequestMapping(value = "/gas_station_orders",method = RequestMethod.GET)
    public List<Order_Data> findOrdersByGasStationId(@RequestParam("id") String id){
        log.info("findDeliveredOrders() method call in controller");
        return order_service.findOrdersByGasStationId(id);
    }



}

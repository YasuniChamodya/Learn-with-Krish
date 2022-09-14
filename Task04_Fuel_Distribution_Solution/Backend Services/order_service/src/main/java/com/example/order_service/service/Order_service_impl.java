package com.example.order_service.service;

import com.example.order_service.Order_Model.Order_Data;
import com.example.order_service.model.Order_fuel;
import com.example.order_service.model.Order_status;
import com.example.order_service.model.Schedule_orders;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.repository.ScheduleRepository;
import com.example.order_service.repository.StatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class Order_service_impl implements Order_service{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Order_fuel save(Order_fuel order) {

        return orderRepository.save(order);
    }

    @Override
    public List<Order_fuel> findAll() {
        log.info("return all order details");
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order_fuel> findById(int id) {
        log.info("return find by id ");
        return orderRepository.findById(id);
    }



    @Override
    public List<Order_Data> findStatusSuccessData() {
        List<Order_fuel> order=orderRepository.findAll();
        List<Order_status> order_status=statusRepository.findAll();
        List<Schedule_orders> schedule_orders=scheduleRepository.findAll();
        List<Order_Data> orderDate=new ArrayList<>();

        for(Order_fuel o:order){
            for(Order_status os:order_status){
                for(Schedule_orders so:schedule_orders){
                    if(o.getId()==os.getOrderId()&& o.getId()==so.getOrderId() && os.getDispatch().equals("Pending")){


                        Order_Data d=new Order_Data();
                     d.setId(o.getId());
                     d.setFuelStationId(o.getFuelStationId());
                     d.setName(o.getName());
                     d.setAddress(o.getAddress());
                     d.setMobile(o.getMobile());
                     d.setQty(o.getQty());
                     d.setStockId(o.getStockId());
                     d.setDate(o.getDate());
                     d.setDispatch(os.getDispatch());
                     d.setAllocation(os.getAllocation());
                     d.setSchedule(os.getSchedule());
                     d.setScheduleDate(so.getDate());
                     d.setScheduleTime(so.getTime());

                     orderDate.add(d);
                    }
                }
            }
        }

        return orderDate;
    }

    @Override
    public List<Order_Data> findDispatchedOrders() {
        List<Order_fuel> order=orderRepository.findAll();
        List<Order_status> order_status=statusRepository.findAll();
        List<Schedule_orders> schedule_orders=scheduleRepository.findAll();
        List<Order_Data> orderDate=new ArrayList<>();

        for(Order_fuel o:order){
            for(Order_status os:order_status){
                for(Schedule_orders so:schedule_orders){
                    if(o.getId()==os.getOrderId()&& o.getId()==so.getOrderId() && os.getDispatch().equals("Success")&& os.getDiliver().equals("Pending")){


                        Order_Data d=new Order_Data();
                        d.setId(o.getId());
                        d.setFuelStationId(o.getFuelStationId());
                        d.setName(o.getName());
                        d.setAddress(o.getAddress());
                        d.setMobile(o.getMobile());
                        d.setQty(o.getQty());
                        d.setStockId(o.getStockId());
                        d.setDate(o.getDate());
                        d.setDispatch(os.getDispatch());
                        d.setAllocation(os.getAllocation());
                        d.setSchedule(os.getSchedule());
                        d.setScheduleDate(so.getDate());
                        d.setScheduleTime(so.getTime());

                        orderDate.add(d);
                    }
                }
            }
        }

        return orderDate;
    }

    @Override
    public List<Order_Data> findDeliveredOrders() {
        List<Order_fuel> order=orderRepository.findAll();
        List<Order_status> order_status=statusRepository.findAll();
        List<Schedule_orders> schedule_orders=scheduleRepository.findAll();
        List<Order_Data> orderDate=new ArrayList<>();

        for(Order_fuel o:order){
            for(Order_status os:order_status){
                for(Schedule_orders so:schedule_orders){
                    if(o.getId()==os.getOrderId()&& o.getId()==so.getOrderId() && os.getDispatch().equals("Success")&& os.getDiliver().equals("Success")){


                        Order_Data d=new Order_Data();
                        d.setId(o.getId());
                        d.setFuelStationId(o.getFuelStationId());
                        d.setName(o.getName());
                        d.setAddress(o.getAddress());
                        d.setMobile(o.getMobile());
                        d.setQty(o.getQty());
                        d.setStockId(o.getStockId());
                        d.setDate(o.getDate());
                        d.setDispatch(os.getDispatch());
                        d.setAllocation(os.getAllocation());
                        d.setSchedule(os.getSchedule());
                        d.setScheduleDate(so.getDate());
                        d.setScheduleTime(os.getDiliverDate());

                        orderDate.add(d);
                    }
                }
            }
        }

        return orderDate;
    }

    @Override
    public List<Order_Data> findOrdersByGasStationId(String id) {
        List<Order_fuel> order=orderRepository.findAll();
        List<Order_status> order_status=statusRepository.findAll();
        List<Schedule_orders> schedule_orders=scheduleRepository.findAll();
        List<Order_Data> orderDate=new ArrayList<>();

        for(Order_fuel o:order){
            for(Order_status os:order_status){
                for(Schedule_orders so:schedule_orders){
                    if(o.getFuelStationId().equals(id)){
                        if(o.getId()==os.getOrderId() && o.getId()==so.getOrderId()){

                            Order_Data d=new Order_Data();
                            d.setId(o.getId());
                            d.setFuelStationId(o.getFuelStationId());
                            d.setName(o.getName());
                            d.setAddress(o.getAddress());
                            d.setMobile(o.getMobile());
                            d.setQty(o.getQty());
                            d.setStockId(o.getStockId());
                            d.setDate(o.getDate());
                            d.setDispatch(os.getDispatch());
                            d.setAllocation(os.getAllocation());
                            d.setSchedule(os.getSchedule());
                            d.setDeliver(os.getDiliver());
                            d.setDeliverDate(os.getDiliverDate());
                            d.setScheduleDate(so.getDate());
                            d.setScheduleTime(os.getDiliverDate());

                            orderDate.add(d);

                        }


                    }
                }
            }
        }

        return orderDate;
    }
}

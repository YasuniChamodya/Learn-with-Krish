package com.example.order_service.Order_Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class Order_Data {
    int id;
    String fuelStationId;
    String name;
    String address;
    String mobile;
    String qty;
    String  stockId;
    String date;

    String dispatch;
    String allocation;
    String schedule;
    String scheduleDate;
    String scheduleTime;
    String deliver;
    String DeliverDate;
    public Order_Data() {

    }

    public Order_Data(int id, String fuelStationId, String name, String address, String mobile, String qty, String stockId, String date, String dispatch, String allocation, String schedule, String scheduleDate, String scheduleTime, String deliver, String deliverDate) {
        this.id = id;
        this.fuelStationId = fuelStationId;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.qty = qty;
        this.stockId = stockId;
        this.date = date;
        this.dispatch = dispatch;
        this.allocation = allocation;
        this.schedule = schedule;
        this.scheduleDate = scheduleDate;
        this.scheduleTime = scheduleTime;
        this.deliver = deliver;
        DeliverDate = deliverDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFuelStationId() {
        return fuelStationId;
    }

    public void setFuelStationId(String fuelStationId) {
        this.fuelStationId = fuelStationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDispatch() {
        return dispatch;
    }

    public void setDispatch(String dispatch) {
        this.dispatch = dispatch;
    }

    public String getAllocation() {
        return allocation;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getDeliver() {
        return deliver;
    }

    public void setDeliver(String deliver) {
        this.deliver = deliver;
    }

    public String getDeliverDate() {
        return DeliverDate;
    }

    public void setDeliverDate(String deliverDate) {
        DeliverDate = deliverDate;
    }
}

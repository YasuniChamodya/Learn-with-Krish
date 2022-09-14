package com.example.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Order_fuel {
    @Id
    int id;
    String fuelStationId;
    String name;
    String address;
    String mobile;
    String qty;
    String  stockId;
    String date;
    String scheduleDate;
    String time;
}

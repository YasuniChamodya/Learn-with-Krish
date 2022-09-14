package com.example.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order_status {
    @Id
    @GeneratedValue
    private int orderStatusId;
    private int orderId;
    private String allocation;
    private String schedule;
    private String dispatch;
    private String diliver;
    private String diliverDate;


}

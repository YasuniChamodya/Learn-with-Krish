package com.example.order_allocate.model;//package com.example.allocation_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Allowcated_stock {
    @Id
    @GeneratedValue
    private int allowcatedId;
    private int id;
    private double qty;
    private String stockId;


}

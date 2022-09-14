package com.example.order_allocate.service;

import com.example.order_allocate.model.Dispatch;


import java.util.List;

public interface Dispatch_service {
    List<Dispatch> findAll();
    Dispatch save(Dispatch dispatch);
}

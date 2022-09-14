package com.example.order_allocate.service;


import com.example.order_allocate.model.Dispatch;
import com.example.order_allocate.repository.DispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Dispatch_serviceImpl implements Dispatch_service{
    @Autowired
    DispatchRepository dispatchRepository;

    @Override
    public List<Dispatch> findAll() {
        return dispatchRepository.findAll();
    }

    @Override
    public Dispatch save(Dispatch dispatch) {
        return dispatchRepository.save(dispatch);
    }
}

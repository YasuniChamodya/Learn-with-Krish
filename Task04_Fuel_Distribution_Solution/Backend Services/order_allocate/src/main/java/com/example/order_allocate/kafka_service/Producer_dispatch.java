package com.example.order_allocate.kafka_service;

import com.example.order_allocate.Types.Event;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer_dispatch {
    public static final String topic = "new-connection";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void publishToTopic(Event msg) {
        System.out.println("publishing dispatch from order" + topic);
        Gson g=new Gson();
        String newMsg=g.toJson(msg);
        this.kafkaTemplate.send(topic, newMsg);

    }
}

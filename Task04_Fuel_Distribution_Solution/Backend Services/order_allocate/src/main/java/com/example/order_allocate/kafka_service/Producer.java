package com.example.order_allocate.kafka_service;

import com.example.order_allocate.Types.Event;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    public static final String topic = "new_order_response";
 @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void publishToTopic(Event msg) {
        System.out.println("publishing to " + topic);
        Gson g=new Gson();
        String newMsg=g.toJson(msg);
        this.kafkaTemplate.send(topic, newMsg);

    }

}

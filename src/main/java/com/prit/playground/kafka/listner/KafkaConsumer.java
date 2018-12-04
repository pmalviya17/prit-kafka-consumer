package com.prit.playground.kafka.listner;

import com.prit.playground.kafka.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "KafkaExampleTopic", groupId = "group_id")
    public void consume(String message){
        System.out.println("Inside consumer and messages are :"+message);
    }

    @KafkaListener(topics = "KafkaExampleTopicJson", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }
}

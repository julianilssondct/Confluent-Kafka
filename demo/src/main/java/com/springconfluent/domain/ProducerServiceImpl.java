package com.springconfluent.domain;

import com.springconfluent.schema.Event;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

  private final KafkaTemplate<String, Event> kafkaTemplate;


  @Value("topic.name")
  private String topic;

  @Override
  public void sendMessage(String message) {
    Event event = new Event();
    event.setMessage(message);
    this.kafkaTemplate.send("test-topic", event);
    System.out.println("Published the message " + event + " to the kafka queue: " + topic);
  }
}

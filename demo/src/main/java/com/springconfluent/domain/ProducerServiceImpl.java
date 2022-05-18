package com.springconfluent.domain;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl
    implements ProducerService {

  private final KafkaTemplate<Object, byte[]> kafkaTemplate;

  @Value("emil-test")
  private String topic;

  @Override
  public void sendMessage(String message) {
    ByteArraySerializer bytes = new ByteArraySerializer();
    this.kafkaTemplate.send(topic, bytes.serialize(topic, message.getBytes()));
    System.out.println("Published the message " + message + " to the kafka queue: " + topic);
  }
}

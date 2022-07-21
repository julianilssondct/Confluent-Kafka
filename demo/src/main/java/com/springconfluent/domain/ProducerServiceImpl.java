package com.springconfluent.domain;

//import com.springconfluent.schema.Event;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Properties;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.errors.DeserializationExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

  private final KafkaTemplate<String, JsonNode> kafkaTemplate;
  private final ObjectMapper mapper = new ObjectMapper();


  @Override
  public void sendMessage(JsonNode message){
    Event event = new Event();
    event.setEvent(message);
    JsonNode jsonNode = mapper.valueToTree(message);
    this.kafkaTemplate.send("dedicated_topic_0", event.getEvent());

    System.out.println("Message sent: " + message);
  }

/*  @Override
  public void sendMessage(JsonNode message) {
    Properties props = new Properties();
    props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-g9m0n.westeurope.azure.confluent.cloud:9092");
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        "org.apache.kafka.common.serialization.StringSerializer");
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        "io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer");
    props.put("schema.registry.url", "https://psrc-dozoy.westeurope.azure.confluent.cloud");
    Producer<String, Event> producer = new KafkaProducer<String, Event>(props);
    Event event = new Event();
    event.setEvent(message);
    ProducerRecord<String, Event> producerRecord =
        new ProducerRecord<String, Event>("dedicated_topic_0", event);
    try {
      producer.send(producerRecord).get();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    producer.close();
  }*/
}

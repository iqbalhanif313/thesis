package com.shm.consumer.consumer.weather;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemperatureSensorConsumer {

  @KafkaListener( topics = "temperature-data", id = "temperature1", groupId = "temperature-group")
  public void consumer1(ConsumerRecord<String, String> record){
//    System.out.println("Sensor:" + record.key()+"\n Temperature: " + record.value() );
  }

  @KafkaListener( topics = "temperature-data", id = "temperature2",groupId = "temperature-group")
  public void consumer2(ConsumerRecord<String, String> record){
//    System.out.println("Sensor:" + record.key()+" Temperature: " + record.value() );
  }

  @KafkaListener( topics = "temperature-data",id = "temperature3", groupId = "temperature-group")
  public void consumer3(ConsumerRecord<String, String> record){
//    System.out.println("Sensor:" + record.key()+" Temperature: " + record.value() );
  }
}

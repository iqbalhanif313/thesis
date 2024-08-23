package com.shm.consumer.consumer.sensor;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VibrationSensorConsumer {

  @KafkaListener( id = "vibration-consumer1",topics = "vibration-data", groupId = "vibration-data-group")
  public void consumer1(ConsumerRecord<String, String> record){
//    System.out.println("Vibration: " + record.value());
  }
}

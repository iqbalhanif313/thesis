package com.shm.consumer.consumer.sensor;

import com.shm.consumer.avro.SensorAvailabilityData;
import com.shm.consumer.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SensorAvailabilityConsumer {
  private final SensorDataService sensorDataService;

  @KafkaListener( id = "sensor-health-consumer1",topics = "is-sensor-healthy", groupId = "is-sensor-healthy-group")
  public void consumer1(ConsumerRecord<String, SensorAvailabilityData> record){
//    System.out.println("sg-consumer 1: "+ record.key() + "\n Value: "+ record.value());

  }

  @KafkaListener( id = "sensor-health-consumer2",topics = "is-sensor-healthy", groupId = "is-sensor-healthy-group")
  public void consumer2(ConsumerRecord<String, SensorAvailabilityData> record){
//    System.out.println("sg-consumer 2: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener( id = "sensor-health-consumer3",topics = "is-sensor-healthy", groupId = "is-sensor-healthy-group")
  public void consumer3(ConsumerRecord<String, SensorAvailabilityData> record){
//    System.out.println("sg-consumer 3: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener( id = "sensor-health-consumer4",topics = "is-sensor-healthy", groupId = "is-sensor-healthy-group")
  public void consumer4(ConsumerRecord<String, SensorAvailabilityData> record){
//    System.out.println("sg-consumer 4: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener( id = "sensor-health-consumer5",topics = "is-sensor-healthy", groupId = "is-sensor-healthy-group")
  public void consumer5(ConsumerRecord<String, SensorAvailabilityData> record){
//    System.out.println("sg-consumer 5: "+ record.key() + "\n Value: "+ record.value());
  }

}

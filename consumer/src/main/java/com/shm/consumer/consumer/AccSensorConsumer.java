package com.shm.consumer.consumer;

import com.shm.consumer.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccSensorConsumer {
  private final SensorDataService sensorDataService;
  @KafkaListener( id = "consumer1",topics = "acc-data", groupId = "acc-data-group")
  public void consumer1(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 1: "+ record.key() + "\n Value: "+ record.value());
    sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer2",topics = "acc-data", groupId = "acc-data-group")
  public void consumer2(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 2: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer3",topics = "acc-data", groupId = "acc-data-group")
  public void consumer3(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 3: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer4",topics = "acc-data", groupId = "acc-data-group")
  public void consumer4(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 4 : "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer5",topics = "acc-data", groupId = "acc-data-group")
  public void consumer5(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 5: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer6",topics = "acc-data", groupId = "acc-data-group")
  public void consumer6(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 6: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer7",topics = "acc-data", groupId = "acc-data-group")
  public void consumer7(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 7: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer8",topics = "acc-data", groupId = "acc-data-group")
  public void consumer8(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 8: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer9",topics = "acc-data", groupId = "acc-data-group")
  public void consumer9(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 9: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer10",topics = "acc-data", groupId = "acc-data-group")
  public void consumer10(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 10: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer11",topics = "acc-data", groupId = "acc-data-group")
  public void consumer11(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 11: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }


  @KafkaListener(
      id = "consumer12",topics = "acc-data", groupId = "acc-data-group")
  public void consumer12(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 12: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer13",topics = "acc-data", groupId = "acc-data-group")
  public void consumer13(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 13: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer14",topics = "acc-data", groupId = "acc-data-group")
  public void consumer14(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 14: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer15",topics = "acc-data", groupId = "acc-data-group")
  public void consumer15(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 15: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer16",topics = "acc-data", groupId = "acc-data-group")
  public void consumer16(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 16: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer17",topics = "acc-data", groupId = "acc-data-group")
  public void consumer17(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 17: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "consumer18",topics = "acc-data", groupId = "acc-data-group")
  public void consumer18(ConsumerRecord<String, String> record){
//    System.out.println("Consumer 18: "+ record.key() + "\n Value: "+ record.value());
   sensorDataService.storeDataToDb(record.value());
  }
}

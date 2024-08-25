package com.shm.consumer.consumer.sensor;

import com.shm.consumer.avro.SgData;
import com.shm.consumer.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StrainSensorConsumer {
  private final SensorDataService sensorDataService;

  @KafkaListener( id = "sg-consumer1",topics = "sg-data", groupId = "sg-data-group")
  public void consumer1(ConsumerRecord<String, SgData> record){
    System.out.println("sg-consumer 1: "+ record.key() + "\n Value: "+ record.value());
//    sensorDataService.storeDataToDb(record.value());
  }

  @KafkaListener(
      id = "sg-consumer2",topics = "sg-data", groupId = "sg-data-group")
  public void consumer2(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 2: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer3",topics = "sg-data", groupId = "sg-data-group")
  public void consumer3(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 3: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer4",topics = "sg-data", groupId = "sg-data-group")
  public void consumer4(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 4 : "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer5",topics = "sg-data", groupId = "sg-data-group")
  public void consumer5(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 5: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer6",topics = "sg-data", groupId = "sg-data-group")
  public void consumer6(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 6: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer7",topics = "sg-data", groupId = "sg-data-group")
  public void consumer7(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 7: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer8",topics = "sg-data", groupId = "sg-data-group")
  public void consumer8(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 8: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer9",topics = "sg-data", groupId = "sg-data-group")
  public void consumer9(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 9: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer10",topics = "sg-data", groupId = "sg-data-group")
  public void consumer10(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 10: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer11",topics = "sg-data", groupId = "sg-data-group")
  public void consumer11(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 11: "+ record.key() + "\n Value: "+ record.value());
  }


  @KafkaListener(
      id = "sg-consumer12",topics = "sg-data", groupId = "sg-data-group")
  public void consumer12(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 12: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer13",topics = "sg-data", groupId = "sg-data-group")
  public void consumer13(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 13: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer14",topics = "sg-data", groupId = "sg-data-group")
  public void consumer14(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 14: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer15",topics = "sg-data", groupId = "sg-data-group")
  public void consumer15(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 15: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer16",topics = "sg-data", groupId = "sg-data-group")
  public void consumer16(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 16: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer17",topics = "sg-data", groupId = "sg-data-group")
  public void consumer17(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 17: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer18",topics = "sg-data", groupId = "sg-data-group")
  public void consumer18(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 18: "+ record.key() + "\n Value: "+ record.value());

  }

  @KafkaListener(
      id = "sg-consumer19",topics = "sg-data", groupId = "sg-data-group")
  public void consumer19(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 18: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer20",topics = "sg-data", groupId = "sg-data-group")
  public void consumer20(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 18: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer21",topics = "sg-data", groupId = "sg-data-group")
  public void consumer21(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 18: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer22",topics = "sg-data", groupId = "sg-data-group")
  public void consumer22(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 18: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer23",topics = "sg-data", groupId = "sg-data-group")
  public void consumer23(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 18: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer24",topics = "sg-data", groupId = "sg-data-group")
  public void consumer24(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 18: "+ record.key() + "\n Value: "+ record.value());

  }

  @KafkaListener(
      id = "sg-consumer25",topics = "sg-data", groupId = "sg-data-group")
  public void consumer25(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 18: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer26",topics = "sg-data", groupId = "sg-data-group")
  public void consumer26(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 18: "+ record.key() + "\n Value: "+ record.value());
  }

  @KafkaListener(
      id = "sg-consumer27",topics = "sg-data", groupId = "sg-data-group")
  public void consumer27(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 18: "+ record.key() + "\n Value: "+ record.value());
  }
  @KafkaListener(
      id = "sg-consumer28",topics = "sg-data", groupId = "sg-data-group")
  public void consumer28(ConsumerRecord<String, SgData> record){
//    System.out.println("sg-consumer 18: "+ record.key() + "\n Value: "+ record.value());
  }
}

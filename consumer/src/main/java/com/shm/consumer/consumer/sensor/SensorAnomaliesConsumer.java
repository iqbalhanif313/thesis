package com.shm.consumer.consumer.sensor;

import com.shm.consumer.avro.AccData;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SensorAnomaliesConsumer {

  @KafkaListener( id = "consumer-anomalies",topics = "SG_ANOMALIES", groupId = "sg-anomalies-group")
  public void consumer1(ConsumerRecord<String, AccData> record){
    System.out.println("Anomalies: "+ record.key() + "\n Value: "+ record.value());
  }
}

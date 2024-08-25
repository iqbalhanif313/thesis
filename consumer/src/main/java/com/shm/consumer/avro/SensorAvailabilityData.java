package com.shm.consumer.avro;

import lombok.Data;

@Data
public class SensorAvailabilityData {
  private String TIMESTAMP;
  private Boolean data;
  private String sensor;
}

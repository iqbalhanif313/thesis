package com.shm.consumer.avro;

import lombok.Data;

@Data
public class VibrationData {
  private String TIMESTAMP;
  private String data;
  private String sensor;
}

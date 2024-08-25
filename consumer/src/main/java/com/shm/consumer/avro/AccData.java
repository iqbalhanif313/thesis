package com.shm.consumer.avro;

import lombok.Data;

@Data
public class AccData {
  private String TIMESTAMP;
  private Double data;
  private String sensor;
}

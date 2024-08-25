package com.shm.consumer.avro;

import lombok.Data;

@Data
public class SgData {
  private String TIMESTAMP;
  private Double data;
  private String sensor;
}

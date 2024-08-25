package com.shm.consumer.service;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import jakarta.annotation.PreDestroy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


import static com.shm.consumer.util.DataTypeUtil.detectDataType;

@Service
public class SensorDataService {
  private final Log logger = LogFactory.getLog("logger");


  private final WriteApi writeApi;

  @Autowired
  public SensorDataService(InfluxDBClient influxDBClient) {
    this.writeApi = influxDBClient.makeWriteApi(); // Use a newer method for WriteApi creation
  }

  public void saveSensorData(String measurement, String field, double value, Date timestamp) {
    Point point = Point
        .measurement(measurement)
        .addField(field, value)
        .time(timestamp.toInstant(), WritePrecision.NS);

    // Use the WriteApi to write data asynchronously
    writeApi.writePoint(point);
  }

  private void saveBooleanSensorData(String measurement, String field, Boolean value, Date timestamp){
    Point point = Point
        .measurement(measurement)
        .addField(field, value)
        .time(timestamp.toInstant(), WritePrecision.NS);

    // Use the WriteApi to write data asynchronously
    writeApi.writePoint(point);
  }

  private void saveCategoricalSensorData(String measurement, String field, String value, Date timestamp){
    Point point = Point
        .measurement(measurement)
        .addField(field, value)
        .time(timestamp.toInstant(), WritePrecision.NS);

    // Use the WriteApi to write data asynchronously
    writeApi.writePoint(point);
  }

  // Call this method during shutdown to close WriteApi
  @PreDestroy
  public void closeWriteApi() {
    if (writeApi != null) {
      writeApi.close();
    }
  }



}

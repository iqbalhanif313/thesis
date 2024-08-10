package com.shm.consumer.service;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SensorDataService {
  private final InfluxDBClient influxDBClient;
  private final Log logger = LogFactory.getLog("logger");
  public void saveSensorData(String measurement, String field, double value, Date timestamp) {
    Point point = Point
        .measurement(measurement)
        .addField(field, value)
        .time(timestamp.toInstant(), WritePrecision.NS);

    logger.info("value: " + value + " timestamp: "+ timestamp);
    try (WriteApi writeApi = influxDBClient.getWriteApi()) {
      writeApi.writePoint(point);
    }
  }

}

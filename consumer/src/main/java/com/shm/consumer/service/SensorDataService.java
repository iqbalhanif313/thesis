package com.shm.consumer.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.shm.consumer.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

  // Call this method during shutdown to close WriteApi
  public void closeWriteApi() {
    if (writeApi != null) {
      writeApi.close();
    }
  }

  public void storeDataToDb(String message){
    try{
      Gson gson = new Gson();
      Type type = new TypeToken<Map<String, String>>() {}.getType();
      Map<String, String> data = gson.fromJson(message, type);
      Date timestamp = DateUtil.getNowWithDatasetTimestamp(data.get("TIMESTAMP"));
      saveSensorData(data.get("sensor"), "data", Double.parseDouble(data.get("data")),timestamp);
    }catch (Exception e){
      logger.error("error on sending the data", e);
    }
  }

}

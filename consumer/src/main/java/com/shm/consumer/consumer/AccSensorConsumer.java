package com.shm.consumer.consumer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shm.consumer.service.SensorDataService;
import com.shm.consumer.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccSensorConsumer {
  private final SensorDataService sensorDataService;
  private final Log logger = LogFactory.getLog("logger");

  @KafkaListener(topics = {
      "A1", "A2","A3", "A4","A5", "A6","A7", "A8","A9", "A10","A11", "A12","A13", "A14","A15", "A16",
      "A17", "A18"
  }, groupId = "sensor_group")
  public void listen(String message) {
    try{
      Gson gson = new Gson();
      Type type = new TypeToken<Map<String, String>>() {}.getType();
      Map<String, String> data = gson.fromJson(message, type);
      Date timestamp = DateUtil.getNowWithDatasetTimestamp(data.get("TIMESTAMP"));
      sensorDataService.saveSensorData(data.get("sensor"), "data", Double.parseDouble(data.get("data")),timestamp);
    }catch (Exception e){
      logger.error("error on sending the data", e);
    }
  }
}

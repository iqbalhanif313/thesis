package com.shm.consumer.config;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfluxDbConfig {
  @Bean
  public InfluxDBClient influxDBClient() {
    String token = "EVJymyJ0KyjX8UVvg5wEXbEHhgmJ2h6tOnMl57l8b2Bnr46qY1qaBH0dCgrcKQ1NJPYw2DAsUjtqRS6movnlwA==";
    String bucket = "shm";
    String org = "monash";

    return InfluxDBClientFactory.create("http://localhost:8086", token.toCharArray(), org, bucket);
  }
}

# thesis

## ESTABLISH SERVICES:
- go to docker-compose.yaml file
```bash
docker compose up 
```
- go to control center
<http://localhost:9021>


## setup topics
  - **sensor-acc** -> 18 partitions , 3 replicas, 3 min_insync_replicas
  - **sensor-gs** -> 28 partitions, 3 replicas, 3 min_insync_replicas
  - **sensor-health** -> partitions 5, 3 replicas 3 min_insync_replicas
  - **sensor-vibration** -> 1 partition, 3 replicas, 3 min_insync_replicas
  - **temperature** -> 3 partitions, 3 replicas, 3 min_insync_replicas

## Setup schemas

**sensor-acc**
```json
{
  "name": "SensorAcc",
  "namespace": "com.shm.sensorAcc",
  "type": "record",
  "fields": [
    {
      "name": "TIMESTAMP",
      "type": "string"
    },
    {
      "name": "data",
      "type": "double"
    },
    {
      "name": "sensor",
      "type": "string"
    }
  ]
}
```
**sensor-gs**
```json
{
  "name": "SensorSg",
  "namespace": "com.shm.sensorSg",
  "type": "record",
  "fields": [
    {
      "name": "TIMESTAMP",
      "type": "string"
    },
    {
      "name": "data",
      "type": "double"
    },
    {
      "name": "sensor",
      "type": "string"
    }
  ]
}
```

**sensor-health**
```json
{
  "name": "SensorHealth",
  "namespace": "com.shm.sensorHealth",
  "type": "record",
  "fields": [
    {
      "name": "TIMESTAMP",
      "type": "string"
    },
    {
      "name": "data",
      "type": "boolean"
    },
    {
      "name": "sensor",
      "type": "string"
    }
  ]
}
```
**sensor-vibration**
```json
{
  "name": "SensorVibration",
  "namespace": "com.shm.sensorVibration",
  "type": "record",
  "fields": [
    {
      "name": "TIMESTAMP",
      "type": "string"
    },
    {
      "name": "data",
      "type": "string"
    },
    {
      "name": "sensor",
      "type": "string"
    }
  ]
}
```

**weather-temperature**
```json
{
  "name": "SensorTemperature",
  "namespace": "com.shm.sensorTemperature",
  "type": "record",
  "fields": [
    {
      "name": "TIMESTAMP",
      "type": "string"
    },
    {
      "name": "data",
      "type": "double"
    },
    {
      "name": "sensor",
      "type": "string"
    }
  ]
}
```

## Setup Kafka Connect

**sensor-acc**
```json
{
  "name": "sensorAccConnector",
  "config": {
    "connector.class": "com.datamountaineer.streamreactor.connect.influx.InfluxSinkConnector",
    "tasks.max": "1",
    "key.converter": "org.apache.kafka.connect.storage.StringConverter",
    "value.converter": "io.confluent.connect.avro.AvroConverter",
    "topics": "sensor-acc",
    "connect.influx.url": "http://influxdb:8086",
    "connect.influx.db": "shm",
    "connect.influx.username": "root",
    "connect.influx.password": "root_password",
    "connect.influx.kcql": "INSERT INTO sensor-acc SELECT data AS value, sensor AS tag_sensor, TIMESTAMP as csv_timestamp  FROM sensor-acc WITHTIMESTAMP sys_time();",
    "value.converter.schema.registry.url": "http://schema-registry:8081"
  }
}
```

**sensor-sg**
```json
{
  "name": "sensorSgConnector",
  "config": {
    "connector.class": "com.datamountaineer.streamreactor.connect.influx.InfluxSinkConnector",
    "tasks.max": "1",
    "key.converter": "org.apache.kafka.connect.storage.StringConverter",
    "value.converter": "io.confluent.connect.avro.AvroConverter",
    "topics": "sensor-sg",
    "connect.influx.url": "http://influxdb:8086",
    "connect.influx.db": "shm",
    "connect.influx.username": "root",
    "connect.influx.password": "root_password",
    "connect.influx.kcql": "INSERT INTO sensor-sg SELECT data AS value, sensor AS tag_sensor, TIMESTAMP as csv_timestamp  FROM sensor-sg WITHTIMESTAMP sys_time();",
    "value.converter.schema.registry.url": "http://schema-registry:8081"
  }
}
```

**sensor-health**
```json
{
  "name": "sensorHealthConnector",
  "config": {
    "connector.class": "com.datamountaineer.streamreactor.connect.influx.InfluxSinkConnector",
    "tasks.max": "1",
    "key.converter": "org.apache.kafka.connect.storage.StringConverter",
    "value.converter": "io.confluent.connect.avro.AvroConverter",
    "topics": "sensor-health",
    "connect.influx.url": "http://influxdb:8086",
    "connect.influx.db": "shm",
    "connect.influx.username": "root",
    "connect.influx.password": "root_password",
    "connect.influx.kcql": "INSERT INTO sensor-health SELECT data AS value, sensor AS tag_sensor, TIMESTAMP as csv_timestamp  FROM sensor-health WITHTIMESTAMP sys_time();",
    "value.converter.schema.registry.url": "http://schema-registry:8081"
  }
}
```

**sensor-vibration**
```json
{
  "name": "sensorVibrationConnector",
  "config": {
    "connector.class": "com.datamountaineer.streamreactor.connect.influx.InfluxSinkConnector",
    "tasks.max": "1",
    "key.converter": "org.apache.kafka.connect.storage.StringConverter",
    "value.converter": "io.confluent.connect.avro.AvroConverter",
    "topics": "sensor-vibration",
    "connect.influx.url": "http://influxdb:8086",
    "connect.influx.db": "shm",
    "connect.influx.username": "root",
    "connect.influx.password": "root_password",
    "connect.influx.kcql": "INSERT INTO sensor-vibration SELECT data AS value, sensor AS tag_sensor, TIMESTAMP as csv_timestamp  FROM sensor-vibration WITHTIMESTAMP sys_time();",
    "value.converter.schema.registry.url": "http://schema-registry:8081"
  }
}
```


**weather-temprature**
```json
{
  "name": "weather-temperatureConnector",
  "config": {
    "connector.class": "com.datamountaineer.streamreactor.connect.influx.InfluxSinkConnector",
    "tasks.max": "1",
    "key.converter": "org.apache.kafka.connect.storage.StringConverter",
    "value.converter": "io.confluent.connect.avro.AvroConverter",
    "topics": "weather-temperature",
    "connect.influx.url": "http://influxdb:8086",
    "connect.influx.db": "shm",
    "connect.influx.username": "root",
    "connect.influx.password": "root_password",
    "connect.influx.kcql": "INSERT INTO weather-temperature SELECT data AS value, sensor AS tag_sensor, TIMESTAMP as csv_timestamp  FROM weather-temperature WITHTIMESTAMP sys_time();",
    "value.converter.schema.registry.url": "http://schema-registry:8081"
  }
}
```

## SETUP KsqlDB  (To calculate Anomalies)

**sensor-gs**

1. Create stream
```Sql
CREATE STREAM sensor_sg_stream (
  TIMESTAMP STRING,
  data DOUBLE,
  sensor STRING
) WITH (
  KAFKA_TOPIC='sensor-sg',
  VALUE_FORMAT='AVRO'
);
```

2. Filter another stream to filter
```Sql
CREATE STREAM sensor_sg_SG1 AS
SELECT 
  TIMESTAMP, 
  data, 
  sensor 
FROM 
  sensor_sg_stream 
WHERE 
  sensor = 'SG1'
EMIT CHANGES;
```

2. Create SG1 statistic table
```Sql
CREATE TABLE sensor_sg_SG1_stats AS
SELECT
  sensor,
  AVG(data) AS mean_value,
  STDDEV_SAMPLE(data) AS std_dev_value
FROM sensor_sg_SG1
GROUP BY sensor;
```

3. Create stream with anomalies detection
```SQL
CREATE STREAM sensor_sg_SG1_anomalies AS
SELECT
  a.TIMESTAMP,
  a.data,
  a.sensor,
  CASE 
    WHEN a.data > s.mean_value + 2 * s.std_dev_value THEN 'higher'
    WHEN a.data < s.mean_value - 2 * s.std_dev_value THEN 'lower'
    ELSE 'normal'
  END AS anomaly_status
FROM sensor_sg_SG1 a
JOIN sensor_sg_SG1_stats s
  ON a.sensor = s.sensor
EMIT CHANGES;
```

4. Send data only when data is below or above threshold
```SQL
CREATE STREAM sensor_sg_SG1_alarm AS
SELECT
  a.TIMESTAMP,
  a.data,
  a.sensor,
  CASE 
    WHEN a.data > s.mean_value + 2 * s.std_dev_value THEN 'higher'
    WHEN a.data < s.mean_value - 2 * s.std_dev_value THEN 'lower'
  END AS anomaly_status
FROM sensor_sg_SG1 a
JOIN sensor_sg_SG1_stats s
  ON a.sensor = s.sensor
WHERE 
  a.data > s.mean_value + 2 * s.std_dev_value
  OR a.data < s.mean_value - 2 * s.std_dev_value
EMIT CHANGES;
```
## Violin Plot

- Create a Windowed Table for the Last 10 Minutes
```SQL
CREATE TABLE sensor_data_last_10_min AS
SELECT sensor,
       COLLECT_LIST(data) AS data_points
FROM sensor_data_stream
WINDOW TUMBLING (SIZE 10 MINUTES)
GROUP BY sensor
EMIT CHANGES;

```
- Query the Table
``` SQL
SELECT sensor, data_points 
FROM sensor_data_last_10_min
EMIT CHANGES;
```



## Useful links:

- https://kafka.apache.org/quickstart
- https://medium.com/inspiredbrilliance/kafka-basics-and-core-concepts-5fd7a68c3193
- https://levelup.gitconnected.com/kraft-kafka-cluster-with-docker-e79a97d19f2c 
- https://github.com/confluentinc/cp-all-in-one/blob/7.4.0-post/cp-all-in-one-kraft/docker-compose.yml


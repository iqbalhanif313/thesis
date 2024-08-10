import pandas as pd
import os
import time
import json
from confluent_kafka import Producer
import asyncio
from concurrent.futures import ThreadPoolExecutor
from datetime import datetime

# Kafka configuration
kafka_conf = {
    'bootstrap.servers': 'localhost:9092'  # Replace with your Kafka broker
}

# Create a Kafka producer instance
producer = Producer(kafka_conf)

def delivery_report(err, msg):
    """ Delivery report callback called once for each message produced to indicate delivery result.
        Triggered by poll() or flush(). """
    # if err is not None:
    #     print(f'Message delivery failed: {err}')
    # else:
    #     print(f'Message delivered to {msg.topic()} [{msg.partition()}]')

def read_all_csvs_in_folder(folder_path):
    # List all files in the folder
    files = os.listdir(folder_path)
    # Filter for CSV files
    csv_files = [f for f in files if f.endswith('.csv')]
    
    # Dictionary to store DataFrames
    dataframes = {}
    
    # Loop through CSV files and read them into DataFrames
    for csv_file in csv_files:
        file_path = os.path.join(folder_path, csv_file)
        df = pd.read_csv(file_path)
        # print(csv_file)
        # print(df['TIMESTAMP'])
        # df['TIMESTAMP'] = pd.to_datetime(df['TIMESTAMP'])  # Convert TIMESTAMP to datetime
        dataframes[csv_file] = df
        print(f"Loaded {csv_file} with {len(df)} rows and {len(df.columns)} columns")
        
    return dataframes

def produce_message(topic, message):
    """ Produce a message to Kafka. """
    producer.produce(topic, value=message, callback=delivery_report)
    producer.poll(0)

async def process_row(row, executor):
    print(f"TIMESTAMP: {row['TIMESTAMP']}")

    # Send data to Kafka
    loop = asyncio.get_event_loop()
    tasks = []
    for column in row.index:
        if column not in ['TIMESTAMP']:
            topic = column
            message = json.dumps({
                "TIMESTAMP": str(row['TIMESTAMP']),
                "data": row[column],
                "sensor": column
            }, default=str)
               # Get the current time
            current_time = datetime.now()

            # Format the time to include milliseconds
            formatted_time = current_time.strftime("%Y-%m-%d %H:%M:%S.%f")

            # Print the formatted time
            if(column == 'SG1'):
                print(f"time now: {formatted_time},  topic: {topic} message: {message}")
            tasks.append(loop.run_in_executor(executor, produce_message, topic, message))
    
    await asyncio.gather(*tasks)

async def process_dataframes(dataframes):
    # Create a ThreadPoolExecutor
    executor = ThreadPoolExecutor(max_workers=10)
    
    # Loop through each DataFrame
    for file_name, df in dataframes.items():
        print(f"\nProcessing {file_name}")
        
        # Calculate the interval between consecutive timestamps
        # df['INTERVAL'] = df['TIMESTAMP'].diff().fillna(pd.Timedelta(seconds=0))
        
        # Loop through each row in the DataFrame
        for index, row in df.iterrows():
            # if index > 0:  # Skip the delay for the first row
                # interval_seconds = row['INTERVAL'].total_seconds()
                # print(f"Waiting for {interval_seconds} seconds")
                # print(interval_seconds - 0.0025)
            time.sleep(0.005)
            
            print(f"\nRow {index}:")
            await process_row(row, executor)

# Folder path containing the CSV files
folder_path = '.'

# Read all CSV files
dataframes = read_all_csvs_in_folder(folder_path)


# Process each DataFrame asynchronously
asyncio.run(process_dataframes(dataframes))

# Wait for all messages to be delivered
producer.flush()

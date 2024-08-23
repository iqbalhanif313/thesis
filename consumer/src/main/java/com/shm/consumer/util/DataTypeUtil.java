package com.shm.consumer.util;

public class DataTypeUtil {

  public enum DataType {
    NUMERIC, BOOLEAN, TEXT
  }

  public static DataType detectDataType(String input) {
    if (input == null || input.isEmpty()) {
      return DataType.TEXT; // Default to TEXT if null or empty
    }

    if (isNumeric(input)) {
      return DataType.NUMERIC;
    }

    if (isBoolean(input)) {
      return DataType.BOOLEAN;
    }

    return DataType.TEXT;
  }

  private static boolean isNumeric(String input) {
    try {
      Double.parseDouble(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static boolean isBoolean(String input) {
    return input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false");
  }

}

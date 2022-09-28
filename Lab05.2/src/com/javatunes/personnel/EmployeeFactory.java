/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Objects;

public class EmployeeFactory {
  
  // prevent direct instantiation - this is an all-static factory class
  private EmployeeFactory() {
  }
  
  /**
   * TODO: given the input map, create and return the correct object (with its properties set).
   * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable message.
   */
  public static Employee createEmployee(Map<String,String> inputMap)
  throws IllegalArgumentException, ParseException {
    // return value
    Employee emp = null;
    // code goes here
    String type = inputMap.get("type");
    // TODO: 9/26/2022 if type is not equal to "HE" or "SE", then throw IllegalArgumentException. 
    // TODO: 9/26/2022  Read the name and hireDate from inputMap. (Remember: All of the values 
    // in the map are Strings, but hireDate is java.sql.Date.)
    // TODO: 9/26/2022 If type is equal to "HE", then read (and parse) rate and hours from inputMap.
    // TODO: 9/26/2022 If the type is equal to "SE", then read (and parse) salary from inputMap. 
    // TODO: 9/26/2022 Create and return an instance of HourlyEmployee or SalariedEmployee, with
    // the values read from inputMap.

    if (!Objects.equals(type, "HE") && !Objects.equals(type, "SE")) {
      throw new IllegalArgumentException("type must equal HE or SE");
    } else if(type.equals("HE")) {
      String name = inputMap.get("name");
      String date = inputMap.get("hireDate");
      SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
      java.util.Date date1 = simpleDate.parse(date);
      java.sql.Date hireDate = new java.sql.Date((date1.getTime()));

      Double rate = Double.parseDouble(inputMap.get("rate"));
      Double hours = Double.parseDouble(inputMap.get("hours"));

      Employee hourlyEmployee = new HourlyEmployee(name, hireDate, rate, hours);
      return hourlyEmployee;

    } else {
      String name = inputMap.get("name");
      String date = inputMap.get("hireDate");
      SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
      java.util.Date date1 = simpleDate.parse(date);
      java.sql.Date hireDate = new java.sql.Date((date1.getTime()));

      Double salary = Double.parseDouble(inputMap.get("salary"));

      emp = new SalariedEmployee(name, hireDate, salary);
    }



    return emp;
  }
}
package com.ru.main;

import edu.duke.*;
import org.apache.commons.csv.*;

public class HottestTemparatureInDays 
 {
   public static void main(String[] args) 
    {
      HottestTemparatureInDays htd = new HottestTemparatureInDays();
      htd.testHottestInDays();
    }
 public CSVRecord HottestHourInFile(CSVParser parser)
  {
    CSVRecord largest = null;
     for(CSVRecord current : parser)
  {
    if(largest==null)
    largest = current ;
  else
    {
     double x = Double.parseDouble(current.get("TemperatureF"));
     double y = Double.parseDouble(largest.get("TemperatureF"));
     if(x>y)
        {
           largest = current ;
        }
     }
  }
  return largest;
  }
  public void testHottestInDays()
   {
      FileResource fr = new FileResource("D:/Ferdousi/Weather/2012/weather-2012-01-01.csv");
      CSVRecord largest = HottestHourInFile(fr.getCSVParser());
      System.out.println("Hottest temperature was "+largest.get("TemperatureF")+" at " +largest.get("TimeEST"));
   }
}

    
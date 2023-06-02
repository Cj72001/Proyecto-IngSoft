package com.uca.spring.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;





public class Util {
	
	
  private static final String DATE_FORMAT = "dd/MM/yyyy";

  
  
  
  public static boolean isDateValid(String strDate) {
    
    if(strDate==null || strDate.isEmpty())return false;
    
    DateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    sdf.setLenient(false);
    
    try {
      sdf.parse(strDate);
    } catch (ParseException e) {
      return false;
    }
    return true;
  }
  
  
  
  public static String calculateAge(String birthday) {
	  
	  int year = Integer.parseInt(birthday.substring(6, 10));
	    int month =Integer.parseInt(birthday.substring(3, 5));
	    int day   =Integer.parseInt(birthday.substring(0, 2));
	    
	    Period edad = Period.between(LocalDate.of(year, month, day), LocalDate.now());
	    
	    String edadFinal = String.format("%d años, %d meses y %d días",
	            edad.getYears(),
	            edad.getMonths(),
	            edad.getDays());
	    
	    System.out.println("Age calculated");
	    
	    return edadFinal;
  }


}

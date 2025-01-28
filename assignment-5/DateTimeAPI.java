package com.dateApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAPI {

	public static void main(String[] args) {
		//Date operations
		LocalDate today=LocalDate.now();
		System.out.println(today);
		LocalDate newDate=today.plusDays(10);
		System.out.println(newDate);
		LocalDate nextWeek=today.plusWeeks(2);
		System.out.println(nextWeek);
		LocalDate lastMonth=today.minusMonths(1);
		System.out.println(lastMonth);
		
		//Time operations
		LocalTime time=LocalTime.now();
		System.out.println(time);
		LocalTime pastTime=time.minusHours(4);
		System.out.println(pastTime);
		LocalTime futureTime=time.plusHours(6);
		System.out.println(futureTime);
		
		
		//Date and Time Formatting
		LocalDateTime dateTime=LocalDateTime.now();
		System.out.println(dateTime);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
		// Formatting a date-time
        String formatted = dateTime.format(formatter);
        System.out.println("Formatted: " + formatted);

        // Parsing a date-time
        LocalDateTime parsed = LocalDateTime.parse("28-01-2025 10:30", formatter);
        System.out.println("Parsed: " + parsed);
		

	}

}

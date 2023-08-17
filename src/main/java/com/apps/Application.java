package com.apps;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		DateFormat sDateFormat = new SimpleDateFormat("hh:mm:ss aa");
		SimpleDateFormat displayDtFormat = new SimpleDateFormat("HH:mm:ss");
	    
			Date inputDate = null;
			try {
				inputDate = sDateFormat.parse("11:05:45 PM");
				String output1 = displayDtFormat.format(inputDate);
				System.out.println("convert to 24 hours format -- "+output1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("inputDate "+inputDate);
	    
		SpringApplication.run(Application.class, args);
	}
}

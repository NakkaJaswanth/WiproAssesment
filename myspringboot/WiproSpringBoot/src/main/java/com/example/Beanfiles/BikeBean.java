package com.example.Beanfiles;

import org.springframework.stereotype.Component;

@Component("mybike")
public class BikeBean implements Vehicle
{
	//@Override
	public void category() 
	{
		System.out.println("Standard,Cruiser,Sport Bike,Scooter,Moped,Dual Sport");	
	}
	//@Override
	public void parts()
	{
		System.out.println("Frontgearshifter,twin lock suspension,seatpost remote");	
	}
}

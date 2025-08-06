package com.example.Beanfiles;

import org.springframework.stereotype.Component;

@Component("mycar")
public class CarBean  implements Vehicle 
{
	public void category() {
		System.out.println("SEDAN,COUPE,SPORTS CAR,HATCHBACK");	
	}

	public void parts() {
		System.out.println("Rearviewmirror,Sterring and Suspension,Hood,Headlight,Bumpers!");
	}
}


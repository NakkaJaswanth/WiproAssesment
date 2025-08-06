package com.example.Beanfiles;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bank {
	@Value("SBI")
	String bankname;

	@Value("Thananya")
	String managername;

	@Autowired
	@Qualifier("mybike")//The @Qualifier annotation is used to resolve the autowiring conflict, when there are multiple beans of same type.
	Vehicle v1;


	@Autowired
	List<String> technologies;//lookup @Bean method :: public List<String> technologies() 

	@Autowired
	Map<String,Integer> ratings;//lookup @Bean method ::public Map<String,Integer> ratings() 
	
	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public Vehicle getV1() {
		return v1;
	}

	public void setV1(Vehicle v1) {
		this.v1 = v1;
	}

	public List<String> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}

	public Map<String, Integer> getRatings() {
		return ratings;
	}

	public void setRatings(Map<String, Integer> ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "Bank [bankname=" + bankname + ", managername=" + managername + "]";
	}


}

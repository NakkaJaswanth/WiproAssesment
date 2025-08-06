package com.example.Beanfiles;

import java.util.List;

public class FormBean {
	//Spring boot FORM SKELETON IS READY!
	String name;//textbox
	String gender;//radio
	String country;//select option listbox
	List<String> f_hobbies;//checkbox

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<String> getF_hobbies() {
		return f_hobbies;
	}
	public void setF_hobbies(List<String> f_hobbies) {
		this.f_hobbies = f_hobbies;
	}


}

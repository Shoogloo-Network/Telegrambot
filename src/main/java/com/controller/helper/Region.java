package com.controller.helper;

public class Region {
String address;
String country;
String state;
String city;
String zipcode;
String lang;
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public String getLang() {
	return lang;
}
public void setLang(String lang) {
	this.lang = lang;
}
@Override
public String toString() {
	return "Region {address=" + address + ", country=" + country + ", state=" + state + ", city=" + city + ", zipcode="
			+ zipcode + ", lang=" + lang + "}";
}

}

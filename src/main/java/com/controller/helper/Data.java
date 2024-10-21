package com.controller.helper;

import java.util.List;

public class Data {
String key ;
User user;
String type;
Account account;
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}


public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

public Account getAccount() {
	return account;
}
public void setAccount(Account account) {
	this.account = account;
}
@Override
public String toString() {
	return " {key=" + key + ", user=" + user + ", type=" + type + ", account=" + account + "}";
}

}

package com.controller.helper;

import java.util.List;



public class Result {
 boolean success;
 Data data;
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}

public Data getData() {
	return data;
}
public void setData(Data data) {
	this.data = data;
}
@Override
public String toString() {
	return " {success=" + success + ", data=" + data + "}";
}
 


}

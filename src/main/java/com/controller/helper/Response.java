package com.controller.helper;

public class Response {
	String message;
	Object payload;
	Integer code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Response [message=" + message + ", payload=" + payload + ", code=" + code + "]";
	}
	

}

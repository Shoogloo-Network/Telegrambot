package com.controller.helper;

public class Dimensions {

	String width;
	String height;
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Dimensions [width=" + width + ", height=" + height + "]";
	}
	
}

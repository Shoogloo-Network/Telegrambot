package com.controller.helper;

public class Creatives {
	 String titile;
	 String mineType;
	 String fileName;
	 String fullUrl;
	 Dimensions dimensions;
	 
	public String getMineType() {
		return mineType;
	}
	public void setMineType(String mineType) {
		this.mineType = mineType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFullUrl() {
		return fullUrl;
	}
	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public Dimensions getDimensions() {
		return dimensions;
	}
	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}
	@Override
	public String toString() {
		return "Creatives [titile=" + titile + ", mineType=" + mineType + ", fileName=" + fileName + ", fullUrl="
				+ fullUrl + ", dimensions=" + dimensions + "]";
	}
	
}

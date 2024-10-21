package com.controller.helper;

import java.util.List;

public class Coupon {

	List<Coupons> coupons;

	public List<Coupons> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupons> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "Coupon [coupons=" + coupons + "]";
	}
	
	
}

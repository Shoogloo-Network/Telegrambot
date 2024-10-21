package com.controller.helper;

public class Coupons {

	String campaign_name;
	String code ;
	String status ;
	String campaign_id;
	String created;
	public String getCampaign_name() {
		return campaign_name;
	}
	public void setCampaign_name(String campaign_name) {
		this.campaign_name = campaign_name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCampaign_id() {
		return campaign_id;
	}
	public void setCampaign_id(String campaign_id) {
		this.campaign_id = campaign_id;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "Coupons [campaign_name=" + campaign_name + ",code=" + code + ", status=" + status + ",  campaign_id="
				+ campaign_id + ", created=" + created + "]";
	}
	
	
}

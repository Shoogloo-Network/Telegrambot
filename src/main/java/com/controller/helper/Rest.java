package com.controller.helper;

public class Rest {
 Boolean success;
 CampaignData campaignData;
public Boolean getSuccess() {
	return success;
}
public void setSuccess(Boolean success) {
	this.success = success;
}
public CampaignData getCampaignData() {
	return campaignData;
}
public void setCampaignData(CampaignData campaignData) {
	this.campaignData = campaignData;
}
@Override
public String toString() {
	return "Record [success=" + success + ", campaignData=" + campaignData + "]";
}
 
 
}

package com.controller.helper;

import java.util.List;

public class CampaignData {

	
	String page ;
	String count ;
	List<Campaigns> campaign;
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public List<Campaigns> getCampaign() {
		return campaign;
	}
	public void setCampaign(List<Campaigns> campaign) {
		this.campaign = campaign;
	}
	@Override
	public String toString() {
		return "CampaignData [page=" + page + ", count=" + count + ", campaign=" + campaign + "]";
	}
	
}

package com.controller.helper;

import java.util.List;

public class Campaigns {

	Integer id;
	String trackingLink;
	String title;
	String description;
	String model;
	String thumbnail;
	String kpi;
	String currency;
	String appName;
	String appId;
	List<Isps> isps;
	List<countries> countries;
	List<Catogries> catogries;
	List<Os> os;
	List<Devices> devices;
	String goals;
	String defaultGoal;
	List<Creatives> creatives;
	List<Payouts> payouts;
	String previewUrl;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getKpi() {
		return kpi;
	}
	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getTrackingLink() {
		return trackingLink;
	}
	public void setTrackingLink(String trackingLink) {
		this.trackingLink = trackingLink;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getPreviewUrl() {
		return previewUrl;
	}
	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}
	public List<Isps> getIsps() {
		return isps;
	}
	public void setIsps(List<Isps> isps) {
		this.isps = isps;
	}
	public List<countries> getCountries() {
		return countries;
	}
	public void setCountries(List<countries> countries) {
		this.countries = countries;
	}
	public List<Catogries> getCatogries() {
		return catogries;
	}
	public void setCatogries(List<Catogries> catogries) {
		this.catogries = catogries;
	}
	public List<Os> getOs() {
		return os;
	}
	public void setOs(List<Os> os) {
		this.os = os;
	}
	public List<Devices> getDevices() {
		return devices;
	}
	public void setDevices(List<Devices> devices) {
		this.devices = devices;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public String getDefaultGoal() {
		return defaultGoal;
	}
	public void setDefaultGoal(String defaultGoal) {
		this.defaultGoal = defaultGoal;
	}
	public List<Creatives> getCreatives() {
		return creatives;
	}
	public void setCreatives(List<Creatives> creatives) {
		this.creatives = creatives;
	}
	public List<Payouts> getPayouts() {
		return payouts;
	}
	public void setPayouts(List<Payouts> payouts) {
		this.payouts = payouts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Campaigns [id=" + id + ", tracking_link=" + trackingLink + ", title=" + title + ", description="
				+ description + ", model=" + model + ", thumbnail=" + thumbnail + ", kpi=" + kpi + ", currency="
				+ currency + ", app_name=" + appName + ", app_id=" + appId + ", isps=" + isps + ", countries="
				+ countries + ", catogries=" + catogries + ", os=" + os + ", devices=" + devices + ", goals=" + goals
				+ ", defaultGoal=" + defaultGoal + ", creatives=" + creatives + ", payouts=" + payouts
				+ ", preview_url=" + previewUrl + "]";
	}
	
	
}

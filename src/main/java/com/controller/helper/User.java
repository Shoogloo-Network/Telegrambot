package com.controller.helper;

import java.util.Arrays;
import java.util.List;

public class User {
	List<Tags> tags;
	Region region;
	String username ;
	String name ;
	String email;
	Boolean unsubscribe;
	Boolean is_demo;
	Macro macro;
	String status;
	String created;
	String company;
	String modified;
	String login;
	List<Managers> managers;
	String hashId;
	long id;
	List<WhitelistAdv> whitelistAdv;
	List<BlockedSources> blockedSources;
	Bank bank;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getUnsubscribe() {
		return unsubscribe;
	}
	public void setUnsubscribe(Boolean unsubscribe) {
		this.unsubscribe = unsubscribe;
	}
	public Boolean getIs_demo() {
		return is_demo;
	}
	public void setIs_demo(Boolean is_demo) {
		this.is_demo = is_demo;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHashId() {
		return hashId;
	}
	public void setHashId(String hashId) {
		this.hashId = hashId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Macro getMacro() {
		return macro;
	}
	public void setMacro(Macro macro) {
		this.macro = macro;
	}
	
	
	public List<Managers> getManagers() {
		return managers;
	}
	public void setManagers(List<Managers> managers) {
		this.managers = managers;
	}
	public List<WhitelistAdv> getWhitelistAdv() {
		return whitelistAdv;
	}
	public void setWhitelistAdv(List<WhitelistAdv> whitelistAdv) {
		this.whitelistAdv = whitelistAdv;
	}
	public List<BlockedSources> getBlockedSources() {
		return blockedSources;
	}
	public void setBlockedSources(List<BlockedSources> blockedSources) {
		this.blockedSources = blockedSources;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	@Override
	public String toString() {
		return "{tags=" + tags + ", region=" + region + ", username=" + username + ", name=" + name + ", email="
				+ email + ", unsubscribe=" + unsubscribe + ", is_demo=" + is_demo + ", macro=" + macro + ", status="
				+ status + ", created=" + created + ", company=" + company + ", modified=" + modified + ", login="
				+ login + ", managers=" + managers + ", hashId=" + hashId + ", id=" + id + ", whitelistAdv="
				+ whitelistAdv + ", blockedSources=" + blockedSources + ", bank=" + bank + "}";
	}
	

}

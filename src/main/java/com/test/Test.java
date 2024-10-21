package com.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.controller.helper.Campaigns;
import com.telgrambot.util.HttpCon;
import com.telgrambot.util.Utility;

public class Test {
	

	public static void main(String[] args) {
	//	String json="{\"key\"=zmc1lmiuyzgezmc1lmiuyzgf, user={tags=[], region={address=, country=ALL, state=, city=, zipcode=, lang=en}, username=DONT Remove added by system!!, name=DEMO Publisher, email=demo_publisher@shoogloo.com, unsubscribe=false, is_demo=true, macro={p1={your-transaction-id}, source={your-sub-aff-id}}, status=active, created=2023-05-31T12:46:08.000Z, company=DEMO Publisher, modified=2023-09-19T07:12:48.071Z, login=2023-09-19T07:12:48.000Z, managers=[], hashId=647741902f2eb20e25057d71, id=2, whitelistAdv=[], blockedSources=[], bank={}}, type=publisher, account={name=Shoogloo Media}}}"
		String set = "shyaway";
		HttpCon httpCon = new HttpCon();
	//	Map<String, Campaigns> compaignsMap = httpCon.getCampaigns("6250310783");
		//ArrayList<String> keyList = new ArrayList<String>(compaignsMap.keySet());
	//	ArrayList<Campaigns> valueList = new ArrayList<Campaigns>(compaignsMap.values());
		ArrayList<Object> valueList = new ArrayList<>();
		valueList.add("https://www.koskii.com/");
				
		valueList.add(	 "https://jblpro.com/en\r\n");
		valueList.add(	"https://www.dyson.in/\r\n");
		valueList.add(	 "https://in.puma.com\r\n");
		valueList.add(	 "http://shyaway.com/\r\n");
		valueList.add(	 "https://www.boat-lifestyle.com/\r\n");
		
			
		for(Object element : valueList) {
		//	System.out.println(element.equals(set));
		//System.out.println(	((String) element).contains(set));
			
		//	System.out.println(((Campaigns) element).getPreviewUrl());
			if(((String) element).contains(set)) {
				System.out.println("present ");
			}
		}
//		 Map<Integer, String> myMap = new HashMap<>();
//	      myMap.put(1, "Java");
//	      myMap.put(2, "JavaFX");
//	      myMap.put(3, "CoffeeScript");
//	      myMap.put(4, "TypeScript");
//
//	      ArrayList<Integer> keyList = new ArrayList<Integer>(myMap.keySet());
//	      ArrayList<String> valueList = new ArrayList<String>(myMap.values());
//
//	      System.out.println("contents of the list holding keys the map ::"+keyList);
//	      System.out.println("contents of the list holding values of the map ::"+valueList);
//	      for (String element : valueList){
//	          if (element.contains("Java")){
//	                System.out.println(element);
//	           myMap.put(1, element);
	          }
	
	   // if(  valueList.contains(set)) System.out.println("hello ");;
	}

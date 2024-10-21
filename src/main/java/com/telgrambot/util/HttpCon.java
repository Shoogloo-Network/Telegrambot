package com.telgrambot.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.controller.helper.Campaigns;
import com.controller.helper.Coupons;
import com.controller.helper.Data;
import com.controller.helper.Response;
import com.controller.helper.Rest;
import com.controller.helper.Result;
import com.controller.helper.User;
import com.telgrambot.MessageResponse;

@Service
public class HttpCon {

//	@Value("${trackier.url}")
//	private String trackierUrl;
//	@Value("${trackier.apiKey}")

	private String trackierApiKey;
	public static HashMap<String, Data> traickerProperty = new HashMap<String, Data>();

	// method to get campaigns
	public List<Campaigns> getCampaigns(String chatId) {
		Utility utility = new Utility();
		RestTemplate restTemplate = new RestTemplate();
		// String url = uri+"?apiKey="+trackierApiKey;
		String uri = "https://api.trackier.com/v2/publisher/campaigns?apiKey="
				+ HttpCon.traickerProperty.get(chatId).getKey();

		List< Campaigns> campaignsList = new ArrayList<Campaigns>();
		try {
			System.out.println("url=" + uri);
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.add("Content-Type", "application/json");
			headers.add("accept", "application/json");
			HttpEntity<String> entity = new HttpEntity<>(headers);
			ResponseEntity<Map> result = restTemplate.exchange(uri, HttpMethod.GET, entity, Map.class);
			Rest res = new Rest();
			res.setSuccess(res.getSuccess());
			@SuppressWarnings("unchecked")
			HashMap<String, Object> daa1 = (HashMap<String, Object>) result.getBody().get("data");

			List<Map<String, Object>> list2 = (List<Map<String, Object>>) daa1.get("campaigns");
			for (Map<String, Object> da1 : list2) {
				Campaigns campaign = new Campaigns();
				campaign.setId((Integer) da1.get("id"));
				campaign.setPreviewUrl("" + da1.get("preview_url"));
				campaign.setTrackingLink("" + da1.get("tracking_link"));
				campaignsList.add(campaign);
//			for (Campaigns element : campaignsList) {
//				System.out.println("element=" + element);
//		}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  campaignsList ;
	}

	// method for login
	public Response postResponse(String uri, Object body, String chatId, String userId) {

		Response response = new Response();
		try {
			System.out.println("body=" + body);
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.add("Content-Type", "application/json");
			headers.add("accept", "application/json");
			HttpEntity<Object> entity = new HttpEntity<>(body, headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<HashMap> result1 = restTemplate.postForEntity(uri, entity, HashMap.class);
			Result res = new Result();
			res.setSuccess(res.isSuccess());
			System.out.println("result==1 :" + result1.getBody());
			HashMap<String, Object> daa1 = (HashMap<String, Object>) result1.getBody().get("data");
			response.setCode(result1.getStatusCode().value());
			response.setPayload(result1.getBody());
			System.out.println(res.toString());
			Data data = new Data();
			User user = new User();
			data.setKey("" + daa1.get("key"));
			data.setType("" + daa1.get("type"));
			HashMap<String, Object> user1 = (HashMap<String, Object>) daa1.get("user");
			user.setId(Long.parseLong("" + user1.get("id")));
			data.setUser(user);
			System.out.println("dataclass:" + data);
			String Key = (String) daa1.get("key");
			System.out.println("user1" + user1);
			System.out.println("id:" + user1.get("id"));
			System.out.println("only key :" + Key);
			traickerProperty.put(chatId, data);
			System.out.println("hashmap:" + traickerProperty);
			System.out.println("data :" + data);
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(403);
			response.setMessage("Application Error" + e.getLocalizedMessage());
		}
		return response;
	}

	public String getCoupons(String chatId) {

		RestTemplate restTemplate = new RestTemplate();
		// String url = uri+"?apiKey="+trackierApiKey;
		String uri = "https://api.trackier.com/v2/publishers/coupons?apiKey="
				+ HttpCon.traickerProperty.get(chatId).getKey();
		StringBuilder stringbuffer = new StringBuilder();
		Map<String, Coupons> couponsMap = new HashMap<String, Coupons>();
		try {
			System.out.println("url=" + uri);
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.add("Content-Type", "application/json");
			headers.add("accept", "application/json");
			HttpEntity<String> entity = new HttpEntity<>(headers);
			ResponseEntity<Map> result = restTemplate.exchange(uri, HttpMethod.GET, entity, Map.class);
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list2 = (List<Map<String, Object>>) result.getBody().get("coupons");

			for (Map<String, Object> da1 : list2) {
				Coupons coupons = new Coupons();
				coupons.setCampaign_id("" + da1.get("campaign_id"));
				coupons.setCode("" + da1.get("code"));
				coupons.setCampaign_name("" + da1.get("campaign_name"));
				stringbuffer.append("\nCampaignName:\t" + coupons.getCampaign_name());
				stringbuffer.append("\nCode:\t" + coupons.getCode());
				stringbuffer.append("\nUrl:\t" + "https://tsm.s3g6.com/click?" + "campaign_id="
						+ coupons.getCampaign_id() + "&pub_id=2");
				stringbuffer.append("           \n");

				couponsMap.put("" + da1.get("campaign_id"), coupons);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringbuffer.toString();
	}
}
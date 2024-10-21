package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.controller.helper.Campaigns;
import com.controller.helper.Response;
import com.telgrambot.service.LoginService;
import com.telgrambot.util.HttpCon;
import com.utility.model.TelegramInfo;

@Controller
@RequestMapping("telegrambot")
public class webController {
	@Autowired
	LoginService service;
	@Autowired
	HttpCon httpConn;

	@RequestMapping(value = "/login/{chatId}/user/{userId}", method = RequestMethod.GET)
	public ModelAndView showLoginPage(ModelMap model, @PathVariable(value = "chatId") String chatId,
			@PathVariable(value = "userId") String userId) {
		System.out.println("hello");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("chatId", chatId);
		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@CrossOrigin
	@PostMapping("/loginCheck")
	public ModelAndView searchresults(@RequestParam(value = "chatId", required = false) String chatId,
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "password", required = false) String password) {
		String uri = "https://api.trackier.com/v2/login?apiKey=65015890e72a35e623e9490da6865015890e72e7";
		// List<TelegramInfo> store =
		// trackierTokenResponseRepository.findByUserId(userId);
		TelegramInfo info = new TelegramInfo();
		System.out.println("cahtid" + chatId + "ooooo=" + userId);
		info.setPassword(password);
		info.setEmail(email);
		info.setNetworkUrl("https://shoogloo.trackier.io/");
		Response res = httpConn.postResponse(uri, info, chatId, userId);
		// System.out.println("rrrr" +res.getPayload());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("thankYou");
		return modelAndView;
	}

	@CrossOrigin
	@GetMapping("/campaign/chatId")
	public Response getresult(@RequestParam(value = "chatId", required = false) String chatId) {

		List<Campaigns> compaignsMap = httpConn.getCampaigns(chatId);

		Response res = new Response();
		res.setCode(200);
		res.setMessage("successfull ");
		res.setPayload(compaignsMap);
		System.out.println("res=" + res);
		return res;
	}
	@CrossOrigin
	@GetMapping("/coupons/chatId")
	public Response getresult1( @RequestParam(value="chatId" , required= false) String chatId ) {
	
		String couponsMap = httpConn.getCoupons(chatId);
		
		Response res =new Response();
		res.setCode(200);
		res.setMessage("successfull ");
		res.setPayload(couponsMap);
		System.out.println("res="+res);
		return res;
	}
}
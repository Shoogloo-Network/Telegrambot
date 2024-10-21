package com.telgrambot.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import com.controller.helper.Campaigns;
import com.controller.helper.Data;

@Service
public class Utility {

	//@Value("${Login.url}")

//	@Value("${Login.url}")

	private String Loginurl;
	public String getBaseDomain(String uri) {
		try {
			String check= "/start good";
			if(uri.equals(check)) {
				return check;
			}
			if(!uri.contains("http"))
				uri="https://"+uri;
			URL url=new URL(uri);
			
		String host="https://"+	url.getHost()+"/";
		System.out.println("host:"+host);
		return host;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return uri;
	}
public static void main(String a[])
{
	Utility utility=new Utility();
	boolean aa=utility.compareUrls("fff","anc.com");	
	System.out.println("aaa="+aa);
}
	public  String specialCharRemove(String name) {
		try {
	name=	name.replace(" ", "\\ ")
		    .replace(".", "\\.")
		    .replace("'", "&apos;")
		    .replace("`", "\\`")
		    .replace("{", "\\{")
		    .replace("}", "\\}")
 			.replace("=", "\\=")
 			.replace("?", "\\?")
 			.replace("_", "\\_")
 			.replace(":", "\\:")
 			.replace("-", "\\-")
	         .replace(";", "\\;")
	         .replace("+","\\+")
	         .replace("~","\\~")
	         .replace("&", "\\&");
			
		}catch(Exception e) {}
		return name;
	
}
	public boolean compareUrls(String inputUrl, String previewUrl) {
		 previewUrl =  previewUrl.replaceAll("http(s)?://|www\\.|/.*", "");
		 inputUrl =  inputUrl.replaceAll("http(s)?://|www\\.|/.*", "");
		 if(previewUrl.equals(inputUrl))
			 return true;
			 else
				 return false;
	
	}
	public String getTrackingLink(String uri,Data user,Campaigns campaign) {
		System.out.println("dataobj:" + user);

		/*if (uri.contains("?")) {
			uri =uri.replace("?", "&");
			String uri1 = "https://tsm.s3g6.com/click?" + "campaign_id=" +campaign.getId()
					+ "&pub_id=" + user.getUser().getId() + "&url=" + uri;
			String escapedMsg = specialCharRemove(uri1);
		return escapedMsg;
		} else {
>>>>>>> 9cfc21dc72d80e51878d544062dc4bb94d5164b5
			String uri1 = "https://tsm.s3g6.com/click?" + "campaign_id="
					+ campaign.getId() + "&pub_id=" + user.getUser().getId() + "&url="
					+ uri;
			String escapedMsg = specialCharRemove(uri1);
		return 	escapedMsg;
<<<<<<< HEAD
		
=======
		}*/
		String uri1 = "https://tsm.s3g6.com/click?" + "campaign_id="
				+ campaign.getId() + "&pub_id=" + user.getUser().getId() + "&url="
				+ uri;
		String escapedMsg = specialCharRemove(uri1);
		return 	escapedMsg;

		
	}
	public SendMessage getStartMessage(Boolean logedIn,SendMessage sndmsg,Long chatId) {	
		System.out.println("this is bot");
	sndmsg.enableMarkdown(true);
	sndmsg.setParseMode(ParseMode.MARKDOWN);
	sndmsg.setChatId(chatId);
	InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
	List<List<InlineKeyboardButton>> inlinebutton = new ArrayList<>();
	List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
	List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
	InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
	if(logedIn)
	inlineKeyboardButton3.setText("login");
	else
		inlineKeyboardButton3.setText("login");
//	inlineKeyboardButton3.setUrl("https://bot.shoogloo.com/telegrambot/login/"
//	 + msg.getChatId()+ "/user/" + msg.getChatId());
//	inlineKeyboardButton3.setUrl("http://hardik.com:9090/telegrambot/login/"+ chatId + "/user/" + chatId);
	inlineKeyboardButton3.setUrl("http://bot.shoogloo.com/telegrambot/login/"+ chatId + "/user/" + chatId);
	inlineKeyboardButtonList1.add(inlineKeyboardButton3);
	inlinebutton.add(inlineKeyboardButtonList);
	inlinebutton.add(inlineKeyboardButtonList1);
	inlineKeyboardMarkup.setKeyboard(inlinebutton);
	sndmsg.setReplyMarkup(inlineKeyboardMarkup);
	return sndmsg;
	}
}
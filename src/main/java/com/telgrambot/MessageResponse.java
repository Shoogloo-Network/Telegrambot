package com.telgrambot;

import java.util.List;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import com.controller.helper.Campaigns;
import com.controller.helper.Data;
import com.telgrambot.util.HttpCon;
import com.telgrambot.util.Utility;

@Service
public class MessageResponse {
	
//	@Value("${server.host}")
//	private String serverHost;

	
}

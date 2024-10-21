package com.telgrambot;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.controller.helper.Campaigns;
import com.controller.helper.Data;
import com.telgrambot.util.HttpCon;
import com.telgrambot.util.Utility;

public class Bot extends TelegramLongPollingBot {
	Utility utility = new Utility();
	HttpCon httpCon = new HttpCon();
	String check = "/start good";

	@Override
	public void onUpdateReceived(Update update) {
		// System.out.println("ff="+update);
		String message = update.getMessage().getText();
		sendMsg(update.getMessage().getChatId().toString(), message);
		// keyboard button code
		if (update.hasMessage()) {
			MessageResponse messageResponse = new MessageResponse();
			try {
				Message message2 = update.getMessage();
				String txt = message2.getText();
				if (txt.equals("/campaigns")) {
					sendCampains(update);
				} else {
					SendMessage msg = gotMessage(update);
					execute(msg);
				}
				// System.out.println("update="+mess.getText());

			} catch (TelegramApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (update.hasCallbackQuery()) {
			Message msg = update.getCallbackQuery().getMessage();
			CallbackQuery callbackQuery = update.getCallbackQuery();
			String data = callbackQuery.getData();
			SendMessage sndmsg = new SendMessage();
			sndmsg.setParseMode(ParseMode.MARKDOWN);
			sndmsg.setChatId(msg.getChatId());
			if (data.equals("usa")) {
				sndmsg.setText("welcome to india u selected hindi ");
			} else if (data.equals("india")) {
				sendMultipleLinesText(callbackQuery.getMessage().getChatId());
			}
			try {
				execute(sndmsg);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

		String command = update.getMessage().getText();
		if (command.equals("/run")) {
			String mssage = "test complete";

			SendMessage response = new SendMessage();
			response.setChatId(update.getMessage().getChatId().toString());
			response.setText(mssage);
			try {
				execute(response);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		} else if (command.equals("/select")) {
			String mssage = "select from this";

			SendMessage response = new SendMessage();
			response.setChatId(update.getMessage().getChatId().toString());
			response.setText(mssage);
			try {
				execute(response);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

	}

	public SendMessage gotMessage(Update update) throws TelegramApiException {
		SendMessage sndmsg = new SendMessage();
		Message msg = update.getMessage();
		Boolean login = true;
		if (msg.hasText()) {
			String txt = msg.getText();
			if (txt.equals("/start")) {
				String test = "Welcome messages create positive first impressions, boost employee morale, and foster customer engagement. A warm welcome message can create a favorable atmosphere for new team members or customers, making them feel valued and appreciated. A well-thought-out welcome message lays the foundation for strong peer connections and quick adaptation, particularly for newcomers to the job.";
				test = utility.specialCharRemove(test);
				sndmsg.setText(test);
				sndmsg = utility.getStartMessage(login, sndmsg, msg.getChatId());
			} else if (txt.equals("/logout")) {
				login = false;
				HttpCon.traickerProperty.remove("" + msg.getChatId());
				sndmsg.setText("you have been logged out");
				sndmsg = utility.getStartMessage(login, sndmsg, msg.getChatId());
			} else if (txt.equals("/help")) {
				sndmsg.setText("List of commands ");
				sndmsg.enableMarkdown(true);
				sndmsg.setParseMode(ParseMode.MARKDOWN);
				sndmsg.setChatId(msg.getChatId());
				sndmsg.setText("/start   login in telegram bot \n" + "/logout \t you have been log out \n "
						+ " /help \t list of commands \n" + "/campaigns \t List of campaigns \n "
						+ "/coupons \t List of coupons \n ");
			} else if (txt.equals("/coupons")) {
				sndmsg.setText("List of availabe coupons");
				sndmsg.enableMarkdown(true);
				sndmsg.setParseMode(ParseMode.MARKDOWN);
				sndmsg.setChatId(msg.getChatId());
				String couponsStr = httpCon.getCoupons("" + msg.getChatId());
				String escapedMsg = utility.specialCharRemove(couponsStr);
				escapedMsg = escapedMsg.length() > 4095 ? escapedMsg.substring(0, 4094) : escapedMsg;
				sndmsg.setText("coupons:" + " " + "\n\r" + escapedMsg);
			} else if (txt.equals(check)) {
				sndmsg.setText("welcome to bot ");
			} else {
				String uri2 = utility.getBaseDomain(txt);
				Boolean test = HttpCon.traickerProperty.containsKey("" + msg.getChatId());
				if (test == true) {
					List<Campaigns> compaignsMap = httpCon.getCampaigns("" + msg.getChatId());
					boolean containsCompains = false;
					for (Campaigns data : compaignsMap) {
						if (utility.compareUrls(txt, data.getPreviewUrl())) {
							Data user = httpCon.traickerProperty.get("" + msg.getChatId());
							String trackingUrl = utility.getTrackingLink(txt, user, data);
							sndmsg.enableHtml(true);
							sndmsg.setParseMode(ParseMode.HTML);
							System.out.println("trackingUrl:" + trackingUrl);
							sndmsg.setText("campaigns" + " " + trackingUrl);
							containsCompains = true;
						}
					}
					// if no companins match with url
					if (containsCompains == false) {
						sndmsg.enableHtml(true);
						String escapedMsg = utility.specialCharRemove(txt);
						sndmsg.setText(escapedMsg + " is not your campaign");
					}
				} else {
					sndmsg.setText("login first");
				}
			}
		}
		sndmsg.setChatId(msg.getChatId());
		sndmsg.setParseMode(ParseMode.MARKDOWNV2);
		return sndmsg;
	}

	public synchronized void sendMsg(String chatId, String s) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(chatId);
		sendMessage.setText(s);

	}

	private void sendMultipleLinesText(Long chatId) {
		StringBuilder messageText = new StringBuilder();
		messageText.append("Line 1\n");
		messageText.append("Line 2\n");
		messageText.append("Line 3\n");

		SendMessage message = new SendMessage();
		message.setChatId(chatId);
		message.setText(messageText.toString());

		try {
			execute(message);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	public synchronized void setButtons(SendMessage sendMessage) {
		// Create a keyboard
		System.out.println("sendMessagee" + sendMessage);
		if (sendMessage.equals("usa")) {

			ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
			sendMessage.setReplyMarkup(replyKeyboardMarkup);
			replyKeyboardMarkup.setSelective(true);
			replyKeyboardMarkup.setResizeKeyboard(true);
			replyKeyboardMarkup.setOneTimeKeyboard(false);

			// Create a list of keyboard rows
			List<KeyboardRow> keyboard = new ArrayList<>();

			// First keyboard row
			KeyboardRow keyboardFirstRow = new KeyboardRow();
			// Add buttons to the first keyboard row
			keyboardFirstRow.add(new KeyboardButton("Hi"));

			// Second keyboard row
			KeyboardRow keyboardSecondRow = new KeyboardRow();
			// Add the buttons to the second keyboard row
			keyboardSecondRow.add(new KeyboardButton("Help"));

			// Add all of the keyboard rows to the list
			keyboard.add(keyboardFirstRow);
			keyboard.add(keyboardSecondRow);
			// and assign this list to our keyboard
			replyKeyboardMarkup.setKeyboard(keyboard);
		}
	}

	/**
	 * This method returns the bot's name, which was specified during registration.
	 * 
	 * @return bot name
	 */
//	@Override
//	public String getBotUsername() {
//		return "demo_test_first_bot";
//	}
//
//	/**
//	 * This method returns the bot's token for communicating with the Telegram
//	 * server
//	 * 
//	 * @return the bot's token
//	 */
//	@Override
//	public String getBotToken() {
//		return "6405356240:AAGgdasXyIy49_FsEgs2DiS5cPcQmaAs4LM";
//	}
	@Override
	public String getBotUsername() {
		return "AlertShoogloo_bot";
	}

	/**
	 * This method returns the bot's token for communicating with the Telegram
	 * server
	 * 
	 * @return the bot's token
	 */
	@Override
	public String getBotToken() {
		return "5894577759:AAEgABAydp8N615Nuy9gL7PF5pqxiwfIbWk";
	}

	public void sendCampains(Update update) {
		SendMessage sndmsg = new SendMessage();
		Message msg = update.getMessage();
		sndmsg.setText("List of campaigns");
		sndmsg.enableMarkdown(true);
		sndmsg.setParseMode(ParseMode.MARKDOWN);
		sndmsg.setChatId(msg.getChatId());
		List<Campaigns> compaignsList = httpCon.getCampaigns("" + msg.getChatId());
		StringBuilder stringBuilder = new StringBuilder();
		String shortMsg = new String();
		for (Campaigns data : compaignsList) {
			System.out.println("data:" + data);
			if (data.getPreviewUrl() != "") {
			//	String escapedMsg = utility.specialCharRemove(data.getPreviewUrl());
				String escapedMsg = (data.getPreviewUrl());
				stringBuilder.append(escapedMsg);
				stringBuilder.append("\n\r\t");
			}
		}

		int chunkSize = 3000;
		int min = 0;
		int max = 3000;
		int chunkCount = (stringBuilder.length() / chunkSize) + (stringBuilder.length() % chunkSize == 0 ? 0 : 1);
		System.out.println("kkk" + chunkCount);
		String returnVal = stringBuilder.toString();
		;
		for (int i = 0; i < chunkCount; i++) {
			String val = null;
			if (returnVal.length() > chunkSize) {
				val = returnVal.substring(min, max);
				returnVal = returnVal.substring(max);
				if (val.lastIndexOf("\n") != val.length() - 1) {
					{
						val = val + returnVal.substring(0, returnVal.indexOf("\n"));
						returnVal = returnVal.substring(returnVal.indexOf("\n") + 1);
					}

				}
			} else
				val = returnVal;
			val = val + "\n\r";
		//	String val2 = utility.specialCharRemove(val);

		//	if (i > 0)
		//	continue;

			System.out.println("val  :" + val);
			System.out.println("val ll :" + val.length());

			sndmsg.setText("campaigns" + "\n" + " " + "\t" + val);
			sndmsg.setChatId(msg.getChatId());
			sndmsg.setParseMode(ParseMode.MARKDOWN);
			try {
				execute(sndmsg);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}

		}

		// sndmsg.setText("campaigns" +"\n"+ " " + "\t" + stringBuilder);

	}
}
package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.telgrambot.Bot;

@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableAutoConfiguration
@PropertySource("file:/opt/work/property/telegram.properties")
@SpringBootApplication
public class CommandLine extends SpringBootServletInitializer {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CommandLine.class);
    }
	public static void main(String[] args) throws TelegramApiException {
		SpringApplication.run(CommandLine.class, args);
		TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
		botsApi.registerBot(new Bot());
	}

}

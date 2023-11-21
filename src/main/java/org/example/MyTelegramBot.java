package org.example;

import org.glassfish.jersey.message.internal.Utils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


import javax.sql.RowSet;

public class MyTelegramBot extends TelegramLongPollingBot {

    final String BOT_NAME;
    final String BOT_TOKEN;
    final String URL = "https://api.nasa.gov/planetary/apod?api_key=FVxCIdXfwDlOTzghLkfghHFFbpG7e5EsPd1o5Hw9";

    public MyTelegramBot(String BOT_NAME, String BOT_TOKEN) {
        this.BOT_NAME = BOT_NAME;
        this.BOT_TOKEN = BOT_TOKEN;

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            String[] separatedAnswer = update.getMessage().getText().split(" ");

            String action = separatedAnswer[0];
            long chatId = update.getMessage().getChatId();

            switch (action) {

                case "/help":
                    sendMessage("Ich bin Bot von Nasa (by Arthur Kelm).\nSchreib /image\noder /date YYYY-MM-DD", chatId);
                    break;

                case "/image":
                    String url = Tools1.getUrl(URL);
                    sendMessage(url, chatId);
                    break;

                case "/date":
                    url = Tools1.getUrl (URL + "&date=" + separatedAnswer[1]);
                    sendMessage(url, chatId);
                    break;

                default:
                    sendMessage("Ich verstehe nicht.\nSchreib bitte /help", chatId);
            }
        }
    }

    private void sendMessage(String msg, long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(msg);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.out.println("Die Nachricht konnte nicht gesendet werden");
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}

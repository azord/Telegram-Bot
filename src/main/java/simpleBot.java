import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class simpleBot extends TelegramLongPollingBot {
    SendMessage message;
    Burgers burgers;
    Beverages beverages;
    Fries fries;
    int price;
    HashMap<String, Integer> mp;

    simpleBot() {
        price = 0;
        burgers = new Burgers();
        beverages = new Beverages();
        fries = new Fries();
        mp = new HashMap<>();
        mp.put("Chicken burger - 600 tg", 600);
        mp.put("Beef burger - 800 tg", 800);
        mp.put("Coke - 200", 200);
        mp.put("Sprite - 190", 190);
        mp.put("Fanta - 200", 200);
        mp.put("Fries - 450", 450);
    }

    @Override
    public void onUpdateReceived(Update update) {
   //     System.out.println(update.getMessage().getText());
   //     System.out.println(update.getMessage().getFrom().getFirstName());

        String command = update.getMessage().getText();
        String chatId = update.getMessage().getChatId().toString();

        if (command.equals("/start")) {
            sendCustomKeyboard(chatId);
        } else if (command.equals("Burger")) {
            sendCustomBurger(chatId);
        } else if (command.equals("Beverages")) {
            sendCustomBeverages(chatId);
        } else if (command.equals("Fries")) {
            sendCustomFries(chatId);
        } else if (command.equals("Calculate final Price")) {
            String finalPrice = Integer.toString(price);
            price = 0;
            message.setText("You total price - " + finalPrice + "tg\nYour Order Will be Delivered!\nBye" );

            try {
                execute(message);
            } catch (TelegramApiException E) {
                E.printStackTrace();
            }

        } else if (command.equals("Exit")) {
            price = 0;
            message.setText("Your order is cancelled\nTotal price - 0tg");

            try {
                execute(message);
            } catch (TelegramApiException E) {
                E.printStackTrace();
            }
            sendCustomKeyboard(chatId);
        } else {
            price += mp.get(command);
            sendCustomKeyboard(chatId);
        }

    }

    public void sendCustomFries(String chatId) {
        message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Please, choose fry: ");

        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text

        for (int i = 0; i < fries.getFrySize(); i++) {
            row.add(fries.getFry(i));
        }
        // Add the first row to the keyboard
        keyboard.add(row);

        row = new KeyboardRow();
        row.add("Exit");

        keyboard.add(row);

        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException E) {
            E.printStackTrace();
        }

    }

    public void sendCustomBeverages(String chatId) {
        message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Please, choose beverage: ");

        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text

        for (int i = 0; i < beverages.getBeverageSize(); i++) {
            row.add(beverages.getBeverages(i));
        }
        // Add the first row to the keyboard
        keyboard.add(row);

        row = new KeyboardRow();
        row.add("Exit");

        keyboard.add(row);

        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException E) {
            E.printStackTrace();
        }

    }

    public void sendCustomBurger(String chatId) {
        message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Please, choose burger");

        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text

        for (int i = 0; i < burgers.getBurgerSize(); i++) {
            row.add(burgers.getBurger(i));
        }
        // Add the first row to the keyboard
        keyboard.add(row);

        row = new KeyboardRow();
        row.add("Exit");

        keyboard.add(row);

        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException E) {
            E.printStackTrace();
        }

    }


    public void sendCustomKeyboard(String chatId) {
        message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Choose food:");

        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        row.add("Burger");
        row.add("Beverages");
        row.add("Fries");

        // Add the first row to the keyboard
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("Calculate final Price");
        row.add("Exit");

        keyboard.add(row);

        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException E) {
            E.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        // TODO
        return "CSS108SimpleBot";
    }

    @Override
    public String getBotToken() {
        String BOT_TOKEN = System.getenv("BOT_TOKEN");
        return BOT_TOKEN;
    }

    /*
    * Token for the bot Food Delivery @CSS108SimpleBot has been revoked. New token is:

2115630793:AAEsgzMIhQ5l-axxFSW8m4_KcarFpaOrk7o
    *
    * */
}

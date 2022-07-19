import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "Eris Greyrat";
    }

    @Override
    public String getBotToken() {
        return "5513078107:AAHF807wmDr-uMValYzOeZ3zzN4NzoJJPO8";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String name = update.getMessage().getFrom().getFirstName();
        System.out.println(name);
        System.out.println(update.getMessage().getText());
        if(update.getMessage().getText().equals("/start")||update.getMessage().getText().equals("/start@Eris_Porridge_bot")){
            System.out.println("lol");
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Привет! Я Эрис из Реинкарнации Безработного(Крутое анимэ рекомендую)\n" +
                    "Предлагаю оценить насколько ты Zумер, для этого просто напиши команду /check\n" +
                    "Мяууууу!!!");
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if(update.getMessage().getText().equals("/check")||update.getMessage().getText().equals("/check@Eris_Porridge_bot")){
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            double d = Math.random()*100;
            int zumer = (int) d;
            System.out.println(zumer);
            String s;
            if(zumer<20){
                s=name+", ты зумур на "+zumer+"%\n"+"Тебе явно не стоит качать тик ток и флексить под Дору\n"+"Мяу";
            }
            else if(zumer>=80){
                s=name+", ты зумер на "+zumer+"%\n"+"Поздравляю ты самый настоящий зумер, можешь достать из своего шопера поридж с разбери и запить это бабл ти\n"
                        +"Мяяяяяууу";
            }
            else {
                s=name+", ты зумер на "+zumer+"%\n"+"Мур мяяяууу!!!";
            }
            message.setText(s);
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if(update.getMessage().getText().equals("/university")||update.getMessage().getText().equals("/university@Eris_Porridge_bot")){
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Я еще конечно молодая, но весь наш Волшебный мир знает, что лучший вуз в России(Лучшей стране мира мур мяу) \n"+
                    "это конечно ИТМО - Институт Теплых Мужских Отношений, я была бы не проч там учится!!! Мурррр");
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if(update.getMessage().getText().equals("/mimi")||update.getMessage().getText().equals("/mimi@Eris_Porridge_bot")){
            System.out.println("lol");
            System.out.println(update.getMessage().toString());
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Денис краш!!!! Мяу");
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}

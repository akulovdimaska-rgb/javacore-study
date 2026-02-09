package Home.SystemNotification;

public class TelegramNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("Telegram отправлен: Привет! " +  message);
    }
}

package Home.SystemNotification;

public class SmsNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("Sms отправлен: Привет! " + message);
    }
}

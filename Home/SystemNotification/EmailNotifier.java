package Home.SystemNotification;

public class EmailNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("Email отправлен: Привет! " + message);
    }
}

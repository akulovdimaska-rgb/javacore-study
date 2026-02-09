package Home.SystemNotification;

public class PushNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("Push отправлен: Привет! " +  message);
    }
}

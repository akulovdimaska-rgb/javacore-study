package Home.SystemNotification;

public class NotificationService {
    private Notifier notifier;

    public NotificationService() {}

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notifyUser(String message) {
        notifier.send(message);
    }
}

package Home.SystemNotification;

/**
 * В приложении есть система уведомлений, которая может отправлять сообщения разными способами:
 * Email
 * SMS
 * Push-уведомления
 * Нужно спроектировать систему так, чтобы можно было легко добавлять новые способы уведомлений, не меняя существующий код.
 * <p>
 * 🧱 Требования
 * 1️⃣ Создай интерфейс
 * public interface Notifier {
 * void send(String message);
 * }
 * <p>
 * 2️⃣ Реализуй несколько классов
 * EmailNotifier — отправляет сообщение по email
 * SmsNotifier — отправляет SMS
 * PushNotifier — отправляет push-уведомление
 * <p>
 * Пример поведения:
 * Email отправлен: Привет!
 * SMS отправлено: Привет!
 * Push-уведомление отправлено: Привет!
 * <p>
 * 3️⃣ Используй интерфейс в коде
 * Создай класс NotificationService, который:
 * принимает Notifier в конструкторе
 * имеет метод notifyUser(String message)
 * не знает, какой именно тип уведомления используется
 * public class NotificationService {
 * private Notifier notifier;
 * public NotificationService(Notifier notifier) {
 * this.notifier = notifier;
 * }
 * <p>
 * public void notifyUser(String message) {
 * notifier.send(message);
 * }
 * }
 * <p>
 * 4️⃣ Используй всё в main
 * public class Main {
 * public static void main(String[] args) {
 * Notifier email = new EmailNotifier();
 * NotificationService service = new NotificationService(email);
 * <p>
 * service.notifyUser("Ваш заказ оформлен");
 * }
 * }
 * <p>
 * 🎯 Цель задачи
 * <p>
 * Ты должен показать, что понимаешь:
 * <p>
 * зачем нужны интерфейсы
 * <p>
 * полиморфизм
 * <p>
 * слабую связанность
 * <p>
 * принцип Dependency Inversion
 */
public class Main {
    public static void main(String[] args) {
        Notifier email = new EmailNotifier();
        Notifier sms = new SmsNotifier();
        Notifier push = new PushNotifier();
        Notifier telegram = new TelegramNotifier();

        NotificationService service = new NotificationService();

        service.setNotifier(email);
        service.notifyUser("Ваш заказ оформлен");
        service.setNotifier(sms);
        service.notifyUser("Ваш заказ оформлен");
        service.setNotifier(push);
        service.notifyUser("Ваш заказ оформлен");
        service.setNotifier(telegram);
        service.notifyUser("Ваш заказ оформлен");

    }

}

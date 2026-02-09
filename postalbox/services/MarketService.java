package postalbox.services;


import postalbox.models.Client;
import postalbox.models.Order;
import postalbox.repositories.ClientDB;
import postalbox.repositories.OrderDB;

//Market — это центр управления заказами.
// Маркет должен обращаться(работать) к списку клиентов. (аналог БД)
// отдельный класс под клиента, отдельный класс под список клиентов.
// Должен принимать номер заказа
// Должен помечать статус заказа (отдан клиенту) (прибыл)
// Добавить возможность отмены заказа (cancelOrder(numberOrder)) ?
//TODO Добавить логику по смене статуса.
//TODO Создать сервис по обработке заказа. Статус INPROGRESS


//TODO 22.11.2025 продумать логику паттерна синглтон
public class MarketService {
    private final ClientService clientService;
    private final OrderService orderService;

    public MarketService() {
        this.clientService = new ClientService();
        this.orderService = new OrderService();
    }

    public String createOrder(Client client) {
        Order order = new Order();
        orderService.save(order);
        client.setOrder(order);
        clientService.save(client);
        return String.format("Ваш заказ принят. Номер заказа: %s", order.getOrderNumber());
    }

    public String cancelOrder(Order order) {
        int orderNumber = order.getOrderNumber();
        try {
            orderService.cancel(order.getOrderNumber());
            return String.format("Заказ № %d успешно отменён.", orderNumber);
        } catch (Exception e) {
            return String.format("Заказ № %d не может быть отменён.", orderNumber);
        }

    }
}
//class MarketServiceTest{
//    static void main() {
//        ClientDB clientDB1 = new ClientDB();
//        OrderDB orderDB1 = new OrderDB();
//        Client client1 = new Client("Иванов", "Иван", "+79500584567");
//        MarketService marketService1 = new MarketService();
//        clientDB1.save(client1);
//        System.out.println(marketService1.createOrder(client1));
//        orderDB1.save(client1.getOrder());
//        System.out.println(clientDB1);
//        System.out.println(orderDB1);
//    }
//}
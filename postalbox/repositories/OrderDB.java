package postalbox.repositories;

import postalbox.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public final class OrderDB {
    private static OrderDB instance;
    private final List<Order> orderList;

    private OrderDB() {
        this.orderList = new ArrayList<>();
    }

    public static OrderDB getInstance(){
        if (instance == null){
            instance = new OrderDB();
        }
        return instance;
    }

    public Order save(Order order) {
        if (!orderList.contains(order)) {
            orderList.add(order);
        }
        // Если объект содержится в списке, то скорее всего мы его состояние уже обновили (в классе OrderService) при поиске объекта и замене его полей
        return order;
    }

    public Order findByOrderNumber(int orderNumber) {
        return orderList.stream().filter(order -> orderNumber == order.getOrderNumber()).findFirst().orElseThrow(() -> new NoSuchElementException("Заказ не найден!"));
    }

}

//class testOrderDB {
//    /**
//     * В OrderDB есть методы:
//     * save - сохранить заказ и findByOrderNumber - найти заказ по номеру заказа.
//     * Что проверить:
//     * Сохранить Заказ. Проверить его наличие.
//     * Сохранить два заказа. Проверить их наличие. Может они перезаписались.
//     * Сохранить заказ с тем же номером.
//     * Найти существующий заказ по номеру.
//     * Найти несуществующий заказ.
//     */
//    public static void main(String[] args) {
//        OrderDB orderDB = OrderDB.getInstance();
//
//        /** Сохраняю один заказ и пробую его найти*/
//        Order order6 = new Order();
//        orderDB.save(order6);
//        /** Надо ловить исключения, т.к. метод findByOrderNumber может выбросить исключение*/
//        try {
//            Order findOrder = orderDB.findByOrderNumber(order6.getOrderNumber());
//            System.out.println("Заказ № " + order6.getOrderNumber() + " найден");
//        } catch (NoSuchElementException e) {
//            System.out.println("Заказ № " + order6.getOrderNumber() + " не найден");
//        }
//        /**Сохраняю второй заказ*/
//        Order order7 = new Order();
//        orderDB.save(order7);
//
//        try {
//            Order findOrder = orderDB.findByOrderNumber(order7.getOrderNumber());
//            System.out.println("Заказ № " + order7.getOrderNumber() + " найден");
//        } catch (NoSuchElementException e) {
//            System.out.println("Заказ № " + order7.getOrderNumber() + " не найден");
//
//
//
//            Order found1 = orderDB.findByOrderNumber(1);
//            Order found2 = orderDB.findByOrderNumber(2);
//        }
//        /**Если внести заказ с тем же номером*/
//        try {
//            Order existOrder = orderDB.findByOrderNumber(1);  // находим заказ №1
//            orderDB.save(existOrder);                         // пробуем сохранить его ещё раз
//
//            // Проверяем, что заказы всё ещё на месте
//            Order found1 = orderDB.findByOrderNumber(1);
//            Order found2 = orderDB.findByOrderNumber(2);
//            System.out.println("Тест дублирования: УСПЕХ - заказы на месте");
//
//        } catch (NoSuchElementException e) {
//            System.out.println("ОШИБКА: " + e.getMessage());
//        }
//    }
//}
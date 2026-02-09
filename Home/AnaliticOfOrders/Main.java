package Home.AnaliticOfOrders;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 🧩 Задача: Анализ заказов интернет-магазина
 * 📌 Условие
 * <p>
 * Есть список заказов интернет-магазина.
 * <p>
 * class Order {
 * private String orderId;
 * private String customer;
 * private LocalDate orderDate;
 * private List<OrderItem> items;
 * <p>
 * // getters, constructor
 * }
 * <p>
 * class OrderItem {
 * private String product;
 * private String category;
 * private double price;
 * private int quantity;
 * <p>
 * // getters, constructor
 * }
 * <p>
 * 📥️ Входные данные
 * List<Order> orders;
 * <p>
 * 🎯 Требуется
 * <p>
 * Используя Stream API (без циклов for/while), реализовать следующие методы:
 * <p>
 * 1️⃣ Общая выручка по категориям
 * <p>
 * Вернуть Map<String, Double>, где:
 * <p>
 * ключ — категория товара
 * <p>
 * значение — суммарная выручка
 * (price * quantity) по всем заказам
 * <p>
 * Map<String, Double> totalRevenueByCategory(List<Order> orders)
 * <p>
 * 2️⃣ Самый дорогой заказ
 * <p>
 * Найти заказ с максимальной суммой (сумма всех OrderItem).
 * <p>
 * Optional<Order> mostExpensiveOrder(List<Order> orders)
 * <p>
 * 3️⃣ Топ-3 покупателя по общей сумме заказов
 * <p>
 * Вернуть список имён покупателей, отсортированный по убыванию суммы.
 * <p>
 * List<String> top3CustomersByTotalSpent(List<Order> orders)
 * <p>
 * 4️⃣ Средняя стоимость заказа по месяцам
 * <p>
 * Вернуть Map<YearMonth, Double>, где значение — средняя сумма заказа за месяц.
 * <p>
 * Map<YearMonth, Double> averageOrderValuePerMonth(List<Order> orders)
 * <p>
 * 5️⃣ Клиенты, покупавшие товары только из одной категории
 * <p>
 * Вернуть Set<String> клиентов, которые за всё время покупали товары строго из одной категории.
 * <p>
 * Set<String> customersWithSingleCategory(List<Order> orders)
 */

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(

                new Order(
                        "ORD-1",
                        "Alice",
                        LocalDate.of(2024, 1, 10),
                        List.of(
                                new OrderItem("iPhone 14", "Electronics", 999.99, 1),
                                new OrderItem("AirPods", "Electronics", 199.99, 1)
                        )
                ),

                new Order(
                        "ORD-2",
                        "Bob",
                        LocalDate.of(2024, 1, 15),
                        List.of(
                                new OrderItem("Clean Code", "Books", 45.00, 1),
                                new OrderItem("Design Patterns", "Books", 55.00, 1)
                        )
                ),

                new Order(
                        "ORD-3",
                        "Alice",
                        LocalDate.of(2024, 2, 5),
                        List.of(
                                new OrderItem("MacBook Pro", "Electronics", 2499.99, 1)
                        )
                ),

                new Order(
                        "ORD-4",
                        "Charlie",
                        LocalDate.of(2024, 2, 20),
                        List.of(
                                new OrderItem("Office Chair", "Furniture", 300.00, 1),
                                new OrderItem("Desk Lamp", "Furniture", 80.00, 2)
                        )
                ),

                new Order(
                        "ORD-5",
                        "Bob",
                        LocalDate.of(2024, 3, 3),
                        List.of(
                                new OrderItem("Kindle", "Electronics", 120.00, 1)
                        )
                ),

                new Order(
                        "ORD-6",
                        "Diana",
                        LocalDate.of(2024, 3, 18),
                        List.of(
                                new OrderItem("Notebook", "Stationery", 5.00, 10),
                                new OrderItem("Pen", "Stationery", 2.00, 5)
                        )
                ),

                new Order(
                        "ORD-7",
                        "Charlie",
                        LocalDate.of(2024, 3, 25),
                        List.of(
                                new OrderItem("Monitor", "Electronics", 400.00, 1)
                        )
                )
        );

        Main main = new Main();
        System.out.println(main.totalRevenueByCategory(orders));

    }

    private Map<String, Double> totalRevenueByCategory(List<Order> orders) {

        return orders.stream()
                .flatMap(order -> order.getItems()
                        .stream())
                .collect(Collectors.groupingBy(orderItem -> orderItem.getCategory(),
                        Collectors.summingDouble(item -> item.getTotalPrice()))
                );

    }
}

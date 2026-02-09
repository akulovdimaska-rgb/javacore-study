package postalbox.services;

import postalbox.models.Order;
import postalbox.enums.OrderStatus;
import postalbox.repositories.OrderDB;
import java.util.Set;
import static postalbox.enums.OrderStatus.CREATED;
import static postalbox.enums.OrderStatus.IN_PROCESSING;

public class OrderService {

    private static final Set<OrderStatus> PERMITTED_STATUSES = Set.of(CREATED, IN_PROCESSING);
    private final OrderDB orderDB;

    public OrderService() {

        this.orderDB = OrderDB.getInstance();
    }

    public Order cancel(int orderNumber) {

        Order order = orderDB.findByOrderNumber(orderNumber);
        if (!PERMITTED_STATUSES.contains(order.getStatus())) {
            throw new IllegalStateException("Невозможно отменить заказ!");
        }
        order.setStatus(OrderStatus.CANCELED);
        save(order);

        return order;
    }

    public Order updateStatus(int orderNumber, OrderStatus status) {
        Order order = orderDB.findByOrderNumber(orderNumber);
        order.setStatus(status);
        save(order);
        return order;
    }

    public Order save(Order order) {
        return orderDB.save(order);
    }

    public Order findByOrderNumber(int orderNumber) {
        return orderDB.findByOrderNumber(orderNumber);
    }

    public OrderDB getOrderDB() {
        return orderDB;
    }
}

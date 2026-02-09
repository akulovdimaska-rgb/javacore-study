package Home.AnaliticOfOrders;


import java.time.LocalDate;
import java.util.List;

public class Order {
    private String orderId;
    private String customer;
    private LocalDate orderDate;
    private List<OrderItem> items;

    public Order(String orderId, String customer, LocalDate orderDate, List<OrderItem> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<OrderItem> getItems() {
        return items;
    }
    // getters, constructor

}

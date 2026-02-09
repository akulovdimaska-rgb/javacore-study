package Home.AnaliticOfOrders;

public class OrderItem {
    private String product;
    private String category;
    private double price;
    private int quantity;

    public OrderItem(String product, String category, double price, int quantity) {
        this.product = product;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice (){
        return getPrice() * getQuantity();
    }
}

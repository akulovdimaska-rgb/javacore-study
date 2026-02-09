package postalbox.models;

import java.util.Objects;
import java.util.UUID;

// Идентификатор клиента.
public class Client {
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final UUID id;
    //TODO Сделать Set № заказов
    private Order order;
    private int accessСode;

    public Client(String lastName, String firstName, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.id = UUID.randomUUID();

    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setAccessСode(int accessСode) {
        this.accessСode = accessСode;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public UUID getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public int getAccessСode() {
        return accessСode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
package postalbox.services;

import postalbox.models.Client;
import postalbox.repositories.ClientDB;

import java.util.Optional;

public class ClientService {
    private final ClientDB clientDB;

    public ClientService() {

        this.clientDB = ClientDB.getInstance();
    }

    public Client save(Client client) {
        return clientDB.getClientById(client.getId())
                .orElseGet(()->clientDB.save(client));
    }

    public Client remove(Client client) {
        return clientDB.remove(client);

    }

    public Optional<Client> getClientByOrderNumber(int numberOrder) {
        return clientDB.getClientByOrderNumber(numberOrder);
    }

    @Override
    public String toString() {
        return "ClientService{" +
                "clientDB=" + clientDB +
                '}';
    }
}
//class ClientServiceTest{
//    static void main() {
//        ClientService clientService = new ClientService();
//        ClientDB clientDB = ClientDB.getInstance(); // Поменял код, т.к. используем Singleton
//        Client client1 = new Client("Иванов", "Иван", "+79500584567");
//        Client client2 = new Client("Сидоров", "Михаил", "+79500954567");
//        clientDB.save(client1);
//        clientService.save(client1);
//        clientDB.save(client2);
//        clientService.save(client2);
//        System.out.println(clientService);
//        System.out.println(clientDB);
//    }
//}

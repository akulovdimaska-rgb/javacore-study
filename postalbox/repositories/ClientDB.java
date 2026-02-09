package postalbox.repositories;

import postalbox.models.Client;
import postalbox.models.Order;

import java.util.*;

public final class ClientDB {
    private static ClientDB instance;
    private final List<Client> clientList;

    private ClientDB() {
        this.clientList = new ArrayList<>();
    }

    public static ClientDB getInstance(){
        if (instance == null){
            instance = new ClientDB();
        }
        return instance;
    }

    //Создаем список клиентов:
    public Client save(Client client) {
        clientList.add(client);
        return client;
    }

    // Удаление клиента:
    public Client remove(Client client) {
        clientList.remove(client);
        return client;
    }

    // Метод ниже ищет клиента по номеру заказа в списке clientList.
    public Optional<Client> getClientByOrderNumber(int numberOrder) {
/**        return clientList.stream()
 *                 .filter(client -> client.getOrder().getOrderNumber() == numberOrder)
 *                 .findFirst(); // возвращает Optional<Client> — то есть коробку, где может лежать клиент, а может быть пусто. .orElseThrow(() -> new NoSuchElementException("Клиент не найден"));
 *         Проблема: Если у клиента client.getOrder() вернет null, то .getOrderNumber() вызовет NullPointerException!
 *         При вызове выпало исключение:
 *         Exception in thread "main" java.lang.NullPointerException:
 *         Cannot invoke "postalbox.models.Order.getOrderNumber()" because the return value of "postalbox.models.Client.getOrder()" is null
 *         Нужно добавить проверку на null:
 */
        return clientList.stream().filter(client -> client.getOrder() != null) // ← ЗАЩИТА!
                .filter(client -> client.getOrder().getOrderNumber() == numberOrder)
                .findFirst();
    }

    public Optional<Client> getClientById(UUID id) {
        return clientList.stream().filter(client -> id.equals(client.getId())).findFirst();
    }
}

//class TestClientDB {
//    /**
//     * В ClientDB есть методы:
//     * save - Сохранить клиента;
//     * remove - Удалить клиента;
//     * getClientById - найти клиента по ID;
//     * getClientByOrderNumber - найти клиента по номеру заказа.
//     * Что проверить:
//     * Сохранить клиента. Проверить его в базе.
//     * Удалить клиента. Проверить что его нет.
//     * Удалить несуществующего клиента. Что будет?
//     * Найти клиента по правильному номеру заказа. Найти клиента по несуществующему номеру заказа.
//     * Найти клиента по правильному ID. Найти клиента по не существующему ID
//     */
//    public static void main(String[] args) {
//        /** сохранил 2-х клентов*/
//        Client client1 = new Client("Иванов", "Иван", "111111111");
//        Client client2 = new Client("Петров", "Пётр", "222222222");
//        ClientDB clientDB = ClientDB.getInstance();
//        clientDB.save(client1);
//        clientDB.save(client2);
//
//        /** проверяю наличие в базе*/
//        Optional<Client> foundClient1 = clientDB.getClientById(client1.getId());
//        if (foundClient1.isPresent()) {
//            System.out.println("Клиент 1 существует");
//        } else {
//            System.out.println("Клиент 1 не найден");
//        }
//        System.out.println("----------------------------------");
//        System.out.println("Удаляю клиента 2");
//
//        /** удалил клиента*/
//        clientDB.remove(client2);
//        Optional<Client> foundClient2 = clientDB.getClientById(client2.getId());
//        System.out.println("Клиент 2: " + (foundClient2.isPresent() ? "найден" : "не найден"));
//
//        /** Создал клиента с правильным номером заказа (сгенерирован автоматически)*/
//        System.out.println("----------------------------------");
//        Client client3 = new Client("Сидоров", "Сидор", "333333333");
//        Order order3 = new Order();
//        client3.setOrder(order3);
//        clientDB.save(client3);
//        /** Убедился, что клиент 3 с заказом создан*/
//        System.out.println("У клиента 3 c ID " + client3.getId() + " заказ № " + client3.getOrder().getOrderNumber());
//
//        /** Ищем клиента по правильному номеру заказа*/
//        Optional<Client> foundClientByOrder = clientDB.getClientByOrderNumber(order3.getOrderNumber());
//        System.out.println("Клиент по заказу № " + client3.getOrder().getOrderNumber() + " " + (foundClientByOrder.isPresent() ? (" найден. Его ID: " + client3.getId()) : "Не найден"));
//        System.out.println("----------------------------------");
//
//        /** Когда клиент и заказ есть, но ищем по не существующему заказу*/
//        Client client5 = new Client("Васильев", "Василий", "555555555");
//        Order order5 = new Order();
//        client5.setOrder(order5);
//        clientDB.save(client5);
//        Optional<Client> clientWithFakeOrder = clientDB.getClientByOrderNumber(555);
//        System.out.println("Клиент с таким номером заказа " + (clientWithFakeOrder.isPresent() ? "Существует" : "не найден"));
//        System.out.println("----------------------------------");
//
//        /** Тест, когда есть клиент без заказа, и ищем по несуществующему заказу*/
//        Client client4 = new Client("Сергеев", "Сергей", "444444444");
//        clientDB.save(client4);
//        Optional<Client> clientWithoutOrder = clientDB.getClientByOrderNumber(444);
//        System.out.println("Клиент с таким номером заказа " + (clientWithoutOrder.isPresent() ? "Существует" : "не найден"));
//        System.out.println("----------------------------------");
//
//        /** Поиск клиента по ID*/
//        Optional<Client> clientByID = clientDB.getClientById(client5.getId());
//        System.out.println("Данные клиента по ID " + client5.getId() +
//                (clientByID.isPresent() ? " Найдены: " + client5.getLastName() + " " + client5.getFirstName() + " т: " + client5.getPhone()
//                        : "Не найдены"));
//
//        /** Поиск клиента по несуществующему ID*/
//        UUID fakeId = UUID.fromString("00000000-0000-0000-0000-000000000000");
//        Optional<Client> clientByFakeID = clientDB.getClientById(fakeId);
//        System.out.println("Поиск по несуществующему ID " + fakeId +
//                (clientByFakeID.isPresent() ? "Найден!?" : " Не найден")
//        );
//    }
//}
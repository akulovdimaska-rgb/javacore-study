package postalbox.services;

import java.util.*;

/**
 * Постамат - автоматическая станция приёма/выдачи посылок.
 * В маркете формируются заказы, и хочется добавить возможность получения через постамат.
 * Запускаем MVP: небольшая аудитория пользователей, несколько постаматов в Москве.
 * При заказе пользователь сможет выбрать, что хочет получить заказ в постамате.
 * <p>
 * В рамках задачи нужно реализовать код для MVP решения:
 * - курьер привозит заказ и пробует положить его в ячейку, указывая номер заказа. Постамат сам выбирает ячейку и возвращает в ответ.
 * Она откроется вызывающим этот метод кодом.
 * - после того, как заказ положили в ячейку, пользователю отправляется СМС c кодом получения. Заказ будет ждать вечно
 * - в случае любых ошибок - курьер забирает заказ назад и попробует положить заказ в ячейку на следующий день (для MVP это ок)
 * - пользователь может получить заказ по коду выдачи из СМС. При вводе кода выдачи постамат должен вывести на экран текст
 * "ваш заказ ХХХ в ячейке YYY", ячейка откроется сама.
 * <p>
 * Ограничения:
 * - все ячейки одного размера, но их может быть разное количество, зависит от конкретного постамата
 * - один заказ - одна коробка, она влезает в ячейку
 * - ячейки каждого постамата пронумерованы
 * - каждый постамат сам хранит своё состояние
 * <p>
 * Для отправки сообщения пользователю надо использовать клиент UserNotificationApi.
 * Доработать логику по генерации кода СМС и проверке этого кода
 */

public class PostalBoxService {
    private final UserNotificationApi notificationApi;
    // [номер ячейки, номер заказа]
    private final Map<Integer, Integer> cellNumberAndOrderNumberMap;
    // код доступа из смс, номер ячейки
    private final Map<Integer, Integer> generationCodeAndCellNumberMap;
    private final Deque<Integer> postalQue;
    private final int capacity;

    public PostalBoxService(int capacity) {
        this.capacity = capacity;
        this.notificationApi = new UserNotificationApi();
        generationCodeAndCellNumberMap = new HashMap<>();
        cellNumberAndOrderNumberMap = new HashMap<>(capacity);
        postalQue = new ArrayDeque<>(capacity);

        for (int i = 1; i <= capacity; i++) {
            postalQue.add(i);
        }
    }

    public Integer add(int numberOfOrder) {
        if (postalQue.isEmpty()) {
            throw new IllegalArgumentException("Нет свободных ячеек");
        }
        int cellNumber = postalQue.poll();
        int generationCode = notificationApi.send(numberOfOrder);
        generationCodeAndCellNumberMap.put(generationCode, cellNumber);
        cellNumberAndOrderNumberMap.put(cellNumber, numberOfOrder);

        return generationCode;
    }

    public int get(int clientSmsCode) {

        Integer cellOpen = generationCodeAndCellNumberMap.remove(clientSmsCode);
        if (cellOpen == null) {
            throw new IllegalArgumentException("Указан некорректный код СМС, введите код повторно");
        }
        int numberOrderComplete = cellNumberAndOrderNumberMap.remove(cellOpen);
        postalQue.addLast(cellOpen);
        System.out.printf("Ваш заказ %s в ячейке %s, ячейка откроется сама.%n", numberOrderComplete, cellOpen);
        return cellOpen;

    }


// нужно реализовать методы хранения и выдачи заказа
}

class Generation {
    public int getGenerationCode() {
        Random random = new Random();
        return random.nextInt(100000, 1000000);
    }
}

/**
 * Синхронный клиент, вызывающий postalbox.notify.market.yandex.net
 * Реализацию интерфейса описывать не нужно.
 */
class UserNotificationApi {
    private Generation generation;

    public UserNotificationApi() {
        this.generation = new Generation();
    }

    public int send(int numberOfOrder) {
        int generationCode = generation.getGenerationCode();
        System.out.println("Ваш заказ: " + numberOfOrder + " готово к получению. Код получения: " + generationCode);
        return generationCode;
    }

    // нужно описать метод(ы) для отправки сообщения с кодом выдачи
    // в ответ придёт код выдачи, который был отправлен пользователю
}

class Box {
    String sender;
    Integer numberOfOrder;

    public Box(String sender, Integer numberOfOrder) {
        this.sender = sender;
        this.numberOfOrder = numberOfOrder;
    }

    public String getSender() {
        return sender;
    }

    public Integer getNumberOfOrder() {
        return numberOfOrder;
    }
}

//class TestPostalBox {
//    public static void main(String[] args) {
//        int capacity = 3;
//        int numberOfOrder1 = 558841;
//        int numberOfOrder2 = 558861;
//        int numberOfOrder3 = 55884111;
//        PostalBoxService postalBoxService = new PostalBoxService(capacity);
//        int generationCode1 = postalBoxService.add(numberOfOrder1);
//        int generationCode2 = postalBoxService.add(numberOfOrder2);
//        int generationCode3 = postalBoxService.add(numberOfOrder3);
//        System.out.println(generationCode1);
//        System.out.println(generationCode2);
//        System.out.println(generationCode3);
//        System.out.println(postalBoxService.get(generationCode1));
//        System.out.println(postalBoxService.get(generationCode3));
//
//    }
//}
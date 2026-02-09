package Home.FactoryMethod;

public class MainFactory {
    private static Logistics logistics;

    static void configuration(String string){
        if (string.equals("air")){
            logistics = new AirLogistics();
        } else if (string.equals("road")) {
            logistics = new RoadLogistics();
        } else if (string.equals("ship")) {
            logistics = new SeaLogistics();
        }
    }

    public static void main(String[] args) {
        configuration("road");
        System.out.println();
//        // Клиентский код работает напрямую с базовым классом Logistics
//        Logistics logistics;
//
//        // Выбор кокретной фабрики на основе конфигурации или условий
//        String deliveryType = "sea"; // Может приходить из конфигурации
//
//        switch (deliveryType) {
//            case "road" -> new RoadLogistics;
//            break;
//            case "air" -> new AirLogistics();
//            break;
//            case "sea" -> new SeaLogistics();
//            break;
//            default -> throw new IllegalArgumentException("Неизвестный тип доставки");
//        }
//
//        // Используем фабричный метод, не зная конкретного класса
//        logistics.planDelivery();
//
//        // Или напрямую создаём транспорт
//        Transport transport = logistics.createTransport();
//        transport.deliver();
    }
}

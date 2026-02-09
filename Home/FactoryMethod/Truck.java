package Home.FactoryMethod;

public class Truck implements Transport{

    @Override
    public void deliver() {
        System.out.println("Доставка груза по дороге");
    }
}

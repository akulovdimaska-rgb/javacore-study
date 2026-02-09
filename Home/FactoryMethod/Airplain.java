package Home.FactoryMethod;

public class Airplain implements Transport{
    @Override
    public void deliver() {
        System.out.println("Доставка груза по воздуху");
    }
}

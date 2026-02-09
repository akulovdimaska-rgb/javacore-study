package Home.FactoryMethod;

public class AirLogistics extends Logistics{
    @Override
    public Transport createTransport() {
        return new Airplain();
    }
}

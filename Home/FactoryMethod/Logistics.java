package Home.FactoryMethod;

public abstract class Logistics {
    public abstract Transport createTransport();

    public void planDelivery(){
        Transport transport = createTransport();
        System.out.println("Планируем доставку...");
    }
}

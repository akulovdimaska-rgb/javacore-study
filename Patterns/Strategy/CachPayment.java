package Patterns.Strategy;

public class CachPayment implements PaymantStrategy{
    @Override
    public void pay(int summa) {
        System.out.println("Оплата наличными");
    }
}

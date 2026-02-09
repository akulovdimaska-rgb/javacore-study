package Patterns.Strategy;

public class CardPayment implements PaymantStrategy{

    @Override
    public void pay(int summa) {
        System.out.println("Оплата картой");
    }
}

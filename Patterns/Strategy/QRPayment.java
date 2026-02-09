package Patterns.Strategy;

public class QRPayment implements PaymantStrategy{
    @Override
    public void pay(int summa) {
        System.out.println("Оплата QR");
    }
}

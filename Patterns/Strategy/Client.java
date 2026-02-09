package Patterns.Strategy;

public class Client {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.setPaymantStrategy(new CardPayment());
        payment.pay(10);

        QRPayment qrPayment = new QRPayment();
        payment.setPaymantStrategy(qrPayment);
        payment.pay(5);
    }
}

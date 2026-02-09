package Patterns.Strategy;

public class Payment {
    private PaymantStrategy paymantStrategy;

    public void setPaymantStrategy(PaymantStrategy paymantStrategy) {
        this.paymantStrategy = paymantStrategy;
    }

    public void pay(int summa) {
        if (paymantStrategy == null) {
            throw new NullPointerException("Платежная система не выбрана");
        }

        paymantStrategy.pay(summa);
        System.out.println("Оплата на сумму " + summa + " совершена");
    }
}

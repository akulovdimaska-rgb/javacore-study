package Multithreading;

public class Ex4 {


    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Privet");
                for (int i = 0; i <= 10; i++) {
                    System.out.println(i);
                }
            }
        }).start();
    }
}

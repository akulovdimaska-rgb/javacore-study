package Lambda;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.function.Consumer;

// Supplier<T> - поставщик, его метод T get(); возвращает объект, не принимает никаких параметров
// Consumer<T> - потребитель, он ничего не возвращает - void accept(T t) - принимает объект T, т.е. потребляет.
// под потреблением объектов понимаем, что мы хотим что-то сделать с объектом


public class Supp_Cons {
    public static ArrayList<Car> createThreeCars(java.util.function.Supplier<Car> carSupplier){
        ArrayList<Car> al = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            al.add(carSupplier.get());
        }
        return al;
    }

    public static void changeCar(Car car, Consumer<Car> carConsumer){
        carConsumer.accept(car);
    }

    public static void main(String[] args) {
        ArrayList<Car> ourCars = createThreeCars(() -> new Car("Nissan Tiida", "Silver Metallic", 1.6));
        System.out.println("Our cars: " + ourCars);

        changeCar(ourCars.get(0)
                , car -> {
                    car.color = "red";
                    car.engine = 2.4;
                    System.out.println("upgraded car: " + car);
                });
        System.out.println(ourCars);
    }
}

class Car {
    String model;
    String color;
    double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}

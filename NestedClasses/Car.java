package NestedClasses;

public class Car {
    String color;
    int doorCount;
    Engine engine;

    public Car(String color, int doorCount, int horsePower) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = this.new Engine(horsePower);
    }

    public class Engine {
        private int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }
    }
}
    class Test{
        public static void main(String[] args) {
            Car car = new Car("black", 4, 150);
//            Car.Engine engine = car.new Engine(150);
//            car.set Engine (engine);
//            System.out.println(engine);
//            System.out.println(Car);
        }
    }




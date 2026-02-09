package Home;

public class Parent {

    public static void print() {
        System.out.println("This is parent");
    }
}

class Child extends Parent {

    public static void print() {
        System.out.println("This is child");
    }
}

class Testics {
    static void main(String[] args) {
        Parent parent = new Parent();
        Child child1 = new Child(); // 1-й ребенок
        Parent child2 = new Child(); // 2-й ребенок

        parent.print(); //"This is parent"
        child1.print(); //"This is child"
        child2.print(); //"This is parent"
    }
}

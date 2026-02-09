package Home;

public final class MySingleton {
    private static MySingleton instance;
    private String s;

    private MySingleton(String st) {
        this.s = st;
    }

    public static MySingleton getInstance(String st) {
        if (instance == null) {
            instance = new MySingleton(st);
        }
        return instance;
    }

    public String getS() {
        return s;
    }
}

class TestMySingleton {
    static void main(String[] args) {
        MySingleton name1 = MySingleton.getInstance("Dmitriy");
        MySingleton name2 = MySingleton.getInstance("Akulov");

        System.out.println(name1 == name2);
        System.out.println(name1.getS());
        System.out.println(name2.getS());
    }
}

class DataBaseConnection{
    private static DataBaseConnection instances;
    private DataBaseConnection(){}

    public  static DataBaseConnection getInstance(){
        if (instances == null){
            instances = new DataBaseConnection();
        }
        return instances;
    }
}

final class DataBase{
    private static DataBase instance;
    private String str;

    private DataBase(){}

    public static DataBase getInstances(){
        if (instance == null){
            instance = new DataBase();
        }
        return instance;
    }
}
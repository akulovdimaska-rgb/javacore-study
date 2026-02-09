package Home;

public class TestikArtefacts {
    int number;
    String culture;
    int age;

    public TestikArtefacts(int number){
        this.number = number;
    }

    public TestikArtefacts(int number, String culture) {
        this.number = number;
        this.culture = culture;
    }

    public TestikArtefacts(int number, String culture, int age){
        this.number = number;
        this.culture = culture;
        this.age = age;
    }

    public TestikArtefacts(int age, int number){
        this.age = age;
        this.number = number;
    }

}

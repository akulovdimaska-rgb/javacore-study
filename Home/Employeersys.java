package Home;

public class Employeersys {
    int id;
    String surname;
    int age;
    double salary;
    String department;

    Employeersys(int id2, String surname2, int age2, double salary2, String department2) {
        id = id2;
        surname = surname2;
        age = age2;
        salary = salary2;
        department = department2;
    }

    double upSalary() {
        salary *= 2;
        return salary;

    }

}

class EmployeeTest {

    static void main(String[] args) {
        Employeersys emp1 = new Employeersys(1, "Ivanov", 25, 100.5, "IT");
        Employeersys emp2 = new Employeersys(2, "Petrov", 40, 200.5, "IT_PROG");

        emp1.upSalary();
        System.out.println("Novaya zarplata " + emp1.surname + " " + emp1.salary);

        double newSalary = emp2.upSalary();
        System.out.println("Novaya zarplata " + emp2.surname + " " + newSalary);
    }

}

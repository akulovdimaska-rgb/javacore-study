package Lambda;

import java.util.ArrayList;

public class Probnik {

}

class Employer {
    String fname;
    int stage;
    int razryad;
    double zryaplata;

    Employer(String fname, int stage, int razryad, double zryaplata) {
        this.fname = fname;
        this.stage = stage;
        this.razryad = razryad;
        this.zryaplata = zryaplata;
    }
}

class EmployerInfo {
    void printEmployer(Employer emp) {
        System.out.println("Imya: " + emp.fname + ", Stage: " + emp.stage + ", razryad: " + emp.razryad + ", Zryaplata: " + emp.zryaplata);
    }

    void printEmplStage(ArrayList<Employer> aLe, int stage) {
        for (Employer em : aLe) {
            if (em.stage > stage) {
                printEmployer(em);
            }
        }
    }
void testEmployer(ArrayList<Employer> list, EmployerChecks ec) {
    for (Employer em : list){
        if (ec.testEmployer(em)) {
            printEmployer(em);
        }
    }
}

    public static void main(String[] args) {
        ArrayList<Employer> list = new ArrayList<>();
        Employer emp1 = new Employer ("Ivan", 10, 4, 1500);
        Employer emp2 = new Employer ("Sam", 20, 6, 3000);
        Employer emp3 = new Employer ("Jon", 15, 5, 2500);
        Employer emp4 = new Employer ("Tom", 5, 3, 1000);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
    EmployerInfo ei = new EmployerInfo();
    ei.printEmplStage(list, 13);
    }

    interface EmployerChecks{
        boolean testEmployer(Employer em);
    }

    class FindEmployerStage implements EmployerChecks {

        public boolean testEmployer(Employer em){
            return em.stage > 13;
        }
    }
}



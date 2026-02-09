package Lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

//Здесь мы поговорим о:
// Predicate <T>        boolean test(T t); на примере метода removeIf
// и Function<T, R>     T applay (T t); T -входной параметр, R - это return type

public class StudentInfo {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Maria", 'f', 23, 3, 7.4);
        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfo info = new StudentInfo();
//        info.testStudents(students, new CheckOverGrade());
//        info.testStudents(students, new StudetChecks() {
//            @Override
//            public boolean check(Student s) {
//                return s.age < 30;
//            }
//        });

//        System.out.println("------------------------------");
//        info.testStudents(students, (Student p) -> {
//            return p.age < 30;
//        });
//        System.out.println("------------------------------");
//        info.testStudents(students, (Student p) -> {
//            System.out.println("hello");
//            return p.avgGrade > 8;
//        });

//        Predicate<Student> p1 = student -> student.avgGrade > 7.5;
//        Predicate<Student> p2 = student -> student.sex == 'm';
//
//        info.testStudents(students, p1.and(p2));
//        info.testStudents(students, p1.or(p2));
//        info.testStudents(students, p1.negate());

//        System.out.println("------------------------------");
//        info.testStudents(students, (Student p) -> {
//            return p.age > 20 && p.avgGrade < 9.3 && p.sex == 'f';
//        });
//        info.testStudents(students, p -> p.avgGrade > 8);
//        info.testStudents(students, (p) -> {
//            return p.avgGrade > 8;
//        });
//        info.testStudents(students, (p) -> {
//            System.out.println("hello");
//            return p.avgGrade > 8;
//        });
//        info.printStudentsOverGrade(students, 8);
//        info.printStudentsUnderAge(students, 30);
//        info.printStudentsMixCondition(students, 20, 9, 'f');

        Function<Student, Double> f = student -> student.avgGrade;
        double res = avgOfSmth(students, stud -> stud.avgGrade);
        System.out.println(res);
    }

        private static double avgOfSmth(List<Student> list, Function<Student, Double> f){
        double result = 0;
        for (Student st : list) {
            result += f.apply(st);
        }
        result = result / list.size();
        return result;
        }

    }

//    void testStudents(ArrayList<Student> al, Predicate<Student> pr){
//        for (Student s: al){
//            if (pr.test(s)){
//                System.out.println(s);
//            }
//        }
//    }


//    void printStudentsOverGrade(ArrayList<Student> al, double grade) {
//        for (Student s : al) {
//            if (s.avgGrade > grade) {
//                System.out.println(s);
//            }
//
//        }
//    }
//
//    void printStudentsUnderAge(ArrayList<Student> al, int age) {
//        for (Student s : al) {
//            if (s.age < age) {
//                System.out.println(s);
//            }
//        }
//    }
//
//    void printStudentsMixCondition(ArrayList<Student> al, int age, double grade, char sex) {
//        for (Student s : al) {
//            if (s.age > age && s.avgGrade < grade && s.sex == sex) {
//                System.out.println(s);
//            }
//        }
//    }


class Test{
}
//interface StudetChecks{
//    boolean check(Student s);
//}
//class CheckOverGrade implements StudetChecks{
//    @Override
//    public boolean check(Student s) {
//        return s.avgGrade>8;
//    }
//}


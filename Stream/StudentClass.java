package Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Написать класс:
 * Students(String name, String age, String avg);
 * Посчитать средний возраст n лучших студентов
 */
public class StudentClass {
    static void main(String[] args) {
        List<StudentForStream> students = new ArrayList<>();

        students.add(new StudentForStream("Nik", "26", "7"));
        students.add(new StudentForStream("Max", "18", "5"));
        students.add(new StudentForStream("Sam", "21", "6"));
        students.add(new StudentForStream("Ram", "43", "3"));

        int n = 2;
        System.out.println(getAvgAgeOfBest(students, n));
    }

    public static double getAvgAgeOfBest(List<StudentForStream> students, int n) {
        /**1. отсортировать по avg
         * 2. выбрать первых двух
         * 3. подсчитать средний возраст
         */

        return students.stream()
                .sorted(Comparator.reverseOrder())
                .limit(n)
                .mapToInt(student -> Integer.parseInt(student.getAge())) //Nik, Sam
                .average()
                .orElse(-1);
    }

}

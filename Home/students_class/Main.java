package Home.students_class;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**⭐️ Задача на коллекции: «Группировка и сортировка студентов по курсам»
 📌 Условие
 Дан список объектов:

 class Student {
 String name;
 int course;     // курс студента (1–4)
 double grade;   // средний балл (0.0–5.0)
 }

 Нужно выполнить следующие операции:
 🎯 Задания
 1. Сгруппировать студентов по курсам
 Используй:
 Map<Integer, List<Student>>
 где ключ — номер курса,
 значение — список студентов.

 2. Для каждого курса отсортировать студентов по средней оценке (grade), по убыванию
 Например:
 Курс 2:
 Иван — 4.8
 Мария — 4.3
 Саша — 3.9

 3. Найти курс, у которого суммарный средний балл выше всего
 То есть:
 sum(grade по курсу)/количество студентов на курсе
 Вернуть номер курса и средний балл.

 4. Найти лучших 3 студентов из всего списка (по grade)
 Используя любую коллекцию.
 5. Найти всех студентов, у которых grade ниже 3.0
 Вернуть в виде:

 List<Student>*/
public class Main {

    static void main(String[] args) {
        Student dima = new Student("Dima");
        dima.setCourse(1);
        dima.setGrade(2);

        Student lesha = new Student("Lesha");
        lesha.setCourse(2);
        lesha.setGrade(3);

        Student alex = new Student("Alex");
        alex.setCourse(3);
        alex.setGrade(4);

        Student anton = new Student("Anton");
        anton.setCourse(4);
        anton.setGrade(5);

        Student zhenya = new Student("Zhenya");
        zhenya.setCourse(3);
        zhenya.setGrade(3);

        List<Student> students = List.of(dima, lesha, alex, zhenya, anton);

        Main main = new Main();
        System.out.println(main.groupByCourse(students));
    }

    public Map<Integer, List<Student>> groupByCourse (List<Student> students){

        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getCourse(), Collectors.toList())
                );
    }
}

package Stream;

/**
 * Написать класс:
 * Students(String name, String age, String avg);
 * Посчитать средний возраст n лучших студентов
 */
public class StudentForStream implements Comparable<StudentForStream> {

    private final String name;
    private final String age;
    private final String avg;

    public StudentForStream(String name, String age, String avg) {
        this.name = name;
        this.age = age;
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAvg() {
        return avg;
    }

    @Override
    public int compareTo(StudentForStream o) {
        return Integer.parseInt(this.getAvg()) - Integer.parseInt(o.getAvg());
    }

}





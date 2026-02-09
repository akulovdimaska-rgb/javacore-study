package Home.students_class;

class Student {
    private final String name;
    private int course;
    private double grade;


    public Student(String name) {
        this.name = name;
    }

    public void setCourse(int course) {
        if (course < 1 || course > 4) {
            throw new IllegalArgumentException("Курс должен быть в диапазоне от 1 до 4");
        }
        this.course = course;
    }

    public void setGrade(double grade) {
        if (grade < 0.0 || grade > 5.0){
            throw new IllegalArgumentException("Средняя оценка должна быть в диапазоне от 0.0 до 5.0");
        }
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                ", grade=" + grade +
                '}';
    }
}





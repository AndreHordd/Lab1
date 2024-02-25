public class Student extends Person {
    private int course;
    private String group;

    public Student(String name, String surname, int course, String group) {
        super(name, surname, "Student"); // Виклик конструктора базового класу з типом "Student"
        this.course = course;
        this.group = group;
    }

    // Гетери
    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    // Сетери
    public void setCourse(int course) {
        this.course = course;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Студент{" +
                "ім'я='" + name + '\'' +
                ", прізвище='" + surname + '\'' +
                ", курс=" + course +
                ", група='" + group + '\'' +
                '}';
    }
}

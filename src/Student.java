/**
 * Class to represent a student
 */
public class Student extends Person {
    /**
     * Student's course
     */
    private int course;
    /**
     * Student's group
     */
    private int group;

    /**
     * Constructor for a student
     *
     * @param name       student's name
     * @param surname    student's surname
     * @param course     student's course
     * @param group      student's group
     * @param faculty    faculty the student belongs to
     * @param department department the student belongs to
     */
    public Student(String name, String surname, int course, int group, Faculty faculty, Department department) {
        super(name, surname, faculty, department, "Student"); // Виклик конструктора базового класу з типом "Student"
        this.course = course;
        this.group = group;
    }

    /**
     * Student's course getter
     */
    public int getCourse() {
        return course;
    }

    /**
     * Student's course setter
     */
    public void setCourse(int course) {
        this.course = course;
    }

    /**
     * Student's group getter
     */
    public int getGroup() {
        return group;
    }

    /**
     * Student's group setter
     */
    public void setGroup(int group) {
        this.group = group;
    }

    /**
     * toString method
     *
     * @return string representation of a student
     */
    @Override
    public String toString() {
        return "Студент: " + name + " " + surname + ", " + course + " курс, група " + group +
                ", факультет " + faculty.getName() + ", кафедра " + department.getName();
    }
}

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
     * @param name    student's name
     * @param surname student's surname
     * @param course  student's course
     * @param group   student's group
     */
    public Student(String name, String surname, int course, int group, Faculty faculty, Department department) {
        super(name, surname, faculty, department, "Student"); // Виклик конструктора базового класу з типом "Student"
        this.course = course;
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

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

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
    private String group;

    /**
     * Constructor for a student
     *
     * @param name    student's name
     * @param surname student's surname
     * @param course  student's course
     * @param group   student's group
     */
    public Student(String name, String surname, int course, String group) {
        super(name, surname, "Student"); // Виклик конструктора базового класу з типом "Student"
        this.course = course;
        this.group = group;
    }


    /**
     * Course getter
     *
     * @return course
     */
    public int getCourse() {
        return course;
    }

    /**
     * Group getter
     *
     * @return group
     */
    public String getGroup() {
        return group;
    }

    /**
     * Course setter
     *
     * @param course course
     */
    public void setCourse(int course) {
        this.course = course;
    }

    /**
     * Group setter
     *
     * @param group group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * toString method
     *
     * @return string representation of a student
     */
    @Override
    public String toString() {
        return "Студент: " + name + " " + surname + ", " + course + " курс, група " + group;
    }
}

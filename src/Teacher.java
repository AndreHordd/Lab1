/**
 * Class to represent a teacher
 */
public class Teacher extends Person {
    /**
     * Constructor for a teacher
     *
     * @param name       teacher's name
     * @param surname    teacher's surname
     * @param faculty    faculty the teacher belongs to
     * @param department department the teacher belongs to
     */
    public Teacher(String name, String surname, Faculty faculty, Department department) {
        super(name, surname, faculty, department, "Teacher");
    }

    /**
     * toString method
     *
     * @return string representation of a teacher
     */
    @Override
    public String toString() {
        return "Викладач " + name + " " + surname + ", факультет " + faculty.getName() + ", кафедра " + department.getName();
    }
}

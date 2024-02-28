/**
 * Class to represent a teacher
 */
public class Teacher extends Person {
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

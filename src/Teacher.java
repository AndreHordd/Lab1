/**
 * Class to represent a teacher
 */
public class Teacher extends Person {
    /**
     * Teacher's academic position
     */
    private String academicPosition;

    /**
     * Constructor for a teacher
     *
     * @param name                   teacher's name
     * @param surname                teacher's surname
     * @param academicPosition       teacher's academic position
     * @param initialSubjectCapacity initial capacity for subjects
     */
    public Teacher(String name, String surname, String academicPosition, int initialSubjectCapacity) {
        super(name, surname, "Teacher"); // Виклик конструктора базового класу з типом "Teacher"
        this.academicPosition = academicPosition;
    }

    /**
     * Academic position getter
     *
     * @return academic position
     */
    public String getAcademicPosition() {
        return academicPosition;
    }

    /**
     * Academic position setter
     *
     * @param academicPosition
     */
    public void setAcademicPosition(String academicPosition) {
        this.academicPosition = academicPosition;
    }

    /**
     * toString method
     *
     * @return string representation of a teacher
     */
    @Override
    public String toString() {
        return "Викладач " + name + " " + surname + ", " + academicPosition;
    }
}

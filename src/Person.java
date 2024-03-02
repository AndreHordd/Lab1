/**
 * Class to represent a person
 */
public abstract class Person {
    /**
     * Person's name
     */
    protected String name;
    /**
     * Person's surname
     */
    protected String surname;
    /**
     * Person's type (Student or Teacher)
     */
    protected String personType; // "Student" або "Teacher"
    /**
     * Faculty the person belongs to
     */
    protected Faculty faculty;
    /**
     * Department the person belongs to
     */
    protected Department department;

    /**
     * Constructor for a person
     *
     * @param name       person's name
     * @param surname    person's surname
     * @param faculty    faculty the person belongs to
     * @param department department the person belongs to
     * @param personType person's type (Student or Teacher)
     */
    public Person(String name, String surname, Faculty faculty, Department department, String personType) {
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.department = department;
        this.personType = personType;
    }

    /**
     * Person's name getter
     */
    public String getName() {
        return name;
    }

    /**
     * Person's name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Person's surname getter
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Person's surname setter
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Person type getter
     */
    public String getPersonType() {
        return personType;
    }

    /**
     * Person's type setter
     */
    public void setPersonType(String personType) {
        this.personType = personType;
    }

    /**
     * Person's faculty getter
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * Person's faculty setter
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * Person's department getter
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Person's department setter
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * toString method
     *
     * @return string representation of a person
     */
    @Override
    public String toString() {
        return name + " " + surname + ", " + personType + ", факультет " + faculty.getName() + ", кафедра " + department.getName();
    }
}

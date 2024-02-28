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
     * Person's type
     */
    protected String personType; // "Student" або "Teacher"

    protected Faculty faculty;
    protected Department department;

    public Person(String name, String surname, Faculty faculty, Department department, String personType) {
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.department = department;
        this.personType = personType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Department getDepartment() {
        return department;
    }

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

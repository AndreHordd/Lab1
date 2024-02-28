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

    /**
     * Constructor for a person
     *
     * @param name       name
     * @param surname    surname
     * @param personType person type: "Student" or "Teacher"
     */
    public Person(String name, String surname, String personType) {
        this.name = name;
        this.surname = surname;
        this.personType = personType;
    }

    /**
     * Name getter
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Surname getter
     *
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Person type getter
     *
     * @return person type
     */
    public String getPersonType() {
        return personType;
    }

    /**
     * toString method
     *
     * @return string representation of a person
     */
    @Override
    public String toString() {
        return name + " " + surname;
    }
}

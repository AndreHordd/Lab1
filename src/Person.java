public abstract class Person {
    protected String name;
    protected String surname;
    protected String personType; // "Student" або "Teacher"

    public Person(String name, String surname, String personType) {
        this.name = name;
        this.surname = surname;
        this.personType = personType;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonType() {
        return personType;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}

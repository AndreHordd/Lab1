
// Клас Викладача
class Teacher extends Person {
    private String academicPosition;

    public Teacher(String name, String surname, String academicPosition) {
        super(name, surname);
        this.academicPosition = academicPosition;
    }

    // Гетери та сетери
}
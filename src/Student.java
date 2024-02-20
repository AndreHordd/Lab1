class Student extends Person {
    private int course;
    private String group;

    public Student(String name, String surname, int course, String group) {
        super(name, surname);
        this.course = course;
        this.group = group;
    }

    // Гетери та сетери
}
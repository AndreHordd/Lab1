import java.util.Arrays;

// Клас Кафедри
class Department {
    private String name;
    private Person[] members;
    private int memberCount;

    public Department(String name, int initialCapacity) {
        this.name = name;
        this.members = new Person[initialCapacity];
        this.memberCount = 0;
    }

    public void addMember(Person person) {
        if (memberCount == members.length) {
            members = Arrays.copyOf(members, members.length * 2);
        }
        members[memberCount++] = person;
    }

    // Аналогічні методи для видалення та пошуку членів кафедри
}
import java.util.Arrays;

/**
 * Class to represent a department
 */
public class Department {
    /**
     * Department name getter
     */
    public String getName() {
        return name;
    }

    /**
     * Department name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Department members (students and teachers) getter
     */
    public Person[] getMembers() {
        return members;
    }

    /**
     * Department members (students and teachers) setter
     */
    public void setMembers(Person[] members) {
        this.members = members;
    }

    /**
     * Department member count getter
     */
    public int getMemberCount() {
        return memberCount;
    }

    /**
     * Department count of members setter
     */
    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    /**
     * Department name
     */
    private String name;
    /**
     * Array of department members
     */
    private Person[] members;
    /**
     * Number of department members
     */
    private int memberCount;

    /**
     * Constructor for a department
     *
     * @param name            department name
     * @param initialCapacity initial capacity for members
     */
    public Department(String name, int initialCapacity) {
        this.name = name;
        this.members = new Person[initialCapacity];
        this.memberCount = 0;
    }

    /**
     * Method to add a member to the department
     *
     * @param person member to add
     */
    public void addMember(Person person) {
        if (memberCount == members.length) {
            expandMembersArray();
        }
        members[memberCount++] = person;
    }

    /**
     * Method to expand the members array
     */
    private void expandMembersArray() {
        Person[] newMembers = new Person[members.length * 2];
        System.arraycopy(members, 0, newMembers, 0, members.length);
        members = newMembers;
    }

    /**
     * Method to remove a member from the department
     *
     * @param name    member's name
     * @param surname member's surname
     * @return true if the member was removed, false otherwise
     */
    public boolean removeMember(String name, String surname) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getName().equals(name) && members[i].getSurname().equals(surname)) {
                System.arraycopy(members, i + 1, members, i, memberCount - i - 1);
                members[--memberCount] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Method to find a member by name and surname
     *
     * @param name    member's name
     * @param surname member's surname
     * @return the member if found, null otherwise
     */
    public Person findMemberByName(String name, String surname) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getName().equals(name) && members[i].getSurname().equals(surname)) {
                return members[i];
            }
        }
        return null;
    }

    /**
     * Method to print all students in the department
     */
    public void printAllStudents() {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getPersonType().equals("Student")) {
                System.out.println(members[i]);
            }
        }
    }

    /**
     * Method to print all teachers in the department
     */
    public void printAllTeachers() {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getPersonType().equals("Teacher")) {
                System.out.println(members[i]);
            }
        }
    }

    /**
     * Method to print all students in the department by course
     *
     * @param course course
     */
    public void printStudentsByCourse(int course) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getPersonType().equals("Student")) {
                Student student = (Student) members[i];
                if (student.getCourse() == course) {
                    System.out.println(student);
                }
            }
        }
    }

    /**
     * Method to print all members of the department in alphabetical order
     */
    public void printMembersAlphabetically() {
        Person[] sortedMembers = Arrays.copyOf(members, memberCount);
        sortMembersAlphabetically(sortedMembers);

        System.out.println("Члени кафедри " + name + " в алфавітному порядку:");
        for (Person member : sortedMembers) {
            if (member != null) { // Уникнення виведення null-елементів
                System.out.println(member);
            }
        }
    }

    /**
     * Method to sort members alphabetically
     *
     * @param members members to sort
     */
    private void sortMembersAlphabetically(Person[] members) {
        for (int i = 0; i < members.length - 1; i++) {
            for (int j = 0; j < members.length - i - 1; j++) {
                if (members[j] != null && members[j + 1] != null) {
                    String fullName1 = members[j].getName() + " " + members[j].getSurname();
                    String fullName2 = members[j + 1].getName() + " " + members[j + 1].getSurname();
                    if (fullName1.compareTo(fullName2) > 0) {
                        // Swap
                        Person temp = members[j];
                        members[j] = members[j + 1];
                        members[j + 1] = temp;
                    }
                }
            }
        }
    }
}

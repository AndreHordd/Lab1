import java.util.Arrays;

public class Department {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person[] getMembers() {
        return members;
    }

    public void setMembers(Person[] members) {
        this.members = members;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

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
            expandMembersArray();
        }
        members[memberCount++] = person;
    }

    private void expandMembersArray() {
        Person[] newMembers = new Person[members.length * 2];
        System.arraycopy(members, 0, newMembers, 0, members.length);
        members = newMembers;
    }

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

    public Person findMemberByName(String name, String surname) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getName().equals(name) && members[i].getSurname().equals(surname)) {
                return members[i];
            }
        }
        return null;
    }

    public void printAllStudents() {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getPersonType().equals("Student")) {
                System.out.println(members[i]);
            }
        }
    }

    public void printAllTeachers() {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getPersonType().equals("Teacher")) {
                System.out.println(members[i]);
            }
        }
    }

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

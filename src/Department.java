import java.util.Arrays;

/**
 * Class to represent a department
 */
public class Department {
    /**
     * Department's name
     */
    private String name;
    /**
     * Array of department's members (students and teachers)
     */
    private Person[] members;
    /**
     * Number of members the department can hold
     */
    private int membersCount;
    /**
     * Number of members added to the department
     */
    private int addedMembersCount;

    /**
     * Constructor for a department
     *
     * @param name         department's name
     * @param membersCount number of members the department can hold
     */
    Department(String name, int membersCount) {
        this.name = name;
        this.membersCount = membersCount;
        this.addedMembersCount = 0;
        this.members = new Person[membersCount];
    }

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
     * Department members getter
     */
    public Person[] getMembers() {
        return members;
    }

    /**
     * Department members setter
     */
    public void setMembers(Person[] members) {
        this.members = members;
    }

    /**
     * Department members count getter
     */
    public int getMembersCount() {
        return membersCount;
    }

    /**
     * Department members count setter
     */
    public void setMembersCount(int membersCount) {
        this.membersCount = membersCount;
    }

    /**
     * Department added members count getter
     */
    public int getAddedMembersCount() {
        return addedMembersCount;
    }

    /**
     * Department added members count setter
     */
    public void setAddedMembersCount(int addedMembersCount) {
        this.addedMembersCount = addedMembersCount;
    }

    /**
     * Get the number of students in the department
     */
    public int getStudentsCount() {
        int studentsCount = 0;
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getPersonType().equals("Student")) {
                studentsCount++;
            }
        }
        return studentsCount;
    }

    /**
     * Get the number of teachers in the department
     */
    public int getTeachersCount() {
        int teachersCount = 0;
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getPersonType().equals("Teacher")) {
                teachersCount++;
            }
        }
        return teachersCount;
    }

    /**
     * Add a member to the department
     *
     * @param person person to add
     */
    public void addMember(Person person) {
        if (addedMembersCount == members.length) {
            expandMembersArray();
        }
        members[addedMembersCount++] = person;
    }

    /**
     * Expand the members array
     */
    private void expandMembersArray() {
        Person[] newMembers = new Person[members.length * 2];
        System.arraycopy(members, 0, newMembers, 0, members.length);
        members = newMembers;
    }

    /**
     * Remove a member from the department
     *
     * @param name       member's name
     * @param surname    member's surname
     * @param personType member's type (Student or Teacher)
     * @return true if the member was removed, false otherwise
     */
    public boolean removeMember(String name, String surname, String personType) {
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getName().equals(name) && members[i].getSurname().equals(surname) && members[i].getPersonType().equals(personType) && members[i] != null) {
                System.arraycopy(members, i + 1, members, i, addedMembersCount - i - 1);
                addedMembersCount--;
                return true;
            }
        }
        return false;
    }

    /**
     * Change a member in the department
     *
     * @param oldPerson old member
     * @param newPerson new member
     * @return true if the member was changed, false otherwise
     */
    public boolean changeMember(Person oldPerson, Person newPerson) {
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getName().equals(oldPerson.getName()) && members[i].getSurname().equals(oldPerson.getSurname())) {
                members[i] = newPerson;
                return true;
            }
        }
        return false;
    }

    /**
     * Print all students of the department
     */
    public void printAllStudentsAlphabetically() {
        if (getStudentsCount() == 0) {
            System.out.println("Студентів немає");
        } else {
            Person[] students = new Person[addedMembersCount];
            int studentsCount = 0;
            for (int i = 0; i < addedMembersCount; i++) {
                if (members[i].getPersonType().equals("Student") && members[i] != null) {
                    students[studentsCount++] = members[i];
                }
            }
            sortArrayAlphabetically(students);
            for (int i = 0; i < studentsCount; i++) {
                if (students[i] != null) {
                    System.out.println(students[i]);
                }
            }
        }
    }

    /**
     * Print all teachers of the department
     */
    public void printAllTeachersAlphabetically() {
        if (getTeachersCount() == 0) {
            System.out.println("Студентів немає");
        } else {
            Person[] teachers = new Person[addedMembersCount];
            int teachersCount = 0;
            for (int i = 0; i < addedMembersCount; i++) {
                if (members[i].getPersonType().equals("Teacher") && members[i] != null) {
                    teachers[teachersCount++] = members[i];
                }
            }
            sortArrayAlphabetically(teachers);
            for (int i = 0; i < teachersCount; i++) {
                if (teachers[i] != null) {
                    System.out.println(teachers[i]);
                }
            }
        }
    }

    /**
     * Print all students of the department of a certain course
     */
    public void printAllStudentsOfCourse(int course) {
        if (getStudentsCount() == 0) {
            System.out.println("Студентів немає");
        } else {
            for (int i = 0; i < addedMembersCount; i++) {
                if (members[i].getPersonType().equals("Student") && ((Student) members[i]).getCourse() == course && members[i] != null) {
                    System.out.println(members[i]);
                }
            }
        }
    }

    /**
     * Print all students of the department in increasing order of course
     */
    public void printAllStudentsByCourse() {
        if (getStudentsCount() == 0) {
            System.out.println("Студентів немає");
        } else {
            Person[] students = new Person[addedMembersCount];
            int studentsCount = 0;
            for (int i = 0; i < addedMembersCount; i++) {
                if (members[i].getPersonType().equals("Student") && members[i] != null) {
                    students[studentsCount++] = members[i];
                }
            }
            sortArrayByCourse(students);
            for (int i = 0; i < studentsCount; i++) {
                if (students[i] != null) {
                    System.out.println(students[i]);
                }
            }
        }
    }

    /**
     * Print all students of the department of a certain course in alphabetical order
     */
    public void printAllStudentsOfCourseAlphabetically(int course) {
        if (getStudentsCount() == 0) {
            System.out.println("Студентів немає");
        } else {
            Person[] students = new Person[addedMembersCount];
            int studentsCount = 0;
            for (int i = 0; i < addedMembersCount; i++) {
                if (members[i].getPersonType().equals("Student") && ((Student) members[i]).getCourse() == course && members[i] != null) {
                    students[studentsCount++] = members[i];
                }
            }
            sortArrayAlphabetically(students);
            for (int i = 0; i < studentsCount; i++) {
                if (students[i] != null)
                    System.out.println(students[i]);
            }
        }
    }

    /**
     * Find a member by name and surname
     *
     * @param name
     * @param surname
     * @param personType
     */
    public void findMemberByName(String name, String surname, String personType) {
        int count = 0;
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getName().equals(name) && members[i].getSurname().equals(surname) && members[i].getPersonType().equals(personType)) {
                if (members[i] != null) {
                    System.out.println(members[i]);
                    count++;
                }
            }
        }
        if (count == 0) {
            if (personType.equals("Student")) {
                System.out.println("Немає такого студента");
            } else {
                System.out.println("Немає такого викладача");
            }
        }
    }

    /**
     * Find a student of certain course
     *
     * @param course
     */
    public void findStudentByCourse(int course) {
        int count = 0;
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getPersonType().equals("Student") && ((Student) members[i]).getCourse() == course) {
                if (members[i] != null) {
                    System.out.println(members[i]);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Немає такого студента");
        }
    }

    /**
     * Find a student of certain group
     *
     * @param group
     */
    public void findStudentByGroup(int group) {
        int count = 0;
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getPersonType().equals("Student") && ((Student) members[i]).getGroup() == group) {
                if (members[i] != null) {
                    System.out.println(members[i]);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Немає такого студента");
        }
    }

    /**
     * Sort an array of persons alphabetically
     *
     * @param array array to sort
     */
    private void sortArrayAlphabetically(Person[] array) {
        for (int i = 0; i < addedMembersCount - 1; i++) {
            for (int j = 0; j < addedMembersCount - i - 1; j++) {
                if (array[j] != null && array[j + 1] != null) {
                    if (compareTo(array[j].getName(), array[j + 1].getName()) > 0) {
                        Person temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

    /**
     * Compare two strings alphabetically
     *
     * @param name1 first name
     * @param name2 second name
     * @return 0 if the names are equal, a positive number if the first name is greater, a negative number if the second name is greater
     */
    public static int compareTo(String name1, String name2) {
        String[] ukrainianAlphabet = {"А", "Б", "В", "Г", "Ґ", "Д", "Е", "Є", "Ж", "З", "И", "І", "Ї", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ю", "Я"};
        String thisName = name1.toUpperCase().replace("'", "");
        String otherName = name2.toUpperCase().replace("'", "");

        if (thisName.matches("[A-Z ]+") && otherName.matches("[A-Z ]+")) {
            return thisName.compareTo(otherName);
        }

        for (int i = 0; i < Math.min(thisName.length(), otherName.length()); i++) {
            int thisIndex = Arrays.asList(ukrainianAlphabet).indexOf(String.valueOf(thisName.charAt(i)));
            int otherIndex = Arrays.asList(ukrainianAlphabet).indexOf(String.valueOf(otherName.charAt(i)));
            if (thisIndex != otherIndex) {
                return thisIndex - otherIndex;
            }
        }
        return thisName.length() - otherName.length();
    }


    /**
     * Sort an array of students by course
     *
     * @param array array to sort
     */
    private void sortArrayByCourse(Person[] array) {
        for (int i = 0; i < addedMembersCount - 1; i++) {
            for (int j = 0; j < addedMembersCount - i - 1; j++) {
                if (array[j] != null && array[j + 1] != null) {
                    if (((Student) array[j]).getCourse() > ((Student) array[j + 1]).getCourse()) {
                        Person temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

    /**
     * Get a member by name, surname and type
     *
     * @param studentName
     * @param studentSurname
     * @param type
     * @return member
     */
    public Person getMember(String studentName, String studentSurname, String type) {
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getName().equals(studentName) && members[i].getSurname().equals(studentSurname) && members[i].getPersonType().equals(type)) {
                return members[i];
            }
        }
        return null;
    }
}
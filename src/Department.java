public class Department {
    private String name;
    private Person[] members;
    private int membersCount;
    private int addedMembersCount;

    Department(String name, int membersCount) {
        this.name = name;
        this.membersCount = membersCount;
        this.addedMembersCount = 0;
        this.members = new Person[membersCount];
    }

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

    public int getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(int membersCount) {
        this.membersCount = membersCount;
    }

    public int getAddedMembersCount() {
        return addedMembersCount;
    }

    public void setAddedMembersCount(int addedMembersCount) {
        this.addedMembersCount = addedMembersCount;
    }

    public int getStudentsCount() {
        int studentsCount = 0;
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getPersonType().equals("Student")) {
                studentsCount++;
            }
        }
        return studentsCount;
    }

    public int getTeachersCount() {
        int teachersCount = 0;
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getPersonType().equals("Teacher")) {
                teachersCount++;
            }
        }
        return teachersCount;
    }

    public void addMember(Person person) {
        if (addedMembersCount == members.length) {
            expandMembersArray();
        }
        members[addedMembersCount++] = person;
    }

    private void expandMembersArray() {
        Person[] newMembers = new Person[members.length * 2];
        System.arraycopy(members, 0, newMembers, 0, members.length);
        members = newMembers;
    }

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

    public boolean changeMember(Person oldPerson, Person newPerson) {
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getName().equals(oldPerson.getName()) && members[i].getSurname().equals(oldPerson.getSurname())) {
                members[i] = newPerson;
                return true;
            }
        }
        return false;
    }

    public void printAllStudentsAlphabetically() {
        if (getStudentsCount() == 0) {
            System.out.println("No students");
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

    public void printAllTeachersAlphabetically() {
        if (getTeachersCount() == 0) {
            System.out.println("No teachers");
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

    public void printAllStudentsOfCourse(int course) {
        if (getStudentsCount() == 0) {
            System.out.println("No students");
        } else {
            for (int i = 0; i < addedMembersCount; i++) {
                if (members[i].getPersonType().equals("Student") && ((Student) members[i]).getCourse() == course && members[i] != null) {
                    System.out.println(members[i]);
                }
            }
        }
    }

    public void printAllStudentsByCourse() {
        if (getStudentsCount() == 0) {
            System.out.println("No students");
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

    public void printAllStudentsOfCourseAlphabetically(int course) {
        if (getStudentsCount() == 0) {
            System.out.println("No students");
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

    //Знайти студента/викладача за ПІБ
    public void findMemberByName(String name, String surname, String personType) {
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getName().equals(name) && members[i].getSurname().equals(surname) && members[i].getPersonType().equals(personType)) {
                if (members[i] != null) {
                    System.out.println(members[i]);
                } else {
                    System.out.println("No such member");
                }
            }
        }
    }

    //Знайти студента за курсом
    public void findStudentByCourse(int course) {
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getPersonType().equals("Student") && ((Student) members[i]).getCourse() == course) {
                if (members[i] != null) {
                    System.out.println(members[i]);
                } else {
                    System.out.println("No such member");
                }
            }
        }
    }

    //Знайти студента/викладача за групою.
    public void findStudentByGroup(int group) {
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getPersonType().equals("Student") && ((Student) members[i]).getGroup() == group) {
                if (members[i] != null) {
                    System.out.println(members[i]);
                } else {
                    System.out.println("No such member");
                }
            }
        }
    }

    private void sortArrayAlphabetically(Person[] array) {
        for (int i = 0; i < addedMembersCount - 1; i++) {
            for (int j = 0; j < addedMembersCount - i - 1; j++) {
                if (array[j] != null && array[j + 1] != null) {
                    if (array[j].getName().compareTo(array[j + 1].getName()) > 0) {
                        Person temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

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


    public Person getMember(String studentName, String studentSurname, String type) {
        for (int i = 0; i < addedMembersCount; i++) {
            if (members[i].getName().equals(studentName) && members[i].getSurname().equals(studentSurname) && members[i].getPersonType().equals(type)) {
                return members[i];
            }
        }
        return null;
    }
}
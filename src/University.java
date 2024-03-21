import java.util.Arrays;

/**
 * University class represents a university with its faculties.
 */
public class University {
    /**
     * University's name
     */
    private String name;
    /**
     * Array of faculties
     */
    private Faculty[] faculties;
    /**
     * Number of faculties
     */
    private int numberOfFaculties;
    /**
     * Number of added faculties
     */
    private int addedFacultiesCount;

    /**
     * Constructor for a university
     *
     * @param name              university's name
     * @param numberOfFaculties number of faculties
     */
    University(String name, int numberOfFaculties) {
        this.name = name;
        this.numberOfFaculties = numberOfFaculties;
        this.addedFacultiesCount = 0;
        this.faculties = new Faculty[numberOfFaculties];
    }

    /**
     * University name getter
     */
    public String getName() {
        return name;
    }

    /**
     * University name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Faculties array getter
     */
    public Faculty[] getFaculties() {
        return faculties;
    }

    /**
     * Faculties array setter
     */
    public void setFaculties(Faculty[] faculties) {
        this.faculties = faculties;
    }

    /**
     * Number of faculties getter
     */
    public int getNumberOfFaculties() {
        return numberOfFaculties;
    }

    /**
     * Number of faculties setter
     */
    public void setNumberOfFaculties(int numberOfFaculties) {
        this.numberOfFaculties = numberOfFaculties;
    }

    /**
     * Number of added faculties getter
     */
    public int getAddedFacultiesCount() {
        return addedFacultiesCount;
    }

    /**
     * Number of added faculties setter
     */
    public void setAddedFacultiesCount(int addedFacultiesCount) {
        this.addedFacultiesCount = addedFacultiesCount;
    }

    /**
     * Add a faculty to the university
     *
     * @param faculty faculty to add
     */
    public void addFaculty(Faculty faculty) {
        if (addedFacultiesCount == faculties.length) {
            expandFacultiesArray();
        }
        faculties[addedFacultiesCount++] = faculty;
    }

    /**
     * Method to expand faculties array
     */
    private void expandFacultiesArray() {
        Faculty[] newFaculties = new Faculty[faculties.length * 2];
        System.arraycopy(faculties, 0, newFaculties, 0, faculties.length);
        faculties = newFaculties;
    }

    /**
     * Remove a faculty from the university
     *
     * @param facultyName faculty name to remove
     * @return true if faculty was removed, false otherwise
     */
    public boolean removeFaculty(String facultyName) {
        for (int i = 0; i < addedFacultiesCount; i++) {
            if (faculties[i].getName().equals(facultyName)) {
                System.arraycopy(faculties, i + 1, faculties, i, addedFacultiesCount - i - 1);
                addedFacultiesCount--;
                return true;
            }
        }
        return false;
    }

    /**
     * Get a faculty by its name
     *
     * @param facultyName faculty name
     * @return faculty with the given name or null if not found
     */
    public Faculty getFaculty(String facultyName) {
        for (int i = 0; i < addedFacultiesCount; i++) {
            if (faculties[i].getName().equals(facultyName)) {
                return faculties[i];
            }
        }
        return null;
    }

    /**
     * Method to print all students
     */
    public void printAllStudentsAlphabetically(String facultyName) {
        Student[] allStudentsOfFaculty = new Student[getFaculty(facultyName).getNumberOfMembers("Student")];
        int index = 0;
        for (int i = 0; i < addedFacultiesCount; i++) {
            if (faculties[i].getName().equals(facultyName)) {
                for (int j = 0; j < faculties[i].getAddedDepartmentsCount(); j++) {
                    for (int k = 0; k < faculties[i].getDepartments()[j].getAddedStudentsCount(); k++) {
                        allStudentsOfFaculty[index++] = faculties[i].getDepartments()[j].getStudents()[k];
                    }
                }
            }
        }
        for (int i = 0; i < allStudentsOfFaculty.length - 1; i++) {
            for (int j = 0; j < allStudentsOfFaculty.length - i - 1; j++) {
                if (compareTo(allStudentsOfFaculty[j].getName(), allStudentsOfFaculty[j + 1].getName()) > 0) {
                    Student temp = allStudentsOfFaculty[j];
                    allStudentsOfFaculty[j] = allStudentsOfFaculty[j + 1];
                    allStudentsOfFaculty[j + 1] = temp;
                }
            }
        }
        for (Student student : allStudentsOfFaculty) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    /**
     * Method to print all teachers alphabetically
     *
     * @param facultyName faculty name
     */
    public void printAllTeachersAlphabetically(String facultyName) {
        Teacher[] allTeachersOfFaculty = new Teacher[getFaculty(facultyName).getNumberOfMembers("Teacher")];
        int index = 0;
        for (int i = 0; i < addedFacultiesCount; i++) {
            if (faculties[i].getName().equals(facultyName)) {
                for (int j = 0; j < faculties[i].getAddedDepartmentsCount(); j++) {
                    for (int k = 0; k < faculties[i].getDepartments()[j].getAddedTeachersCount(); k++) {
                        allTeachersOfFaculty[index++] = faculties[i].getDepartments()[j].getTeachers()[k];
                    }
                }
            }
        }
        for (int i = 0; i < allTeachersOfFaculty.length - 1; i++) {
            for (int j = 0; j < allTeachersOfFaculty.length - i - 1; j++) {
                if (compareTo(allTeachersOfFaculty[j].getName(), allTeachersOfFaculty[j + 1].getName()) > 0) {
                    Teacher temp = allTeachersOfFaculty[j];
                    allTeachersOfFaculty[j] = allTeachersOfFaculty[j + 1];
                    allTeachersOfFaculty[j + 1] = temp;
                }
            }
        }
        for (Teacher teacher : allTeachersOfFaculty) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
        for (int i = 0; i < allTeachersOfFaculty.length - 1; i++) {
            for (int j = 0; j < allTeachersOfFaculty.length - i - 1; j++) {
                if (compareTo(allTeachersOfFaculty[j].getName(), allTeachersOfFaculty[j + 1].getName()) > 0) {
                    Teacher temp = allTeachersOfFaculty[j];
                    allTeachersOfFaculty[j] = allTeachersOfFaculty[j + 1];
                    allTeachersOfFaculty[j + 1] = temp;
                }
            }
        }
        for (Teacher teacher : allTeachersOfFaculty) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
    }

    /**
     * Method to print all students by course increasing order
     */
    public void printAllStudentsByCourse() {
        Student[] allStudents = new Student[getNumberOfMembers("Student")];
        int index = 0;
        for (int i = 0; i < addedFacultiesCount; i++) {
            for (int j = 0; j < faculties[i].getAddedDepartmentsCount(); j++) {
                for (int k = 0; k < faculties[i].getDepartments()[j].getAddedStudentsCount(); k++) {
                    allStudents[index++] = faculties[i].getDepartments()[j].getStudents()[k];
                }
            }
        }
        for (int i = 0; i < allStudents.length - 1; i++) {
            for (int j = 0; j < allStudents.length - i - 1; j++) {
                if (allStudents[j].getCourse() > allStudents[j + 1].getCourse()) {
                    Student temp = allStudents[j];
                    allStudents[j] = allStudents[j + 1];
                    allStudents[j + 1] = temp;
                }
            }
        }
        for (Student student : allStudents) {
            System.out.println(student);
        }
    }

    /**
     * Method to find a person (student or teacher) by name and surname
     *
     * @param name       person's name
     * @param surname    person's surname
     * @param personType person's type (Student or Teacher)
     */
    public void findMemberByName(String name, String surname, String personType) {
        for (int i = 0; i < addedFacultiesCount; i++) {
            faculties[i].findMemberByName(name, surname, personType);
        }
    }

    /**
     * Method to find a student of certain course
     *
     * @param course course number
     */
    public void findStudentByCourse(int course) {
        for (int i = 0; i < addedFacultiesCount; i++) {
            faculties[i].findStudentByCourse(course);
        }
    }

    /**
     * Method to find a student of certain group
     *
     * @param group group number
     */
    public void findStudentByGroup(int group) {
        for (int i = 0; i < addedFacultiesCount; i++) {
            faculties[i].findStudentByGroup(group);
        }
    }

    /**
     * Method to print all faculties
     */
    public void printAllFaculties() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < addedFacultiesCount; i++) {
            if (faculties[i] != null) {
                res.append(faculties[i].getName()).append(" ");
            }
        }
        System.out.println(res);
    }

    /**
     * Method to get number of added member to the university
     */
    public int getNumberOfMembers(String type) {
        int count = 0;
        for (int i = 0; i < addedFacultiesCount; i++) {
            count += faculties[i].getNumberOfMembers(type);
        }
        return count;
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
}

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
        for (int i = 0; i < addedFacultiesCount; i++) {
            if (faculties[i].getName().equals(facultyName)) {
                faculties[i].printAllStudentsAlphabetically();
            }
        }
    }

    /**
     * Method to print all teachers alphabetically
     *
     * @param facultyName faculty name
     */
    public void printAllTeachersAlphabetically(String facultyName) {
        for (int i = 0; i < addedFacultiesCount; i++) {
            if (faculties[i].getName().equals(facultyName)) {
                faculties[i].printAllTeachersAlphabetically();
            }
        }
    }

    /**
     * Method to print all students by course increasing order
     */
    public void printAllStudentsByCourse() {
        for (int i = 0; i < addedFacultiesCount; i++) {
            faculties[i].printAllStudentsByCourse();
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
     * @param course course number
     */
    public void findStudentByCourse(int course) {
        for (int i = 0; i < addedFacultiesCount; i++) {
            faculties[i].findStudentByCourse(course);
        }
    }

    /**
     * Method to find a student of certain group
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


}

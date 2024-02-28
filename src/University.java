/**
 * Class to represent a university
 */
public class University {
    /**
     * University name
     */
    private String name;
    /**
     * Array of faculties
     */
    private Faculty[] faculties;
    /**
     * Number of faculties
     */
    private int facultyCount;

    /**
     * Name getter
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Name setter
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Faculties getter
     *
     * @return faculties array
     */
    public Faculty[] getFaculties() {
        return faculties;
    }

    /**
     * Faculties setter
     *
     * @param faculties faculties array
     */
    public void setFaculties(Faculty[] faculties) {
        this.faculties = faculties;
    }

    /**
     * Faculty count getter
     *
     * @return number of faculties
     */
    public int getFacultyCount() {
        return facultyCount;
    }

    /**
     * Faculty count setter
     *
     * @param facultyCount number of faculties
     */
    public void setFacultyCount(int facultyCount) {
        this.facultyCount = facultyCount;
    }

    /**
     * University constructor
     *
     * @param name            university name
     * @param initialCapacity initial capacity of the faculties array
     */
    public University(String name, int initialCapacity) {
        this.name = name;
        this.faculties = new Faculty[initialCapacity];
        this.facultyCount = 0;
    }

    /**
     * Method to add a faculty to the university
     *
     * @param faculty faculty to add
     */
    public void addFaculty(Faculty faculty) {
        if (facultyCount == faculties.length) {
            expandFacultiesArray();
        }
        faculties[facultyCount++] = faculty;
    }

    /**
     * Method to expand the faculties array
     */
    private void expandFacultiesArray() {
        Faculty[] newFaculties = new Faculty[faculties.length * 2];
        System.arraycopy(faculties, 0, newFaculties, 0, faculties.length);
        faculties = newFaculties;
    }

    /**
     * Method to remove a faculty from the university
     *
     * @param facultyName faculty name
     * @return true if the faculty was removed, false otherwise
     */
    public boolean removeFaculty(String facultyName) {
        for (int i = 0; i < facultyCount; i++) {
            if (faculties[i].getName().equals(facultyName)) {
                System.arraycopy(faculties, i + 1, faculties, i, facultyCount - i - 1);
                faculties[--facultyCount] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Method to get a faculty by name
     *
     * @param facultyName faculty name
     * @return faculty
     */
    public Faculty getFaculty(String facultyName) {
        for (int i = 0; i < facultyCount; i++) {
            if (faculties[i].getName().equals(facultyName)) {
                return faculties[i];
            }
        }
        return null;
    }

    /**
     * Method to print all students in the university
     */
    public void printAllStudents() {
        System.out.println("Всі студенти університету " + name + ":");
        for (int i = 0; i < facultyCount; i++) {
            faculties[i].printAllStudents();
        }
    }

    /**
     * Method to print all teachers in the university
     */
    public void printAllTeachers() {
        System.out.println("Всі викладачі університету " + name + ":");
        for (int i = 0; i < facultyCount; i++) {
            faculties[i].printAllTeachers();
        }
    }

    /**
     * Method to print students by course
     */
    public void printStudentsByCourse() {
        System.out.println("Студенти університету " + name + " за курсами:");
        for (int i = 0; i < facultyCount; i++) {
            System.out.println("Факультет: " + faculties[i].getName());
            faculties[i].printStudentsByCourse();
        }
    }

    /**
     * Method to print members alphabetically
     */
    public void printMembersAlphabetically() {
        System.out.println("Члени університету " + name + " в алфавітному порядку:");
        for (int i = 0; i < facultyCount; i++) {
            System.out.println("Факультет: " + faculties[i].getName());
            faculties[i].printMembersAlphabetically();
        }
    }
}

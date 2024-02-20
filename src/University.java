import java.util.Arrays;

class University {
    private String name;
    private Faculty[] faculties;
    private int facultyCount;

    public University(String name, int initialCapacity) {
        this.name = name;
        this.faculties = new Faculty[initialCapacity];
        this.facultyCount = 0;
    }

    public void addFaculty(Faculty faculty) {
        if (facultyCount == faculties.length) {
            faculties = Arrays.copyOf(faculties, faculties.length * 2);
        }
        faculties[facultyCount++] = faculty;
    }

    // Аналогічні методи для видалення та пошуку факультетів
}
public class University {
    private String name;
    private Faculty[] faculties;
    private int facultyCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty[] getFaculties() {
        return faculties;
    }

    public void setFaculties(Faculty[] faculties) {
        this.faculties = faculties;
    }

    public int getFacultyCount() {
        return facultyCount;
    }

    public void setFacultyCount(int facultyCount) {
        this.facultyCount = facultyCount;
    }

    public University(String name, int initialCapacity) {
        this.name = name;
        this.faculties = new Faculty[initialCapacity];
        this.facultyCount = 0;
    }

    public void addFaculty(Faculty faculty) {
        if (facultyCount == faculties.length) {
            expandFacultiesArray();
        }
        faculties[facultyCount++] = faculty;
    }

    private void expandFacultiesArray() {
        Faculty[] newFaculties = new Faculty[faculties.length * 2];
        System.arraycopy(faculties, 0, newFaculties, 0, faculties.length);
        faculties = newFaculties;
    }

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

    public Faculty getFaculty(String facultyName) {
        for (int i = 0; i < facultyCount; i++) {
            if (faculties[i].getName().equals(facultyName)) {
                return faculties[i];
            }
        }
        return null;
    }

    public void printAllStudents() {
        System.out.println("Всі студенти університету " + name + ":");
        for (int i = 0; i < facultyCount; i++) {
            faculties[i].printAllStudents();
        }
    }

    public void printAllTeachers() {
        System.out.println("Всі викладачі університету " + name + ":");
        for (int i = 0; i < facultyCount; i++) {
            faculties[i].printAllTeachers();
        }
    }

    public void printStudentsByCourse() {
        System.out.println("Студенти університету " + name + " за курсами:");
        for (int i = 0; i < facultyCount; i++) {
            System.out.println("Факультет: " + faculties[i].getName());
            faculties[i].printStudentsByCourse();
        }
    }

    public void printMembersAlphabetically() {
        System.out.println("Члени університету " + name + " в алфавітному порядку:");
        for (int i = 0; i < facultyCount; i++) {
            System.out.println("Факультет: " + faculties[i].getName());
            faculties[i].printMembersAlphabetically();
        }
    }
}

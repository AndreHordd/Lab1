public class University {
    private String name;
    private Faculty[] faculties;
    private int numberOfFaculties;
    private int addedFacultiesCount;


    University(String name, int numberOfFaculties) {
        this.name = name;
        this.numberOfFaculties = numberOfFaculties;
        this.addedFacultiesCount = 0;
        this.faculties = new Faculty[numberOfFaculties];
    }

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

    public int getNumberOfFaculties() {
        return numberOfFaculties;
    }

    public void setNumberOfFaculties(int numberOfFaculties) {
        this.numberOfFaculties = numberOfFaculties;
    }

    public int getAddedFacultiesCount() {
        return addedFacultiesCount;
    }

    public void setAddedFacultiesCount(int addedFacultiesCount) {
        this.addedFacultiesCount = addedFacultiesCount;
    }

    public void addFaculty(Faculty faculty) {
        if (addedFacultiesCount == faculties.length) {
            expandFacultiesArray();
        }
        faculties[addedFacultiesCount++] = faculty;
    }

    private void expandFacultiesArray() {
        Faculty[] newFaculties = new Faculty[faculties.length * 2];
        System.arraycopy(faculties, 0, newFaculties, 0, faculties.length);
        faculties = newFaculties;
    }

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

    public Faculty getFaculty(String facultyName) {
        for (int i = 0; i < addedFacultiesCount; i++) {
            if (faculties[i].getName().equals(facultyName)) {
                return faculties[i];
            }
        }
        return null;
    }

    //Вивести всіх студентів факультета впорядкованих за алфавітом.
    public void printAllStudentsAlphabetically(String facultyName) {
        for (int i = 0; i < addedFacultiesCount; i++) {
            if (faculties[i].getName().equals(facultyName)) {
                faculties[i].printAllStudentsAlphabetically();
            }
        }
    }

    //Вивести всіх викладачів факультета впорядкованих за алфавітом.
    public void printAllTeachersAlphabetically(String facultyName) {
        for (int i = 0; i < addedFacultiesCount; i++) {
            if (faculties[i].getName().equals(facultyName)) {
                faculties[i].printAllTeachersAlphabetically();
            }
        }
    }

    //Вивести всіх студентів впорядкованих за курсами.
    public void printAllStudentsByCourse() {
        for (int i = 0; i < addedFacultiesCount; i++) {
            faculties[i].printAllStudentsByCourse();
        }
    }

    //Знайти студента/викладача за ПІБ
    public void findMemberByName(String name, String surname, String personType) {
        for (int i = 0; i < addedFacultiesCount; i++) {
            faculties[i].findMemberByName(name, surname, personType);
        }
    }

    //Знайти студента/викладача за курсом
    public void findStudentByCourse(int course) {
        for (int i = 0; i < addedFacultiesCount; i++) {
            faculties[i].findStudentByCourse(course);
        }
    }

    //Знайти студента/викладача за групою
    public void findStudentByGroup(int group) {
        for (int i = 0; i < addedFacultiesCount; i++) {
            faculties[i].findStudentByGroup(group);
        }
    }


}

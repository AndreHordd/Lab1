public class Faculty {
    private String name;
    private Department[] departments;
    private int numberOfDepartments;
    private int addedDepartmentsCount;

    Faculty(String name, int numberOfDepartments) {
        this.name = name;
        this.numberOfDepartments = numberOfDepartments;
        this.addedDepartmentsCount = 0;
        this.departments = new Department[numberOfDepartments];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public int getNumberOfDepartments() {
        return numberOfDepartments;
    }

    public void setNumberOfDepartments(int numberOfDepartments) {
        this.numberOfDepartments = numberOfDepartments;
    }

    public int getAddedDepartmentsCount() {
        return addedDepartmentsCount;
    }

    public void setAddedDepartmentsCount(int addedDepartmentsCount) {
        this.addedDepartmentsCount = addedDepartmentsCount;
    }

    public void addDepartment(Department department) {
        if (addedDepartmentsCount == departments.length) {
            expandDepartmentsArray();
        }
        departments[addedDepartmentsCount++] = department;
    }

    private void expandDepartmentsArray() {
        Department[] newDepartments = new Department[departments.length * 2];
        System.arraycopy(departments, 0, newDepartments, 0, departments.length);
        departments = newDepartments;
    }

    public boolean removeDepartment(String departmentName) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                System.arraycopy(departments, i + 1, departments, i, addedDepartmentsCount - i - 1);
                departments[--addedDepartmentsCount] = null;
                return true;
            }
        }
        return false;
    }

    public Department getDepartment(String departmentName) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                return departments[i];
            }
        }
        return null;
    }

    //Вивести всіх студентів кафедри вказаного курсу.
    public void printAllStudentsOfCourse(String departmentName, int course) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                departments[i].printAllStudentsOfCourse(course);
            }
        }
    }

    //Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом.
    public void printAllStudentsOfCourseAlphabetically(String departmentName, int course) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                departments[i].printAllStudentsOfCourseAlphabetically(course);
            }
        }
    }

    //Вивести всіх студентів кафедри впорядкованих за алфавітом.
    public void printAllStudentsAlphabetically(String departmentName) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                departments[i].printAllStudentsAlphabetically();
            }
        }
    }

    //Вивести всіх викладачів кафедри впорядкованих за алфавітом.
    public void printAllTeachersAlphabetically(String departmentName) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                departments[i].printAllTeachersAlphabetically();
            }
        }
    }

    //Вивести всіх студентів кафедри впорядкованих за курсами.
    public void printAllStudentsByCourse(String departmentName) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                departments[i].printAllStudentsByCourse();
            }
        }
    }

    //Вивести всіх студентів факультета впорядкованих за алфавітом.
    public void printAllStudentsAlphabetically() {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            departments[i].printAllStudentsAlphabetically();
        }
    }

    //Вивести всіх викладачів факультета впорядкованих за алфавітом.
    public void printAllTeachersAlphabetically() {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            departments[i].printAllTeachersAlphabetically();
        }
    }

    public void printAllStudentsByCourse() {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            departments[i].printAllStudentsByCourse();
        }
    }

    //Знайти студента/викладача за ПІБ
    public void findMemberByName(String name, String surname, String personType) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            departments[i].findMemberByName(name, surname, personType);
        }
    }

    //Знайти студента/викладача за курсом
    public void findStudentByCourse(int course) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            departments[i].findStudentByCourse(course);
        }
    }

    //Знайти студента/викладача за групою
    public void findStudentByGroup(int group) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            departments[i].findStudentByGroup(group);
        }
    }

    public void printAllDepartments() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i] != null) {
                res.append(this.departments[i].getName()).append(" ");
            }
        }
        System.out.println(res);
    }
}
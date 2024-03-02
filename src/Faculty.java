/**
 * Faculty class represents a faculty of the university.
 */
public class Faculty {
    /**
     * Faculty's name
     */
    private String name;
    /**
     * Array of departments
     */
    private Department[] departments;
    /**
     * Number of departments
     */
    private int numberOfDepartments;
    /**
     * Number of added departments
     */
    private int addedDepartmentsCount;

    /**
     * Constructor for a faculty
     *
     * @param name                faculty's name
     * @param numberOfDepartments number of departments
     */
    Faculty(String name, int numberOfDepartments) {
        this.name = name;
        this.numberOfDepartments = numberOfDepartments;
        this.addedDepartmentsCount = 0;
        this.departments = new Department[numberOfDepartments];
    }

    /**
     * Faculty name getter
     */
    public String getName() {
        return name;
    }

    /**
     * Faculty name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Departments array getter
     */
    public Department[] getDepartments() {
        return departments;
    }

    /**
     * Departments array setter
     */
    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    /**
     * Number of departments getter
     */
    public int getNumberOfDepartments() {
        return numberOfDepartments;
    }

    /**
     * Number of departments setter
     */
    public void setNumberOfDepartments(int numberOfDepartments) {
        this.numberOfDepartments = numberOfDepartments;
    }

    /**
     * Number of added departments getter
     */
    public int getAddedDepartmentsCount() {
        return addedDepartmentsCount;
    }

    /**
     * Number of added departments setter
     */
    public void setAddedDepartmentsCount(int addedDepartmentsCount) {
        this.addedDepartmentsCount = addedDepartmentsCount;
    }

    /**
     * Method to add a department to the faculty
     *
     * @param department department to add
     */
    public void addDepartment(Department department) {
        if (addedDepartmentsCount == departments.length) {
            expandDepartmentsArray();
        }
        departments[addedDepartmentsCount++] = department;
    }

    /**
     * Method to expand the departments array
     */
    private void expandDepartmentsArray() {
        Department[] newDepartments = new Department[departments.length * 2];
        System.arraycopy(departments, 0, newDepartments, 0, departments.length);
        departments = newDepartments;
    }

    /**
     * Method to remove a department from the faculty
     *
     * @param departmentName name of the department to remove
     * @return true if the department was removed, false otherwise
     */
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

    /**
     * Method to get a department by its name
     *
     * @param departmentName name of the department to get
     * @return department with the specified name
     */
    public Department getDepartment(String departmentName) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                return departments[i];
            }
        }
        return null;
    }

    /**
     * Method to print all students of a department of certain course
     *
     * @param departmentName name of the department
     * @param course         course number
     */
    public void printAllStudentsOfCourse(String departmentName, int course) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                departments[i].printAllStudentsOfCourse(course);
            }
        }
    }

    /**
     * Method to print all students of a department of certain course alphabetically
     *
     * @param departmentName name of the department
     * @param course         course number
     */
    public void printAllStudentsOfCourseAlphabetically(String departmentName, int course) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                departments[i].printAllStudentsOfCourseAlphabetically(course);
            }
        }
    }

    /**
     * Method to print all students of a department alphabetically
     *
     * @param departmentName name of the department
     */
    public void printAllStudentsAlphabetically(String departmentName) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                departments[i].printAllStudentsAlphabetically();
            }
        }
    }

    /**
     * Method to print all teachers of a department alphabetically
     *
     * @param departmentName name of the department
     */
    public void printAllTeachersAlphabetically(String departmentName) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                departments[i].printAllTeachersAlphabetically();
            }
        }
    }

    /**
     * Method to print all students of a department increasing course number order
     */
    public void printAllStudentsByCourse(String departmentName) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                departments[i].printAllStudentsByCourse();
            }
        }
    }

    /**
     * Method to print all students of a department alphabetically
     */
    public void printAllStudentsAlphabetically() {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            departments[i].printAllStudentsAlphabetically();
        }
    }

    /**
     * Method to print all teachers of a department alphabetically
     */
    public void printAllTeachersAlphabetically() {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            departments[i].printAllTeachersAlphabetically();
        }
    }

    /**
     * Method to print all students of a department increasing course number order
     */
    public void printAllStudentsByCourse() {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            departments[i].printAllStudentsByCourse();
        }
    }

    /**
     * Method to find a member of a department by name
     *
     * @param name       name of the member
     * @param surname    surname of the member
     * @param personType type of the member (Student or Teacher)
     */
    public void findMemberByName(String name, String surname, String personType) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            departments[i].findMemberByName(name, surname, personType);
        }
    }

    /**
     * Method to find a student of a department by course
     *
     * @param course course number
     */
    public void findStudentByCourse(int course) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            departments[i].findStudentByCourse(course);
        }
    }

    /**
     * Method to find a student of a department by group
     *
     * @param group group number
     */
    public void findStudentByGroup(int group) {
        for (int i = 0; i < addedDepartmentsCount; i++) {
            departments[i].findStudentByGroup(group);
        }
    }

    /**
     * Method to print all departments of the faculty
     */
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
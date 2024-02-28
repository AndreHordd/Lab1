/**
 * Class to represent a faculty
 */
public class Faculty {
    /**
     * Faculty name
     */
    private String name;
    /**
     * Array of departments
     */
    private Department[] departments;
    /**
     * Number of departments
     */
    private int departmentCount;

    /**
     * Constructor for a faculty
     *
     * @param name            faculty name
     * @param initialCapacity initial capacity for departments
     */
    public Faculty(String name, int initialCapacity) {
        this.name = name;
        this.departments = new Department[initialCapacity];
        this.departmentCount = 0;
    }

    /**
     * Method to add a department to the faculty
     *
     * @param department department
     */
    public void addDepartment(Department department) {
        if (departmentCount == departments.length) {
            expandDepartmentsArray();
        }
        departments[departmentCount++] = department;
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
     * @param departmentName department name
     * @return true if department was removed, false otherwise
     */
    public boolean removeDepartment(String departmentName) {
        for (int i = 0; i < departmentCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                System.arraycopy(departments, i + 1, departments, i, departmentCount - i - 1);
                departments[--departmentCount] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Method to get a department by name
     *
     * @param departmentName department name
     * @return department if found, null otherwise
     */
    public Department getDepartment(String departmentName) {
        for (int i = 0; i < departmentCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                return departments[i];
            }
        }
        return null;
    }

    /**
     * Method to print all students of the faculty
     */
    public void printAllStudents() {
        System.out.println("Всі студенти факультету " + name + ":");
        for (int i = 0; i < departmentCount; i++) {
            departments[i].printAllStudents();
        }
    }

    /**
     * Method to print all teachers of the faculty
     */
    public void printAllTeachers() {
        System.out.println("Всі викладачі факультету " + name + ":");
        for (int i = 0; i < departmentCount; i++) {
            departments[i].printAllTeachers();
        }
    }

    /**
     * Method to print all members of the faculty
     */
    public void printStudentsByCourse() {
        for (int course = 1; course <= 6; course++) {
            System.out.println("Курс " + course + " на факультеті " + name + ":");
            for (int i = 0; i < departmentCount; i++) {
                System.out.println("Кафедра: " + departments[i].getName());
                departments[i].printStudentsByCourse(course);
            }
        }
    }

    /**
     * Faculty name getter
     *
     * @return faculty name
     */
    public String getName() {
        return name;
    }

    /**
     * Faculty name setter
     *
     * @param name faculty name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Departments array getter
     *
     * @return departments array
     */
    public Department[] getDepartments() {
        return departments;
    }

    /**
     * Departments array setter
     *
     * @param departments departments array
     */
    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    /**
     * Department count getter
     *
     * @return department count
     */
    public int getDepartmentCount() {
        return departmentCount;
    }

    /**
     * Department count setter
     *
     * @param departmentCount department count
     */
    public void setDepartmentCount(int departmentCount) {
        this.departmentCount = departmentCount;
    }

    /**
     * Method to print members alphabetically
     */
    public void printMembersAlphabetically() {
        System.out.println("Члени факультету " + name + " в алфавітному порядку:");
        for (int i = 0; i < departmentCount; i++) {
            departments[i].printMembersAlphabetically();
        }
    }
}

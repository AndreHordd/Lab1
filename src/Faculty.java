public class Faculty {
    private String name;
    private Department[] departments;
    private int departmentCount;

    public Faculty(String name, int initialCapacity) {
        this.name = name;
        this.departments = new Department[initialCapacity];
        this.departmentCount = 0;
    }

    public void addDepartment(Department department) {
        if (departmentCount == departments.length) {
            expandDepartmentsArray();
        }
        departments[departmentCount++] = department;
    }

    private void expandDepartmentsArray() {
        Department[] newDepartments = new Department[departments.length * 2];
        System.arraycopy(departments, 0, newDepartments, 0, departments.length);
        departments = newDepartments;
    }

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

    public Department getDepartment(String departmentName) {
        for (int i = 0; i < departmentCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                return departments[i];
            }
        }
        return null;
    }

    public void printAllStudents() {
        System.out.println("Всі студенти факультету " + name + ":");
        for (int i = 0; i < departmentCount; i++) {
            departments[i].printAllStudents();
        }
    }

    public void printAllTeachers() {
        System.out.println("Всі викладачі факультету " + name + ":");
        for (int i = 0; i < departmentCount; i++) {
            departments[i].printAllTeachers();
        }
    }

    public void printStudentsByCourse() {
        for (int course = 1; course <= 6; course++) {
            System.out.println("Курс " + course + " на факультеті " + name + ":");
            for (int i = 0; i < departmentCount; i++) {
                System.out.println("Кафедра: " + departments[i].getName());
                departments[i].printStudentsByCourse(course);
            }
        }
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

    public int getDepartmentCount() {
        return departmentCount;
    }

    public void setDepartmentCount(int departmentCount) {
        this.departmentCount = departmentCount;
    }

    public void printMembersAlphabetically() {
        System.out.println("Члени факультету " + name + " в алфавітному порядку:");
        for (int i = 0; i < departmentCount; i++) {
            departments[i].printMembersAlphabetically();
        }
    }
}

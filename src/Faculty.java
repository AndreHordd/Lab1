import java.util.Arrays;

// Клас Факультету
class Faculty {
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
            departments = Arrays.copyOf(departments, departments.length * 2);
        }
        departments[departmentCount++] = department;
    }

    // Аналогічні методи для видалення та пошуку кафедр
}
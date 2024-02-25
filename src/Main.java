import java.io.IOException;

public class Main {

    private University university;

    public Main(University university) {
        this.university = university;
    }

    public void start() {
        while (true) {
            try {
                System.out.println("\nВиберіть опцію:");
                System.out.println("1 - Додати факультет");
                System.out.println("2 - Видалити факультет");
                System.out.println("3 - Додати кафедру");
                System.out.println("4 - Видалити кафедру");
                System.out.println("5 - Додати студента/викладача");
                System.out.println("6 - Видалити студента/викладача");
                System.out.println("7 - Знайти студента/викладача");
                System.out.println("8 - Вивести всіх студентів");
                System.out.println("9 - Вивести всіх викладачів");
                System.out.println("0 - Вийти");

                int choice = DataInput.getInt();
                switch (choice) {
                    case 1:
                        addFaculty();
                        break;
                    case 2:
                        removeFaculty();
                        break;
                    case 3:
                        addDepartment();
                        break;
                    case 4:
                        removeDepartment();
                        break;
                    case 5:
                        addPerson();
                        break;
                    case 6:
                        removePerson();
                        break;
                    case 7:
                        findPerson();
                        break;
                    case 8:
                        university.printAllStudents();
                        break;
                    case 9:
                        university.printAllTeachers();
                        break;
                    case 0:
                        System.out.println("Вихід з програми.");
                        return;
                    default:
                        System.out.println("Невідома команда.");
                }
            } catch (IOException e) {
                System.out.println("Помилка вводу, спробуйте ще раз.");
            }
        }
    }

    private void addFaculty() throws IOException {
        System.out.println("Введіть назву факультету:");
        String name = DataInput.getString();
        Faculty faculty = new Faculty(name, 10); // Припустимо, що початкова ємність - 10 кафедр
        university.addFaculty(faculty);
        System.out.println("Факультет '" + name + "' додано.");
    }

    private void removeFaculty() throws IOException {
        System.out.println("Введіть назву факультету для видалення:");
        String name = DataInput.getString();
        if (university.removeFaculty(name)) {
            System.out.println("Факультет '" + name + "' видалено.");
        } else {
            System.out.println("Факультет '" + name + "' не знайдено.");
        }
    }

    private void addDepartment() throws IOException {
        System.out.println("Введіть назву факультету, до якого додати кафедру:");
        String facultyName = DataInput.getString();
        Faculty faculty = university.getFaculty(facultyName);
        if (faculty != null) {
            System.out.println("Введіть назву кафедри:");
            String departmentName = DataInput.getString();
            Department department = new Department(departmentName, 10); // Припустимо, що початкова ємність - 10 членів кафедри
            faculty.addDepartment(department);
            System.out.println("Кафедра '" + departmentName + "' додана до факультету '" + facultyName + "'.");
        } else {
            System.out.println("Факультет '" + facultyName + "' не знайдено.");
        }
    }

    private void removeDepartment() throws IOException {
        System.out.println("Введіть назву факультету, з якого видалити кафедру:");
        String facultyName = DataInput.getString();
        Faculty faculty = university.getFaculty(facultyName);
        if (faculty != null) {
            System.out.println("Введіть назву кафедри для видалення:");
            String departmentName = DataInput.getString();
            if (faculty.removeDepartment(departmentName)) {
                System.out.println("Кафедра '" + departmentName + "' видалена з факультету '" + facultyName + "'.");
            } else {
                System.out.println("Кафедра '" + departmentName + "' не знайдена на факультеті '" + facultyName + "'.");
            }
        } else {
            System.out.println("Факультет '" + facultyName + "' не знайдено.");
        }
    }

    private void addPerson() throws IOException {
        System.out.println("Ви хочете додати студента чи викладача? (S/T):");
        char type = DataInput.getChar();
        System.out.println("Введіть назву факультету:");
        String facultyName = DataInput.getString();
        Faculty faculty = university.getFaculty(facultyName);
        if (faculty != null) {
            System.out.println("Введіть назву кафедри:");
            String departmentName = DataInput.getString();
            Department department = faculty.getDepartment(departmentName);
            if (department != null) {
                System.out.println("Введіть ім'я:");
                String name = DataInput.getString();
                System.out.println("Введіть прізвище:");
                String surname = DataInput.getString();
                if (type == 'S' || type == 's') {
                    System.out.println("Введіть курс:");
                    int course = DataInput.getInt();
                    System.out.println("Введіть групу:");
                    String group = DataInput.getString();
                    Student student = new Student(name, surname, course, group);
                    department.addMember(student);
                    System.out.println("Студент '" + name + " " + surname + "' доданий до кафедри '" + departmentName + "'.");
                } else if (type == 'T' || type == 't') {
                    System.out.println("Введіть академічну посаду:");
                    String position = DataInput.getString();
                    Teacher teacher = new Teacher(name, surname, position, 5); // Припустимо, що початкова ємність предметів - 5
                    department.addMember(teacher);
                    System.out.println("Викладач '" + name + " " + surname + "' доданий до кафедри '" + departmentName + "'.");
                } else {
                    System.out.println("Невідомий тип, спробуйте ще раз.");
                }
            } else {
                System.out.println("Кафедра '" + departmentName + "' не знайдена на факультеті '" + facultyName + "'.");
            }
        } else {
            System.out.println("Факультет '" + facultyName + "' не знайдено.");
        }
    }

    private void removePerson() throws IOException {
        System.out.println("Ви хочете видалити студента чи викладача? (S/T):");
        char type = DataInput.getChar();
        System.out.println("Введіть назву факультету:");
        String facultyName = DataInput.getString();
        Faculty faculty = university.getFaculty(facultyName);
        if (faculty != null) {
            System.out.println("Введіть назву кафедри:");
            String departmentName = DataInput.getString();
            Department department = faculty.getDepartment(departmentName);
            if (department != null) {
                System.out.println("Введіть ім'я:");
                String name = DataInput.getString();
                System.out.println("Введіть прізвище:");
                String surname = DataInput.getString();
                if (department.removeMember(name, surname)) {
                    System.out.println((type == 'S' || type == 's' ? "Студент" : "Викладач") + " '" + name + " " + surname + "' видалений з кафедри '" + departmentName + "'.");
                } else {
                    System.out.println("Особа не знайдена.");
                }
            } else {
                System.out.println("Кафедра '" + departmentName + "' не знайдена на факультеті '" + facultyName + "'.");
            }
        } else {
            System.out.println("Факультет '" + facultyName + "' не знайдено.");
        }
    }

    private void findPerson() throws IOException {
        System.out.println("Ви хочете знайти студента чи викладача? (S/T):");
        char type = DataInput.getChar();
        System.out.println("Введіть ім'я:");
        String name = DataInput.getString();
        System.out.println("Введіть прізвище:");
        String surname = DataInput.getString();
        for (Faculty faculty : university.getFaculties()) {
            if (faculty != null) {
                for (Department department : faculty.getDepartments()) {
                    if (department != null) {
                        Person person = department.findMemberByName(name, surname);
                        if (person != null && person.getPersonType().equalsIgnoreCase(type == 'S' ? "Student" : "Teacher")) {
                            System.out.println(person + " знайдено на кафедрі '" + department.getName() + "' факультету '" + faculty.getName() + "'.");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println((type == 'S' ? "Студент" : "Викладач") + " '" + name + " " + surname + "' не знайдений.");
    }

    // Методи removeFaculty, addDepartment, removeDepartment, addPerson, removePerson, findPerson
    // слід реалізувати аналогічним чином, використовуючи методи класу DataInput для отримання вводу від користувача
    // і відповідні методи інстансів класів University, Faculty, Department для внесення змін.

    public static void main(String[] args) {
        University university = new University("Національний університет \"Києво-Могилянська академія\"", 10); // Припустимо, що початкова ємність - 10 факультетів
        Main management = new Main(university);
        management.start();
    }
}

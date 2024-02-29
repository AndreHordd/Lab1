public class Main {

    private University university;

    public Main(University university) {
        this.university = university;
    }

    private static University createNaUKMA() {
        University university = new University("NaUKMA", 10);
        return university;
    }

    private void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|        Лабораторна робота         |");
        System.out.println("|       Номер 1 \"Університет\"       |");
        System.out.println("|                                   |");
        System.out.println("|             Виконали:             |");
        System.out.println("|          Гордашко Андрій          |");
        System.out.println("|          Забродін Максим          |");
        System.out.println("|          Трубіцин Артем           |");
        System.out.println("+-----------------------------------+");
    }

    private void printMainMenu() {
        System.out.println("\n=-=-=-=-=-=-=-=- Меню -=-=-=-=-=-=-=-=");
        System.out.println("[1] Взаємодіяти з факультетами");
        System.out.println("[2] Взаємодіяти з кафедрами");
        System.out.println("[3] Взаємодіяти зі студентами/викладачами");
        System.out.println("[4] Вивести у консоль інформацію");
        System.out.println("[5] Знайти студента/викладача");
        System.out.println("[6] Вийти з програми");
    }

    private void mainMenuAction() {
        printMainMenu();
        System.out.print("Виберіть дію: ");
        Integer mainMenuAction = DataInput.getInt();
        while (mainMenuAction == null || mainMenuAction < 1 || mainMenuAction > 6) {
            System.out.print("Введіть коректне значення: ");
            mainMenuAction = DataInput.getInt();
        }
        switch (mainMenuAction) {
            case 1:
                facultyMenuAction();
                break;
            case 2:
                departmentMenuAction();
                break;
            case 3:
                membersMenuAction();
                break;
            case 4:
                informationMenuAction();
                break;
            case 5:
                findMenuAction();
                break;
            case 6:
                System.out.println("Дякуємо за користування програмою");
                System.exit(0);
        }
    }

    private void printFacultyMenu() {
        System.out.println("\n=-=-=- Взаємодія з факультетами -=-=-=");
        if (university.getAddedFacultiesCount() != 0) {
            System.out.println("Наявні факультети:");
            university.printAllFaculties();
        }
        System.out.println("[1] Додати факультет");
        System.out.println("[2] Змінити назву факультету");
        System.out.println("[3] Видалити факультет");
        System.out.println("[4] Вийти у головне меню");
    }

    private void facultyMenuAction() {
        printFacultyMenu();
        System.out.print("Виберіть дію: ");
        Integer facultyMenuAction = DataInput.getInt();
        while (facultyMenuAction == null || facultyMenuAction < 1 || facultyMenuAction > 4) {
            System.out.print("Введіть коректне значення: ");
            facultyMenuAction = DataInput.getInt();
        }
        switch (facultyMenuAction) {
            case 1:
                if (university.getAddedFacultiesCount() != 0) {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                }
                System.out.println("Введіть назву факультету");
                String facultyName = DataInput.getText();
                while (facultyName == null || facultyName.isEmpty()) {
                    System.out.print("Введіть коректне значення: ");
                    facultyName = DataInput.getText();
                }
                while (university.getFaculty(facultyName) != null) {
                    System.out.print("Факультет з такою назвою вже існує. Введіть іншу назву: ");
                    facultyName = DataInput.getText();
                }
                System.out.print("Введіть початкову кількість кафедр на факультеті: ");
                Integer departmentsNumber = DataInput.getInt();
                while (departmentsNumber == null || departmentsNumber < 1) {
                    System.out.print("Введіть коректне значення: ");
                    departmentsNumber = DataInput.getInt();
                }
                university.addFaculty(new Faculty(facultyName, departmentsNumber));
                System.out.println("Факультет " + facultyName + " успішно додано");
                facultyMenuAction();
                break;
            case 2:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для зміни");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty == null) {
                        System.out.println("Факультет з такою назвою не існує");
                    } else {
                        System.out.println("Введіть нову назву факультету");
                        String newFacultyName = DataInput.getText();
                        while (newFacultyName == null || newFacultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            newFacultyName = DataInput.getText();
                        }
                        while (university.getFaculty(newFacultyName) != null) {
                            System.out.print("Факультет з такою назвою вже існує. Введіть іншу назву: ");
                            newFacultyName = DataInput.getText();
                            while (newFacultyName == null || newFacultyName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                newFacultyName = DataInput.getText();
                            }
                        }
                        faculty.setName(newFacultyName);
                        System.out.println("Назву факультету успішно змінено");
                    }
                }
                facultyMenuAction();
                break;
            case 3:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для видалення");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    if (university.removeFaculty(facultyName)) {
                        System.out.println("Факультет " + facultyName + " успішно видалено");
                    } else {
                        System.out.println("Факультет з такою назвою не існує");
                    }
                }
                facultyMenuAction();
                break;
            case 4:
                mainMenuAction();
        }
    }

    private void printDepartmentMenu() {
        System.out.println("\n=-=-=-=- Взаємодія з кафедрами -=-=-=-");
        System.out.println("[1] Додати кафедру");
        System.out.println("[2] Змінити назву кафедри");
        System.out.println("[3] Видалити кафедру");
        System.out.println("[4] Вийти у головне меню");
    }

    private void departmentMenuAction() {
        printDepartmentMenu();
        System.out.print("Виберіть дію: ");
        Integer departmentMenuAction = DataInput.getInt();
        while (departmentMenuAction == null || departmentMenuAction < 1 || departmentMenuAction > 4) {
            System.out.print("Введіть коректне значення: ");
            departmentMenuAction = DataInput.getInt();
        }
        switch (departmentMenuAction) {
            case 1:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для додавання кафедр");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty.getAddedDepartmentsCount() != 0) {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                    }
                    System.out.println("Введіть назву кафедри");
                    String departmentName = DataInput.getText();
                    while (departmentName == null || departmentName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        departmentName = DataInput.getText();
                    }
                    while (faculty.getDepartment(departmentName) != null) {
                        System.out.print("Кафедра з такою назвою вже існує. Введіть іншу назву: ");
                        departmentName = DataInput.getText();
                    }
                    System.out.print("Введіть початкову кількість викладачів на кафедрі: ");
                    Integer teachersNumber = DataInput.getInt();
                    while (teachersNumber == null || teachersNumber < 1) {
                        System.out.print("Введіть коректне значення: ");
                        teachersNumber = DataInput.getInt();
                    }
                    System.out.print("Введіть початкову кількість cтудентів на кафедрі: ");
                    Integer studentsNumber = DataInput.getInt();
                    while (studentsNumber == null || studentsNumber < 1) {
                        System.out.print("Введіть коректне значення: ");
                        studentsNumber = DataInput.getInt();
                    }
                    faculty.addDepartment(new Department(departmentName, teachersNumber + studentsNumber));
                    System.out.println("Кафедру " + departmentName + " успішно додано");
                }
                departmentMenuAction();
                break;
            case 2:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для зміни кафедр");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty.getAddedDepartmentsCount() <= 0) {
                        System.out.println("Немає кафедр для зміни");
                    } else {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                        System.out.println("Введіть назву кафедри");
                        String departmentName = DataInput.getText();
                        while (departmentName == null || departmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            departmentName = DataInput.getText();
                        }
                        while (faculty.getDepartment(departmentName) == null) {
                            System.out.println("Кафедра з такою назвою не існує. Введіть іншу назву: ");
                            departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                        }
                        Department department = faculty.getDepartment(departmentName);
                        System.out.println("Введіть нову назву кафедри");
                        String newDepartmentName = DataInput.getText();
                        while (newDepartmentName == null || newDepartmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            newDepartmentName = DataInput.getText();
                        }
                        while (faculty.getDepartment(newDepartmentName) != null) {
                            System.out.print("Кафедра з такою назвою вже існує. Введіть іншу назву: ");
                            newDepartmentName = DataInput.getText();
                            while (newDepartmentName == null || newDepartmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                newDepartmentName = DataInput.getText();
                            }
                        }
                        department.setName(newDepartmentName);
                        System.out.println("Назву кафедри успішно змінено");


                    }
                }
                departmentMenuAction();
                break;
            case 3:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для видалення кафедр");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    while (faculty == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    if (faculty.getAddedDepartmentsCount() <= 0) {
                        System.out.println("Немає кафедр для видалення");
                    } else {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                        System.out.println("Введіть назву кафедри");
                        String departmentName = DataInput.getText();
                        while (departmentName == null || departmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            departmentName = DataInput.getText();
                        }
                        if (faculty.removeDepartment(departmentName)) {
                            System.out.println("Кафедру " + departmentName + " успішно видалено");
                        } else {
                            System.out.println("Кафедра з такою назвою не існує");
                        }
                    }
                }

                departmentMenuAction();
                break;
            case 4:
                mainMenuAction();
        }
    }

    private void printMembersMenu() {
        System.out.println("\n=-=-=- Взаємодія зі студентами/викладачами -=-=-=");
        System.out.println("[1] Додати студента");
        System.out.println("[2] Додати викладача");
        System.out.println("[3] Видалити студента");
        System.out.println("[4] Видалити викладача");
        System.out.println("[5] Змінити інформацію про студента");
        System.out.println("[6] Змінити інформацію про викладача");
        System.out.println("[7] Вийти у головне меню");
    }

    private void membersMenuAction() {
        printMembersMenu();
        System.out.print("Виберіть дію: ");
        Integer membersMenuAction = DataInput.getInt();
        while (membersMenuAction == null || membersMenuAction < 1 || membersMenuAction > 7) {
            System.out.print("Введіть коректне значення: ");
            membersMenuAction = DataInput.getInt();
        }
        switch (membersMenuAction) {
            case 1:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для додавання студентів");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty.getAddedDepartmentsCount() <= 0) {
                        System.out.println("Немає кафедр для додавання студентів");
                    } else {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                        System.out.println("Введіть назву кафедри");
                        String departmentName = DataInput.getText();
                        while (departmentName == null || departmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            departmentName = DataInput.getText();
                        }
                        while (faculty.getDepartment(departmentName) == null) {
                            System.out.print("Кафедра з такою назвою не існує. Введіть іншу назву: ");
                            departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                        }
                        Department department = faculty.getDepartment(departmentName);
                        System.out.println("Введіть ім'я студента");
                        String studentName = DataInput.getText();
                        while (studentName == null || studentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            studentName = DataInput.getText();
                        }
                        System.out.println("Введіть прізвище студента");
                        String studentSurname = DataInput.getText();
                        while (studentSurname == null || studentSurname.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            studentSurname = DataInput.getText();
                        }
                        System.out.print("Введіть курс студента: ");
                        Integer studentCourse = DataInput.getInt();
                        while (studentCourse == null || studentCourse < 1 || studentCourse > 6) {
                            System.out.print("Введіть коректне значення: ");
                            studentCourse = DataInput.getInt();
                        }
                        System.out.print("Введіть групу студента: ");
                        Integer studentGroup = DataInput.getInt();
                        while (studentGroup == null || studentGroup < 1 || studentGroup > 20) {
                            System.out.print("Введіть коректне значення: ");
                            studentGroup = DataInput.getInt();
                        }
                        department.addMember(new Student(studentName, studentSurname, studentCourse, studentGroup, faculty, department));
                        System.out.println("Студента " + studentName + " " + studentSurname + " успішно додано");
                    }
                }
                membersMenuAction();
                break;
            case 2:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для додавання викладачів");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty.getAddedDepartmentsCount() <= 0) {
                        System.out.println("Немає кафедр для додавання викладачів");
                    } else {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                        System.out.println("Введіть назву кафедри");
                        String departmentName = DataInput.getText();
                        while (departmentName == null || departmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            departmentName = DataInput.getText();
                        }
                        while (faculty.getDepartment(departmentName) == null) {
                            System.out.print("Кафедра з такою назвою не існує. Введіть іншу назву: ");
                            departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                        }
                        Department department = faculty.getDepartment(departmentName);
                        System.out.println("Введіть ім'я викладача");
                        String teacherName = DataInput.getText();
                        while (teacherName == null || teacherName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            teacherName = DataInput.getText();
                        }
                        System.out.println("Введіть прізвище викладача");
                        String teacherSurname = DataInput.getText();
                        while (teacherSurname == null || teacherSurname.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            teacherSurname = DataInput.getText();
                        }
                        department.addMember(new Teacher(teacherName, teacherSurname, faculty, department));
                        System.out.println("Викладача " + teacherName + " " + teacherSurname + " успішно додано");
                    }
                }
                membersMenuAction();
                break;
            case 3:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для видалення студентів");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty.getAddedDepartmentsCount() <= 0) {
                        System.out.println("Немає кафедр для видалення студентів");
                    } else {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                        System.out.println("Введіть назву кафедри");
                        String departmentName = DataInput.getText();
                        while (departmentName == null || departmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            departmentName = DataInput.getText();
                        }
                        while (faculty.getDepartment(departmentName) == null) {
                            System.out.print("Кафедра з такою назвою не існує. Введіть іншу назву: ");
                            departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                        }
                        Department department = faculty.getDepartment(departmentName);
                        if (department.getAddedMembersCount() <= 0) {
                            System.out.println("Немає студентів для видалення");
                        } else {
                            System.out.println("Введіть ім'я студента");
                            String studentName = DataInput.getText();
                            while (studentName == null || studentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                studentName = DataInput.getText();
                            }
                            System.out.println("Введіть прізвище студента");
                            String studentSurname = DataInput.getText();
                            while (studentSurname == null || studentSurname.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                studentSurname = DataInput.getText();
                            }
                            if (department.removeMember(studentName, studentSurname, "Student")) {
                                System.out.println("Студента " + studentName + " " + studentSurname + " успішно видалено");
                            } else {
                                System.out.println("Студента з таким ім'ям та прізвищем не існує");
                            }
                        }
                    }
                }
                membersMenuAction();
                break;
            case 4:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для видалення викладачів");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty.getAddedDepartmentsCount() <= 0) {
                        System.out.println("Немає кафедр для видалення викладачів");
                    } else {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                        System.out.println("Введіть назву кафедри");
                        String departmentName = DataInput.getText();
                        while (departmentName == null || departmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            departmentName = DataInput.getText();
                        }
                        while (faculty.getDepartment(departmentName) == null) {
                            System.out.print("Кафедра з такою назвою не існує. Введіть іншу назву: ");
                            departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                        }
                        Department department = faculty.getDepartment(departmentName);
                        if (department.getAddedMembersCount() <= 0) {
                            System.out.println("Немає викладачів для видалення");
                        } else {
                            System.out.println("Введіть ім'я викладача");
                            String teacherName = DataInput.getText();
                            while (teacherName == null || teacherName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                teacherName = DataInput.getText();
                            }
                            System.out.println("Введіть прізвище викладача");
                            String teacherSurname = DataInput.getText();
                            while (teacherSurname == null || teacherSurname.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                teacherSurname = DataInput.getText();
                            }
                            if (department.removeMember(teacherName, teacherSurname, "Teacher")) {
                                System.out.println("Викладача " + teacherName + " " + teacherSurname + " успішно видалено");
                            } else {
                                System.out.println("Викладача з таким ім'ям та прізвищем не існує");
                            }
                        }
                    }
                }
                membersMenuAction();
                break;
            case 5:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для зміни студентів");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty.getAddedDepartmentsCount() <= 0) {
                        System.out.println("Немає кафедр для зміни студентів");
                    } else {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                        System.out.println("Введіть назву кафедри");
                        String departmentName = DataInput.getText();
                        while (departmentName == null || departmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            departmentName = DataInput.getText();
                        }
                        while (faculty.getDepartment(departmentName) == null) {
                            System.out.print("Кафедра з такою назвою не існує. Введіть іншу назву: ");
                            departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                        }
                        Department department = faculty.getDepartment(departmentName);
                        if (department.getAddedMembersCount() <= 0) {
                            System.out.println("Немає студентів для зміни");
                        } else {
                            System.out.println("Введіть ім'я студента");
                            String studentName = DataInput.getText();
                            while (studentName == null || studentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                studentName = DataInput.getText();
                            }
                            System.out.println("Введіть прізвище студента");
                            String studentSurname = DataInput.getText();
                            while (studentSurname == null || studentSurname.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                studentSurname = DataInput.getText();
                            }
                            if (department.getMember(studentName, studentSurname, "Student") == null) {
                                System.out.println("Студента з таким ім'ям та прізвищем не існує");
                            } else {
                                System.out.println("Введіть нове ім'я студента");
                                String newStudentName = DataInput.getText();
                                while (newStudentName == null || newStudentName.isEmpty()) {
                                    System.out.print("Введіть коректне значення: ");
                                    newStudentName = DataInput.getText();
                                }
                                System.out.println("Введіть нове прізвище студента");
                                String newStudentSurname = DataInput.getText();
                                while (newStudentSurname == null || newStudentSurname.isEmpty()) {
                                    System.out.print("Введіть коректне значення: ");
                                    newStudentSurname = DataInput.getText();
                                }
                                System.out.print("Введіть новий курс студента: ");
                                Integer newStudentCourse = DataInput.getInt();
                                while (newStudentCourse == null || newStudentCourse < 1 || newStudentCourse > 6) {
                                    System.out.print("Введіть коректне значення: ");
                                    newStudentCourse = DataInput.getInt();
                                }
                                System.out.print("Введіть нову групу студента: ");
                                Integer newStudentGroup = DataInput.getInt();
                                while (newStudentGroup == null || newStudentGroup < 1 || newStudentGroup > 20) {
                                    System.out.print("Введіть коректне значення: ");
                                    newStudentGroup = DataInput.getInt();
                                }
                                if (department.changeMember(department.getMember(studentName, studentSurname, "Student"),
                                        new Student(newStudentName, newStudentSurname, newStudentCourse, newStudentGroup, faculty, department))) {
                                    System.out.println("Інформацію про студента оновлено");
                                } else {
                                    System.out.println("Сталася помилка. Інформацію про студента не змінено");
                                }
                            }
                        }
                    }
                }
                membersMenuAction();
                break;
            case 6:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для зміни викладачів");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty.getAddedDepartmentsCount() <= 0) {
                        System.out.println("Немає кафедр для зміни викладачів");
                    } else {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                        System.out.println("Введіть назву кафедри");
                        String departmentName = DataInput.getText();
                        while (departmentName == null || departmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            departmentName = DataInput.getText();
                        }
                        while (faculty.getDepartment(departmentName) == null) {
                            System.out.print("Кафедра з такою назвою не існує. Введіть іншу назву: ");
                            departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                        }
                        Department department = faculty.getDepartment(departmentName);
                        if (department.getAddedMembersCount() <= 0) {
                            System.out.println("Немає викладачів для зміни");
                        } else {
                            System.out.println("Введіть ім'я викладача");
                            String teacherName = DataInput.getText();
                            while (teacherName == null || teacherName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                teacherName = DataInput.getText();
                            }
                            System.out.println("Введіть прізвище викладача");
                            String teacherSurname = DataInput.getText();
                            while (teacherSurname == null || teacherSurname.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                teacherSurname = DataInput.getText();
                            }
                            if (department.getMember(teacherName, teacherSurname, "Teacher") == null) {
                                System.out.println("Викладача з таким ім'ям та прізвищем не існує");
                            } else {
                                System.out.println("Введіть нове ім'я викладача");
                                String newTeacherName = DataInput.getText();
                                while (newTeacherName == null || newTeacherName.isEmpty()) {
                                    System.out.print("Введіть коректне значення: ");
                                    newTeacherName = DataInput.getText();
                                }
                                System.out.println("Введіть нове прізвище викладача");
                                String newTeacherSurname = DataInput.getText();
                                while (newTeacherSurname == null || newTeacherSurname.isEmpty()) {
                                    System.out.print("Введіть коректне значення: ");
                                    newTeacherSurname = DataInput.getText();
                                }
                                if (department.changeMember(department.getMember(teacherName, teacherSurname, "Teacher"),
                                        new Teacher(newTeacherName, newTeacherSurname, faculty, department))) {
                                    System.out.println("Інформацію про викладача оновлено");
                                } else {
                                    System.out.println("Сталася помилка. Інформацію про викладача не змінено");
                                }
                            }
                        }
                    }
                }
                membersMenuAction();
                break;
            case 7:
                mainMenuAction();
                break;
        }
    }

    private void printInformationMenu() {
        System.out.println("\n=-=-=-=- Виведення інформації -=-=-=-=");
        System.out.println("[1] Вивести всіх студентів впорядкованих за курсами");
        System.out.println("[2] Вивести всіх студентів факультета впорядкованих за алфавітом");
        System.out.println("[3] Вивести всіх викладачів факультета впорядкованих за алфавітом");
        System.out.println("[4] Вивести всіх студентів кафедри впорядкованих за курсами");
        System.out.println("[5] Вивести всіх студентів кафедри впорядкованих за алфавітом");
        System.out.println("[6] Вивести всіх викладачів кафедри впорядкованих за алфавітом");
        System.out.println("[7] Вивести всіх студентів кафедри вказаного курсу");
        System.out.println("[8] Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом");
        System.out.println("[9] Вийти у головне меню");
    }

    private void informationMenuAction() {
        printInformationMenu();
        System.out.print("Виберіть дію: ");
        Integer informationMenuAction = DataInput.getInt();
        while (informationMenuAction == null || informationMenuAction < 1 || informationMenuAction > 9) {
            System.out.print("Введіть коректне значення: ");
            informationMenuAction = DataInput.getInt();
        }
        switch (informationMenuAction) {
            case 1:
                university.printAllStudentsByCourse();
                informationMenuAction();
                break;
            case 2:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для виведення студентів");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    university.printAllStudentsAlphabetically(university.getFaculty(facultyName).getName());
                }
                informationMenuAction();
                break;
            case 3:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для виведення викладачів");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    university.printAllStudentsAlphabetically(university.getFaculty(facultyName).getName());
                }
                informationMenuAction();
                break;
            case 4:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для виведення студентів кафедри");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty.getAddedDepartmentsCount() <= 0) {
                        System.out.println("Немає кафедр для виведення студентів");
                    } else {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                        System.out.println("Введіть назву кафедри");
                        String departmentName = DataInput.getText();
                        while (departmentName == null || departmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            departmentName = DataInput.getText();
                        }
                        while (faculty.getDepartment(departmentName) == null) {
                            System.out.print("Кафедра з такою назвою не існує. Введіть іншу назву: ");
                            departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                        }
                        faculty.printAllStudentsByCourse(faculty.getDepartment(departmentName).getName());
                    }
                }
                informationMenuAction();
                break;
            case 5:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для виведення студентів кафедри");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty.getAddedDepartmentsCount() <= 0) {
                        System.out.println("Немає кафедр для виведення студентів");
                    } else {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                        System.out.println("Введіть назву кафедри");
                        String departmentName = DataInput.getText();
                        while (departmentName == null || departmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            departmentName = DataInput.getText();
                        }
                        while (faculty.getDepartment(departmentName) == null) {
                            System.out.print("Кафедра з такою назвою не існує. Введіть іншу назву: ");
                            departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                        }
                        faculty.printAllStudentsAlphabetically(faculty.getDepartment(departmentName).getName());
                    }
                }
                informationMenuAction();
                break;
            case 6:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для виведення студентів кафедри");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty.getAddedDepartmentsCount() <= 0) {
                        System.out.println("Немає кафедр для виведення студентів");
                    } else {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                        System.out.println("Введіть назву кафедри");
                        String departmentName = DataInput.getText();
                        while (departmentName == null || departmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            departmentName = DataInput.getText();
                        }
                        while (faculty.getDepartment(departmentName) == null) {
                            System.out.print("Кафедра з такою назвою не існує. Введіть іншу назву: ");
                            departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                        }
                        faculty.printAllTeachersAlphabetically(faculty.getDepartment(departmentName).getName());
                    }
                }
                informationMenuAction();
                break;
            case 7:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для виведення студентів кафедри");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty.getAddedDepartmentsCount() <= 0) {
                        System.out.println("Немає кафедр для виведення студентів");
                    } else {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                        System.out.println("Введіть назву кафедри");
                        String departmentName = DataInput.getText();
                        while (departmentName == null || departmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            departmentName = DataInput.getText();
                        }
                        while (faculty.getDepartment(departmentName) == null) {
                            System.out.print("Кафедра з такою назвою не існує. Введіть іншу назву: ");
                            departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                        }
                        System.out.print("Введіть курс студентів: ");
                        Integer course = DataInput.getInt();
                        while (course == null || course < 1 || course > 6) {
                            System.out.print("Введіть коректне значення: ");
                            course = DataInput.getInt();
                        }
                        faculty.printAllStudentsOfCourse(faculty.getDepartment(departmentName).getName(), course);
                    }
                }
                informationMenuAction();
                break;
            case 8:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для виведення студентів кафедри");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    while (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує. Введіть іншу назву: ");
                        facultyName = DataInput.getText();
                        while (facultyName == null || facultyName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            facultyName = DataInput.getText();
                        }
                    }
                    Faculty faculty = university.getFaculty(facultyName);
                    if (faculty.getAddedDepartmentsCount() <= 0) {
                        System.out.println("Немає кафедр для виведення студентів");
                    } else {
                        System.out.println("Наявні кафедри:");
                        faculty.printAllDepartments();
                        System.out.println("Введіть назву кафедри");
                        String departmentName = DataInput.getText();
                        while (departmentName == null || departmentName.isEmpty()) {
                            System.out.print("Введіть коректне значення: ");
                            departmentName = DataInput.getText();
                        }
                        while (faculty.getDepartment(departmentName) == null) {
                            System.out.print("Кафедра з такою назвою не існує. Введіть іншу назву: ");
                            departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                        }
                        System.out.print("Введіть курс студентів: ");
                        Integer course = DataInput.getInt();
                        while (course == null || course < 1 || course > 6) {
                            System.out.print("Введіть коректне значення: ");
                            course = DataInput.getInt();
                        }
                        faculty.printAllStudentsOfCourseAlphabetically(faculty.getDepartment(departmentName).getName(), course);
                    }
                }
                informationMenuAction();
                break;
            case 9:
                mainMenuAction();
                break;
        }
    }

    private void printFindMenu() {
        System.out.println("\n=-=-=- Пошук студента/викладача -=-=-=");
        System.out.println("[1] Знайти студента за ім'ям та прізвищем");
        System.out.println("[2] Знайти студента за курсом");
        System.out.println("[3] Знайти студента за групою");
        System.out.println("[4] Знайти викладача за ім'ям та прізвищем");
        System.out.println("[5] Вийти у головне меню");
    }

    private void findMenuAction() {
        printFindMenu();
        System.out.print("Виберіть дію: ");
        Integer findMenuAction = DataInput.getInt();
        while (findMenuAction == null || findMenuAction < 1 || findMenuAction > 5) {
            System.out.print("Введіть коректне значення: ");
            findMenuAction = DataInput.getInt();
        }
        switch (findMenuAction) {
            case 1:
                System.out.println("Введіть ім'я студента");
                String studentName = DataInput.getText();
                while (studentName == null || studentName.isEmpty()) {
                    System.out.print("Введіть коректне значення: ");
                    studentName = DataInput.getText();
                }
                System.out.println("Введіть прізвище студента");
                String studentSurname = DataInput.getText();
                while (studentSurname == null || studentSurname.isEmpty()) {
                    System.out.print("Введіть коректне значення: ");
                    studentSurname = DataInput.getText();
                }
                university.findMemberByName(studentName, studentSurname, "Student");
                findMenuAction();
                break;
            case 2:
                System.out.print("Введіть курс студентів: ");
                Integer course = DataInput.getInt();
                while (course == null || course < 1 || course > 6) {
                    System.out.print("Введіть коректне значення: ");
                    course = DataInput.getInt();
                }
                university.findStudentByCourse(course);
                findMenuAction();
                break;
            case 3:
                System.out.print("Введіть групу студентів: ");
                Integer group = DataInput.getInt();
                while (group == null || group < 1 || group > 20) {
                    System.out.print("Введіть коректне значення: ");
                    group = DataInput.getInt();
                }
                university.findStudentByGroup(group);
                findMenuAction();
                break;
            case 4:
                System.out.println("Введіть ім'я викладача");
                String teacherName = DataInput.getText();
                while (teacherName == null || teacherName.isEmpty()) {
                    System.out.print("Введіть коректне значення: ");
                    teacherName = DataInput.getText();
                }
                System.out.println("Введіть прізвище викладача");
                String teacherSurname = DataInput.getText();
                while (teacherSurname == null || teacherSurname.isEmpty()) {
                    System.out.print("Введіть коректне значення: ");
                    teacherSurname = DataInput.getText();
                }
                university.findMemberByName(teacherName, teacherSurname, "Teacher");
                findMenuAction();
                break;
            case 5:
                mainMenuAction();
                break;
        }
    }

    public static void main(String[] args) {
        University university = createNaUKMA();
        Main main = new Main(university);
        main.printHeader();
        main.mainMenuAction();
    }
}

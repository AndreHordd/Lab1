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
        System.out.println("[4] Взаємодіяти зі студентами/викладачами");
        System.out.println("[5] Вивести у консоль інформацію");
        System.out.println("[6] Знайти студента/викладача");
        System.out.println("[7] Вийти з програми");
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
                //todo
                //membersMenuAction();
                break;
            case 4:
                //todo
                informationMenuAction();
                break;
            case 5:
                //todo
                //findMenuAction();
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
        String facultyName;
        Faculty faculty;
        switch (departmentMenuAction) {
            case 1:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Немає факультетів для додавання кафедр");
                    departmentMenuAction();
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    facultyName = DataInput.getText();
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
                    faculty = university.getFaculty(facultyName);
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
                    departmentMenuAction();
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    facultyName = DataInput.getText();
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
                    faculty = university.getFaculty(facultyName);
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
                    departmentMenuAction();
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    faculty = university.getFaculty(facultyName);
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
        //todo
        printMembersMenu();
        System.out.print("Виберіть дію: ");
        Integer membersMenuAction = DataInput.getInt();
        while (membersMenuAction == null || membersMenuAction < 1 || membersMenuAction > 7) {
            System.out.print("Введіть коректне значення: ");
            membersMenuAction = DataInput.getInt();
        }
        switch (membersMenuAction) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
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
        //todo
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
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
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


    public static void main(String[] args) {
        University university = createNaUKMA();
        Main main = new Main(university);
        main.printHeader();
        main.mainMenuAction();
    }
}

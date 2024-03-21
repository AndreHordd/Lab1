/**
 * Main class
 */
public class Main {

    /**
     * University object
     */
    private University university;

    /**
     * Constructor for Main class
     *
     * @param university University object
     */
    public Main(University university) {
        this.university = university;
    }

    /**
     * Main method
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        University university = createNaUKMA();
        Main main = new Main(university);

        Faculty faculty1 = new Faculty("ФІ", 5);
        Department department1 = new Department("Кафедра програмування", 10);
        Department department2 = new Department("Кафедра математики", 5);

        Faculty faculty2 = new Faculty("ФЕН", 3);
        Department department3 = new Department("Кафедра економіки", 7);
        Department department4 = new Department("Кафедра менеджменту", 4);

        Faculty faculty3 = new Faculty("ФПН", 4);
        Department department5 = new Department("Кафедра цивільного права", 6);
        Department department6 = new Department("Кафедра кримінального права", 3);

        university.addFaculty(faculty1);
        faculty1.addDepartment(department1);
        faculty1.addDepartment(department2);

        university.addFaculty(faculty2);
        faculty2.addDepartment(department3);
        faculty2.addDepartment(department4);

        university.addFaculty(faculty3);
        faculty3.addDepartment(department5);
        faculty3.addDepartment(department6);

        Student student1 = new Student("Іван", "Іванов", 1, 1, faculty1, department1);
        Student student2 = new Student("Петро", "Петров", 1, 2, faculty1, department1);
        Student student3 = new Student("Аидор", "Сидоров", 1, 3, faculty1, department1);
        Student student4 = new Student("Микола", "Миколаєв", 4, 4, faculty1, department2);
        Student student5 = new Student("Олександр", "Олександров", 5, 5, faculty1, department2);
        Student student6 = new Student("Андрій", "Андрійов", 6, 6, faculty1, department2);

        Student student7 = new Student("Іван", "Іванов", 2, 1, faculty2, department3);
        Student student8 = new Student("Петро", "Петров", 1, 2, faculty2, department3);
        Student student9 = new Student("Сидор", "Сидоров", 3, 3, faculty2, department3);
        Student student10 = new Student("Микола", "Миколаєв", 4, 4, faculty2, department4);
        Student student11 = new Student("Олександр", "Олександров", 5, 5, faculty2, department4);
        Student student12 = new Student("Андрій", "Андрійов", 6, 6, faculty2, department4);

        Student student13 = new Student("Іван", "Іванов", 2, 1, faculty3, department5);
        Student student14 = new Student("Петро", "Петров", 1, 2, faculty3, department5);
        Student student15 = new Student("Сидор", "Сидоров", 3, 3, faculty3, department5);
        Student student16 = new Student("Микола", "Миколаєв", 4, 4, faculty3, department6);
        Student student17 = new Student("Олександр", "Олександров", 5, 5, faculty3, department6);
        Student student18 = new Student("Андрій", "Андрійов", 6, 6, faculty3, department6);

        Teacher teacher1 = new Teacher("Василь", "Васильов", faculty1, department1);
        Teacher teacher2 = new Teacher("Петро", "Петров", faculty1, department1);
        Teacher teacher3 = new Teacher("Сидор", "Сидоров", faculty1, department2);
        Teacher teacher4 = new Teacher("Микола", "Миколаєв", faculty1, department2);

        Teacher teacher5 = new Teacher("Василь", "Васильов", faculty2, department3);
        Teacher teacher6 = new Teacher("Петро", "Петров", faculty2, department3);
        Teacher teacher7 = new Teacher("Сидор", "Сидоров", faculty2, department4);
        Teacher teacher8 = new Teacher("Микола", "Миколаєв", faculty2, department4);

        Teacher teacher9 = new Teacher("Василь", "Васильов", faculty3, department5);
        Teacher teacher10 = new Teacher("Петро", "Петров", faculty3, department5);
        Teacher teacher11 = new Teacher("Сидор", "Сидоров", faculty3, department6);
        Teacher teacher12 = new Teacher("Микола", "Миколаєв", faculty3, department6);

        department1.addMember(student1);
        department1.addMember(student2);
        department1.addMember(student3);
        department2.addMember(student4);
        department2.addMember(student5);
        department2.addMember(student6);
        department1.addMember(teacher1);
        department1.addMember(teacher2);
        department2.addMember(teacher3);
        department2.addMember(teacher4);

        department3.addMember(student7);
        department3.addMember(student8);
        department3.addMember(student9);
        department4.addMember(student10);
        department4.addMember(student11);
        department4.addMember(student12);
        department3.addMember(teacher5);
        department3.addMember(teacher6);
        department4.addMember(teacher7);
        department4.addMember(teacher8);

        department5.addMember(student13);
        department5.addMember(student14);
        department5.addMember(student15);
        department6.addMember(student16);
        department6.addMember(student17);
        department6.addMember(student18);
        department5.addMember(teacher9);
        department5.addMember(teacher10);
        department6.addMember(teacher11);
        department6.addMember(teacher12);

        main.printHeader();
        main.mainMenuAction();
    }

    /**
     * Method to create NaUKMA university
     *
     * @return NaUKMA university
     */
    private static University createNaUKMA() {
        return new University("NaUKMA", 10);
    }

    /**
     * Method to print header
     */
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

    /**
     * Method to print main menu
     */
    private void printMainMenu() {
        System.out.println("\n=-=-=-=-=-=-=-=- Меню -=-=-=-=-=-=-=-=");
        System.out.println("[1] Взаємодіяти з факультетами");
        System.out.println("[2] Взаємодіяти з кафедрами");
        System.out.println("[3] Взаємодіяти зі студентами/викладачами");
        System.out.println("[4] Вивести у консоль інформацію");
        System.out.println("[5] Знайти студента/викладача");
        System.out.println("[6] Вийти з програми");
    }

    /**
     * Method to run main menu
     */
    private void mainMenuAction() {
        printMainMenu();
        Integer mainMenuAction = getChoice(1, 6);
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

    /**
     * Method to print faculty menu
     */
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

    /**
     * Method to run faculty menu
     */
    private void facultyMenuAction() {
        printFacultyMenu();
        Integer facultyMenuAction = getChoice(1, 4);
        switch (facultyMenuAction) {
            case 1:
                if (university.getAddedFacultiesCount() > 0) {
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
                    System.out.println("Спочатку створіть факультети");
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
                    System.out.println("Спочатку створіть факультети");
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

    /**
     * Method to print department menu
     */
    private void printDepartmentMenu() {
        System.out.println("\n=-=-=-=- Взаємодія з кафедрами -=-=-=-");
        System.out.println("[1] Додати кафедру");
        System.out.println("[2] Змінити назву кафедри");
        System.out.println("[3] Видалити кафедру");
        System.out.println("[4] Вийти у головне меню");
    }

    /**
     * Method to run department menu
     */
    private void departmentMenuAction() {
        printDepartmentMenu();
        Integer departmentMenuAction = getChoice(1, 4);
        switch (departmentMenuAction) {
            case 1:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Спочатку створіть факультети");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    if (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує");
                    } else {
                        Faculty faculty = university.getFaculty(facultyName);
                        if (faculty.getAddedDepartmentsCount() > 0) {
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
                }
                departmentMenuAction();
                break;
            case 2:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Спочатку створіть факультети");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    if (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує");
                    } else {
                        Faculty faculty = university.getFaculty(facultyName);
                        if (faculty.getAddedDepartmentsCount() <= 0) {
                            System.out.println("Спочатку створіть кафедри на цьому факультеті");
                        } else {
                            System.out.println("Наявні кафедри:");
                            faculty.printAllDepartments();
                            System.out.println("Введіть назву кафедри");
                            String departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                            if (faculty.getDepartment(departmentName) == null) {
                                System.out.println("Кафедра з такою назвою не існує");
                            } else {
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
                    }
                }
                departmentMenuAction();
                break;
            case 3:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Спочатку створіть факультети");
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
                    if (faculty == null) {
                        System.out.print("Факультет з такою назвою не існує");
                    } else {
                        if (faculty.getAddedDepartmentsCount() <= 0) {
                            System.out.println("Спочатку створіть кафедри на цьому факультеті");
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
                }
                departmentMenuAction();
                break;
            case 4:
                mainMenuAction();
        }
    }

    /**
     * Method to print members menu
     */
    private void printMembersMenu() {
        System.out.println("\n=-=-=- Взаємодія зі студентами/викладачами -=-=-=");
        System.out.println("[1] Додати студента/викладача");
        System.out.println("[2] Видалити студента/викладача");
        System.out.println("[3] Змінити інформацію про студента/викладача");
        System.out.println("[4] Вийти у головне меню");
    }

    /**
     * Method to run members menu
     */
    private void membersMenuAction() {
        printMembersMenu();
        Integer membersMenuAction = getChoice(1, 4);
        switch (membersMenuAction) {
            case 1:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Спочатку створіть факультети");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    if (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує");
                    } else {
                        Faculty faculty = university.getFaculty(facultyName);
                        if (faculty.getAddedDepartmentsCount() <= 0) {
                            System.out.println("Спочатку створіть кафедри на цьому факультеті");
                        } else {
                            System.out.println("Наявні кафедри:");
                            faculty.printAllDepartments();
                            System.out.println("Введіть назву кафедри");
                            String departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                            if (faculty.getDepartment(departmentName) == null) {
                                System.out.print("Кафедра з такою назвою не існує");
                            } else {
                                Department department = faculty.getDepartment(departmentName);
                                System.out.println("Це студент чи викладач? [1] - Студент [2] - Викладач");
                                Integer personType = getChoice(1, 2);
                                System.out.println("Введіть ім'я");
                                String name = DataInput.getText();
                                while (name == null || name.isEmpty()) {
                                    System.out.print("Введіть коректне значення: ");
                                    name = DataInput.getText();
                                }
                                System.out.println("Введіть прізвище");
                                String surname = DataInput.getText();
                                while (surname == null || surname.isEmpty()) {
                                    System.out.print("Введіть коректне значення: ");
                                    surname = DataInput.getText();
                                }
                                if (personType == 1) {
                                    System.out.println("Введіть курс");
                                    Integer course = DataInput.getInt();
                                    while (course == null || course < 1) {
                                        System.out.print("Введіть коректне значення: ");
                                        course = DataInput.getInt();
                                    }
                                    System.out.println("Введіть групу");
                                    Integer group = DataInput.getInt();
                                    while (group == null || group < 1) {
                                        System.out.print("Введіть коректне значення: ");
                                        group = DataInput.getInt();
                                    }
                                    department.addMember(new Student(name, surname, course, group, faculty, department));
                                    System.out.println("Студента успішно додано");
                                }
                                if (personType == 2) {
                                    department.addMember(new Teacher(name, surname, faculty, department));
                                    System.out.println("Викладача успішно додано");
                                }
                            }
                        }
                    }
                }
                membersMenuAction();
                break;
            case 2:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Спочатку створіть факультети");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    if (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує");
                    } else {
                        Faculty faculty = university.getFaculty(facultyName);
                        if (faculty.getAddedDepartmentsCount() <= 0) {
                            System.out.println("Спочатку створіть кафедри на цьому факультеті");
                        } else {
                            System.out.println("Наявні кафедри:");
                            faculty.printAllDepartments();
                            System.out.println("Введіть назву кафедри");
                            String departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                            if (faculty.getDepartment(departmentName) == null) {
                                System.out.print("Кафедра з такою назвою не існує");
                            } else {
                                Department department = faculty.getDepartment(departmentName);
                                System.out.println("Це студент чи викладач? [1] - Студент [2] - Викладач");
                                Integer personType = getChoice(1, 2);
                                System.out.println("Введіть ім'я");
                                String name = DataInput.getText();
                                while (name == null || name.isEmpty()) {
                                    System.out.print("Введіть коректне значення: ");
                                    name = DataInput.getText();
                                }
                                System.out.println("Введіть прізвище");
                                String surname = DataInput.getText();
                                while (surname == null || surname.isEmpty()) {
                                    System.out.print("Введіть коректне значення: ");
                                    surname = DataInput.getText();
                                }
                                if (personType == 1) {
                                    if (department.removeMember(name, surname, "Student")) {
                                        System.out.println("Студента успішно видалено");
                                    } else {
                                        System.out.println("Студента з такими даними не існує");
                                    }
                                }
                                if (personType == 2) {
                                    if (department.removeMember(name, surname, "Teacher")) {
                                        System.out.println("Викладача успішно видалено");
                                    } else {
                                        System.out.println("Викладача з такими даними не існує");
                                    }
                                }
                            }
                        }
                    }
                }
                membersMenuAction();
                break;
            case 3:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Спочатку створіть факультети");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    if (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує");
                    } else {
                        Faculty faculty = university.getFaculty(facultyName);
                        if (faculty.getAddedDepartmentsCount() <= 0) {
                            System.out.println("Спочатку створіть кафедри на цьому факультеті");
                        } else {
                            System.out.println("Наявні кафедри:");
                            faculty.printAllDepartments();
                            System.out.println("Введіть назву кафедри");
                            String departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                            if (faculty.getDepartment(departmentName) == null) {
                                System.out.print("Кафедра з такою назвою не існує");
                            } else {
                                Department department = faculty.getDepartment(departmentName);
                                System.out.println("Це студент чи викладач? [1] - Студент [2] - Викладач");
                                Integer personType = getChoice(1, 2);
                                System.out.println("Введіть ім'я");
                                String name = DataInput.getText();
                                while (name == null || name.isEmpty()) {
                                    System.out.print("Введіть коректне значення: ");
                                    name = DataInput.getText();
                                }
                                System.out.println("Введіть прізвище");
                                String surname = DataInput.getText();
                                while (surname == null || surname.isEmpty()) {
                                    System.out.print("Введіть коректне значення: ");
                                    surname = DataInput.getText();
                                }
                                if (personType == 1) {
                                    if (department.getMember(name, surname, "Student") == null) {
                                        System.out.println("Студента з такими даними не існує");
                                    } else {
                                        System.out.println("Введіть нове ім'я");
                                        String newName = DataInput.getText();
                                        while (newName == null || newName.isEmpty()) {
                                            System.out.print("Введіть коректне значення: ");
                                            newName = DataInput.getText();
                                        }
                                        System.out.println("Введіть нове прізвище");
                                        String newSurname = DataInput.getText();
                                        while (newSurname == null || newSurname.isEmpty()) {
                                            System.out.print("Введіть коректне значення: ");
                                            newSurname = DataInput.getText();
                                        }
                                        System.out.println("Введіть новий курс");
                                        Integer course = DataInput.getInt();
                                        while (course == null || course < 1) {
                                            System.out.print("Введіть коректне значення: ");
                                            course = DataInput.getInt();
                                        }
                                        System.out.println("Введіть нову групу");
                                        Integer group = DataInput.getInt();
                                        while (group == null || group < 1) {
                                            System.out.print("Введіть коректне значення: ");
                                            group = DataInput.getInt();
                                        }
                                        department.changeMember(department.getMember(name, surname, "Student"), new Student(newName, newSurname, course, group, faculty, department));
                                    }
                                }
                                if (personType == 2) {
                                    if (department.getMember(name, surname, "Teacher") == null) {
                                        System.out.println("Викладача з такими даними не існує");
                                    } else {
                                        System.out.println("Введіть нове ім'я");
                                        String newName = DataInput.getText();
                                        while (newName == null || newName.isEmpty()) {
                                            System.out.print("Введіть коректне значення: ");
                                            newName = DataInput.getText();
                                        }
                                        System.out.println("Введіть нове прізвище");
                                        String newSurname = DataInput.getText();
                                        while (newSurname == null || newSurname.isEmpty()) {
                                            System.out.print("Введіть коректне значення: ");
                                            newSurname = DataInput.getText();
                                        }
                                        department.changeMember(department.getMember(name, surname, "Teacher"), new Teacher(newName, newSurname, faculty, department));
                                    }
                                }
                            }
                        }
                    }
                }
                membersMenuAction();
                break;
            case 4:
                mainMenuAction();
                break;
        }
    }

    /**
     * Method to print information menu
     */
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

    /**
     * Method to run information menu
     */
    private void informationMenuAction() {
        printInformationMenu();
        Integer informationMenuAction = getChoice(1, 9);
        switch (informationMenuAction) {
            case 1:
                university.printAllStudentsByCourse();
                informationMenuAction();
                break;
            case 2:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Спочатку створіть факультети");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    if (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує");
                    } else {
                        university.printAllStudentsAlphabetically(university.getFaculty(facultyName).getName());
                    }
                }
                informationMenuAction();
                break;
            case 3:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Спочатку створіть факультети");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    if (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує");
                    } else {
                        university.printAllTeachersAlphabetically(university.getFaculty(facultyName).getName());
                    }
                }
                informationMenuAction();
                break;
            case 4:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Спочатку створіть факультети");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    if (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує");
                    } else {
                        Faculty faculty = university.getFaculty(facultyName);
                        if (faculty.getAddedDepartmentsCount() <= 0) {
                            System.out.println("Спочатку створіть кафедри на цьому факультеті");
                        } else {
                            System.out.println("Наявні кафедри:");
                            faculty.printAllDepartments();
                            System.out.println("Введіть назву кафедри");
                            String departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                            if (faculty.getDepartment(departmentName) == null) {
                                System.out.print("Кафедра з такою назвою не існує");
                            } else {
                                faculty.printAllStudentsByCourse(faculty.getDepartment(departmentName).getName());
                            }
                        }
                    }
                }
                informationMenuAction();
                break;
            case 5:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Спочатку створіть факультети");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    if (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує");
                    } else {
                        Faculty faculty = university.getFaculty(facultyName);
                        if (faculty.getAddedDepartmentsCount() <= 0) {
                            System.out.println("Спочатку створіть кафедри на цьому факультеті");
                        } else {
                            System.out.println("Наявні кафедри:");
                            faculty.printAllDepartments();
                            System.out.println("Введіть назву кафедри");
                            String departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                            if (faculty.getDepartment(departmentName) == null) {
                                System.out.print("Кафедра з такою назвою не існує");
                            } else {
                                faculty.printAllStudentsAlphabetically(faculty.getDepartment(departmentName).getName());
                            }
                        }
                    }
                }
                informationMenuAction();
                break;
            case 6:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Спочатку створіть факультети");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    if (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує");
                    } else {
                        Faculty faculty = university.getFaculty(facultyName);
                        if (faculty.getAddedDepartmentsCount() <= 0) {
                            System.out.println("Спочатку створіть кафедри на цьому факультеті");
                        } else {
                            System.out.println("Наявні кафедри:");
                            faculty.printAllDepartments();
                            System.out.println("Введіть назву кафедри");
                            String departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                            if (faculty.getDepartment(departmentName) == null) {
                                System.out.print("Кафедра з такою назвою не існує");
                            } else {
                                faculty.printAllTeachersAlphabetically(faculty.getDepartment(departmentName).getName());
                            }
                        }
                    }
                }
                informationMenuAction();
                break;
            case 7:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Спочатку створіть факультети");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    if (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує");
                    } else {
                        Faculty faculty = university.getFaculty(facultyName);
                        if (faculty.getAddedDepartmentsCount() <= 0) {
                            System.out.println("Спочатку створіть кафедри на цьому факультеті");
                        } else {
                            System.out.println("Наявні кафедри:");
                            faculty.printAllDepartments();
                            System.out.println("Введіть назву кафедри");
                            String departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                            if (faculty.getDepartment(departmentName) == null) {
                                System.out.print("Кафедра з такою назвою не існує");
                            } else {
                                System.out.print("Введіть курс студентів: ");
                                Integer course = DataInput.getInt();
                                while (course == null || course < 1 || course > 6) {
                                    System.out.print("Введіть коректне значення: ");
                                    course = DataInput.getInt();
                                }
                                faculty.printAllStudentsOfCourse(faculty.getDepartment(departmentName).getName(), course);
                            }
                        }
                    }
                }
                informationMenuAction();
                break;
            case 8:
                if (university.getAddedFacultiesCount() <= 0) {
                    System.out.println("Спочатку створіть факультети");
                } else {
                    System.out.println("Наявні факультети:");
                    university.printAllFaculties();
                    System.out.println("Введіть назву факультету");
                    String facultyName = DataInput.getText();
                    while (facultyName == null || facultyName.isEmpty()) {
                        System.out.print("Введіть коректне значення: ");
                        facultyName = DataInput.getText();
                    }
                    if (university.getFaculty(facultyName) == null) {
                        System.out.print("Факультет з такою назвою не існує");
                    } else {
                        Faculty faculty = university.getFaculty(facultyName);
                        if (faculty.getAddedDepartmentsCount() <= 0) {
                            System.out.println("Спочатку створіть кафедри на цьому факультеті");
                        } else {
                            System.out.println("Наявні кафедри:");
                            faculty.printAllDepartments();
                            System.out.println("Введіть назву кафедри");
                            String departmentName = DataInput.getText();
                            while (departmentName == null || departmentName.isEmpty()) {
                                System.out.print("Введіть коректне значення: ");
                                departmentName = DataInput.getText();
                            }
                            if (faculty.getDepartment(departmentName) == null) {
                                System.out.print("Кафедра з такою назвою не існує");
                            } else {
                                System.out.print("Введіть курс студентів: ");
                                Integer course = DataInput.getInt();
                                while (course == null || course < 1 || course > 6) {
                                    System.out.print("Введіть коректне значення: ");
                                    course = DataInput.getInt();
                                }
                                faculty.printAllStudentsOfCourseAlphabetically(faculty.getDepartment(departmentName).getName(), course);
                            }
                        }
                    }
                }
                informationMenuAction();
                break;
            case 9:
                mainMenuAction();
                break;
        }
    }

    /**
     * Method to print find menu
     */
    private void printFindMenu() {
        System.out.println("\n=-=-=- Пошук студента/викладача -=-=-=");
        System.out.println("[1] Знайти студента за ім'ям та прізвищем");
        System.out.println("[2] Знайти студента за курсом");
        System.out.println("[3] Знайти студента за групою");
        System.out.println("[4] Знайти викладача за ім'ям та прізвищем");
        System.out.println("[5] Вийти у головне меню");
    }

    /**
     * Method to run find menu
     */
    private void findMenuAction() {
        printFindMenu();
        Integer findMenuAction = getChoice(1, 5);
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

    /**
     * Method to get choice
     *
     * @param min min value
     * @param max max value
     * @return choice
     */
    private Integer getChoice(int min, int max) {
        System.out.print("Виберіть дію: ");
        Integer menuAction = DataInput.getInt();
        while (menuAction == null || menuAction < min || menuAction > max) {
            System.out.print("Введіть коректне значення: ");
            menuAction = DataInput.getInt();
        }
        return menuAction;
    }
}

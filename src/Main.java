public class Main {
    public static void main(String[] args) {
        University university = new University("NaUKMA", 10);
        Faculty faculty1 = new Faculty("Faculty of Computer Science", 10);
        university.addFaculty(faculty1);
        Department department2 = new Department("Department of Computer Science", 10);
        Department department1 = new Department("Department of Software Engineering", 10);
        faculty1.addDepartment(department1);
        faculty1.addDepartment(department2);

        department1.addMember(new Teacher("Ivan", "Ivanov", faculty1, department1));
        department1.addMember(new Teacher("Petro", "Petrov", faculty1, department1));

        department2.addMember(new Teacher("Vasyl", "Vasyliev", faculty1, department2));


        department1.addMember(new Student("Olena", "Olenova", 1, 1, faculty1, department1));
        department1.addMember(new Student("Oleg", "Olegov", 1, 1, faculty1, department1));
        department1.addMember(new Student("Iryna", "Irynaova", 2, 1, faculty1, department1));

        department2.addMember(new Student("Ivan", "Ivanov", 1, 1, faculty1, department2));
        department2.addMember(new Student("Petro", "Petrov", 1, 1, faculty1, department2));
        department2.addMember(new Student("Vasyl", "Vasyliev", 1, 1, faculty1, department2));

        faculty1.findStudentByCourse(1);
    }
}

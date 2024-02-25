import java.util.Arrays;

public class Teacher extends Person {
    private String academicPosition;
    private String[] subjects;
    private int subjectCount;

    public Teacher(String name, String surname, String academicPosition, int initialSubjectCapacity) {
        super(name, surname, "Teacher"); // Виклик конструктора базового класу з типом "Teacher"
        this.academicPosition = academicPosition;
        this.subjects = new String[initialSubjectCapacity];
        this.subjectCount = 0;
    }

    // Додавання предмету до списку предметів, які викладає викладач
    public void addSubject(String subject) {
        if (subjectCount == subjects.length) {
            subjects = Arrays.copyOf(subjects, subjects.length * 2);
        }
        subjects[subjectCount++] = subject;
    }

    // Видалення предмету зі списку
    public boolean removeSubject(String subject) {
        for (int i = 0; i < subjectCount; i++) {
            if (subjects[i].equals(subject)) {
                int numMoved = subjectCount - i - 1;
                if (numMoved > 0) {
                    System.arraycopy(subjects, i + 1, subjects, i, numMoved);
                }
                subjects[--subjectCount] = null; // Очищення для GC
                return true;
            }
        }
        return false;
    }

    // Гетери та сетери
    public String getAcademicPosition() {
        return academicPosition;
    }

    public void setAcademicPosition(String academicPosition) {
        this.academicPosition = academicPosition;
    }

    public String[] getSubjects() {
        return Arrays.copyOf(subjects, subjectCount);
    }

    @Override
    public String toString() {
        return "Викладач{" +
                "ім'я='" + name + '\'' +
                ", прізвище='" + surname + '\'' +
                ", академічна посада='" + academicPosition + '\'' +
                ", предмети=" + Arrays.toString(getSubjects()) +
                '}';
    }
}

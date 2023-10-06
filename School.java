import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Student extends Person {
    int id;
    int age;
    String lastName;
    double gpa;

    public Student(String name, int id, int age, String lastName, double gpa) {
        super(name);
        this.id = id;
        this.age = age;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", lastName='" + lastName + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}

public class School {
    private List<Student> studentRoster = new ArrayList<>();
    private List<Person> personRoster = new ArrayList<>();

    // Add students to the student roster
    public void addStudent(Student student) {
        studentRoster.add(student);
        personRoster.add(student); // Since Student is a subclass of Person, it can be added to Person List
    }

    // Sort students by ID
    public void sortStudentsById() {
        Collections.sort(studentRoster, Comparator.comparingInt(student -> student.id));
        Collections.sort(personRoster, Comparator.comparingInt(student -> ((Student) student).id));
    }

    // Sort students by Age
    public void sortStudentsByAge() {
        Collections.sort(studentRoster, Comparator.comparingInt(student -> student.age));
        Collections.sort(personRoster, Comparator.comparingInt(student -> ((Student) student).age));
    }

    // Sort students by Last Name
    public void sortStudentsByLastName() {
        Collections.sort(studentRoster, Comparator.comparing(student -> student.lastName));
        Collections.sort(personRoster, Comparator.comparing(student -> ((Student) student).lastName));
    }

    // Sort students by GPA
    public void sortStudentsByGPA() {
        Collections.sort(studentRoster, Comparator.comparingDouble(student -> student.gpa));
        Collections.sort(personRoster, Comparator.comparingDouble(student -> ((Student) student).gpa));
    }

    @Override
    public String toString() {
        return "Student Roster: " + studentRoster + "\nPerson Roster: " + personRoster;
    }

    public static void main(String[] args) {
        School school = new School();
        school.addStudent(new Student("Sejal Deopura", 101, 17, "Deopura", 3.8));
        school.addStudent(new Student("Meera Pandya", 102, 16, "Pandya", 3.9));
        school.addStudent(new Student("Kaaviya Modi", 103, 18, "Modi", 3.7));
        school.addStudent(new Student("Pritika Parikh", 104, 17, "Parikh", 4.0));
        school.addStudent(new Student("Varun Shah", 105, 16, "Shah", 3.6));

        // Sort and print by ID
        school.sortStudentsById();
        System.out.println("Sorted by ID:\n" + school);

        // Sort and print by Age
        school.sortStudentsByAge();
        System.out.println("Sorted by Age:\n" + school);

        // Sort and print by Last Name
        school.sortStudentsByLastName();
        System.out.println("Sorted by Last Name:\n" + school);

        // Sort and print by GPA
        school.sortStudentsByGPA();
        System.out.println("Sorted by GPA:\n" + school);
    }

}
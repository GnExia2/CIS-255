import java.util.Objects;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private boolean tuitionPaid;

    public Student(int id, String firstName, String lastName, boolean tuitionPaid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tuitionPaid = tuitionPaid;
    }

    //@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        // Check if all relevant fields are equal (ignore case for firstName and lastName)
        return id == student.id &&
                tuitionPaid == student.tuitionPaid &&
                Objects.equals(firstName.toLowerCase(), student.firstName.toLowerCase()) &&
                Objects.equals(lastName.toLowerCase(), student.lastName.toLowerCase());
    }

    //@Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, tuitionPaid);
    }

    //@Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tuitionPaid=" + tuitionPaid +
                '}';
    }

    public boolean isTuitionPaid() {
        return tuitionPaid;
    }
}
import java.util.Objects;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private boolean tuitionPaid;

    public Student(int id, String firstName, String lastName, boolean tuitionPaid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tuitionPaid = tuitionPaid;
    }

    //@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        // Check if all relevant fields are equal (ignore case for firstName and lastName)
        return id == student.id &&
                tuitionPaid == student.tuitionPaid &&
                Objects.equals(firstName.toLowerCase(), student.firstName.toLowerCase()) &&
                Objects.equals(lastName.toLowerCase(), student.lastName.toLowerCase());
    }

    //@Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, tuitionPaid);
    }

    //@Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tuitionPaid=" + tuitionPaid +
                '}';
    }

    public boolean isTuitionPaid() {
        return tuitionPaid;
    }
}

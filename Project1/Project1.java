
public class CourseTester {

    public static void main(String[] args) {

        Student[] studentsInSchool = new Student[15];
        studentsInSchool[0] = new Student("Adam", "Ant", "S925", true);
        studentsInSchool[1] = new Student("Bob", "Barker", "S713", false);
        studentsInSchool[2] = new Student("Chevy", "Chase", "S512", true);
        studentsInSchool[3] = new Student("Doris", "Day", "S513", true);
        studentsInSchool[4] = new Student("Emilio", "Estevez", "S516", true);
        studentsInSchool[5] = new Student("Farrah", "Fawcet", "S956", true);
        studentsInSchool[6] = new Student("Greta", "Garbo", "S419", true);
        studentsInSchool[7] = new Student("Helen", "Hunt", "S281", true);
        studentsInSchool[8] = new Student("Jack", "Johnson", "S790", true);
        studentsInSchool[9] = new Student("Kim", "Kardashian", "S336", true);
        studentsInSchool[10] = new Student("Martina", "McBride", "S156", true);
        studentsInSchool[11] = new Student("Renne", "Russo", "S219", true);
        studentsInSchool[12] = new Student("Susan", "Serandon", "S472", true);
        studentsInSchool[13] = new Student("Vince", "Vaughn", "S892", true);
        studentsInSchool[14] = new Student("Walt", "Whitman", "S901", true);

        Course course = new Course("Media Studies", 5);
        //CourseAL course = new CourseAL("Media Studies", 5);

        /* note: to test the extra credit, replace the line above with the line below.
         * the rest of the program should run exactly the same.
         *
         *
         */

        System.out.println(course + "\n");
        System.out.println("*****TESTING ADDS");
        for (Student student : studentsInSchool) {
            boolean added = course.addStudent(student);
            System.out.println(student + (added ? " added successfully" : " not added"));
        }
        System.out.println("\n" + course + "\n");

        Student studentToAdd = studentsInSchool[2];
        boolean added = course.addStudent(studentToAdd);
        System.out.println(studentToAdd + (added ? " added successfully" : " not added"));
        System.out.println("\n" + course + "\n");

        studentToAdd = studentsInSchool[7];
        added = course.addStudent(studentToAdd);
        System.out.println(studentToAdd + (added ? " added successfully" : " not added"));
        System.out.println("\n" + course + "\n");

        System.out.println("*****TESTING DROPS");
        Student studentToDrop = studentsInSchool[2];
        boolean dropped = course.dropStudent(studentToDrop);
        System.out.println(studentToDrop + (dropped ? " dropped successfully" : " not dropped"));
        System.out.println("\n" + course + "\n");

        studentToDrop = studentsInSchool[14];
        dropped = course.dropStudent(studentToDrop);
        System.out.println(studentToDrop + (dropped ? " dropped successfully" : " not dropped"));
        System.out.println("\n" + course + "\n");

        studentToDrop = studentsInSchool[8];
        dropped = course.dropStudent(studentToDrop);
        System.out.println(studentToDrop + (dropped ? " dropped successfully" : " not dropped"));
        System.out.println("\n" + course + "\n");

        studentToDrop = studentsInSchool[0];
        dropped = course.dropStudent(studentToDrop);
        System.out.println(studentToDrop + (dropped ? " dropped successfully" : " not dropped"));
        System.out.println("\n" + course + "\n");

    }
}


public class Course {
   private String courseName;
   private Student[] students;
   private Student[] waitListStudents;
   private int maxStudents;
   private int numStudents;

   public Course(String courseName, int maxStudents) {
      this.courseName = courseName;
      this.maxStudents = maxStudents;
      this.students = new Student[maxStudents];
      this.numStudents = 0;
   }

   public boolean addStudent(Student student) {
      if (numStudents < maxStudents) {
         students[numStudents] = student;
         numStudents++;
         return true;
      }
      return false;
   }

   public boolean dropStudent(Student student) {
      for (int i = 0; i < numStudents; i++) {
         if (students[i].equals(student)) {
            // Shift remaining students to fill the gap
            for (int j = i; j < numStudents - 1; j++) {
               students[j] = students[j + 1];
            }
            students[numStudents - 1] = null;
            numStudents--;
            return true;
         }
      }
      return false;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(courseName).append("\n");
      sb.append(numStudents).append(" Enrolled (maximum allowed 5) ").append("\n");
      sb.append(numStudents).append(" on waitlist (maximum allowed 5) ").append("\n");
      for (int i = 0; i < numStudents; i++) {
         sb.append(students[i].toString()).append("\n");
      }
      return sb.toString();
   }
}

public class Student {

	private String firstName, lastName, id;
	private boolean tuitionPaid;

	public Student(String firstName, String lastName, String id, boolean tuitionPaid) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.tuitionPaid = tuitionPaid;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public boolean isTuitionPaid() {
		return tuitionPaid;
	}

	public void setTuitionPaid(boolean tuitionPaid) {
		this.tuitionPaid = tuitionPaid;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " (" + id + ")";
	}


}

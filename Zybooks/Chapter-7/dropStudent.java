import java.util.ArrayList;

public class Course {

	private ArrayList<Student> roster; //collection of Student objects

	public Course() {
		roster = new ArrayList<Student>();
	}

   public void dropStudent(String last) {
      for (int i = 0; i < roster.size(); i++) {
         Student student = roster.get(i);
         if (student.getLast().equals(last)) {
            roster.remove(i);
            break; // exit the loop after removing the student
         }
      }
   }
   public void addStudent(Student s) {
      roster.add(s);
   }

   public int countStudents() {
      return roster.size();
   }
}

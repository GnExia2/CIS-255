public class Student {
  private String name;
  private double gpa;

  public Student() {
    name = "Louie";
    gpa = 1.0;
  }

  public Student(String name, double gpa) {
    this.name = name;
    this.gpa = gpa;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getGPA() {
    return gpa;
  }`

  public void setGPA(double gpa) {
  this.gpa = gpa;
  }
}

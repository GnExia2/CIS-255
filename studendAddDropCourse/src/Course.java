import java.util.Arrays;

public class Course {
    private String courseName;
    private Student[] roster;
    private Student[] waitlist;
    private int maxRosterSize;
    private int maxWaitlistSize;
    private int rosterSize;
    private int waitlistSize;

    public Course(String courseName, int maxRosterSize, int maxWaitlistSize) {
        this.courseName = courseName;
        this.roster = new Student[maxRosterSize];
        this.waitlist = new Student[maxWaitlistSize];
        this.maxRosterSize = maxRosterSize;
        this.maxWaitlistSize = maxWaitlistSize;
        this.rosterSize = 0;
        this.waitlistSize = 0;
    }

    public Student[] getRoster() {
        return roster;
    }

    public Student[] getWaitlist() {
        return waitlist;
    }

    public int getMaxRosterSize() {
        return maxRosterSize;
    }

    public int getMaxWaitlistSize() {
        return maxWaitlistSize;
    }

    //@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course: ").append(courseName).append("\n");
        sb.append("Roster: ").append(rosterSize).append("/").append(maxRosterSize).append("\n");
        for (int i = 0; i < rosterSize; i++) {
            sb.append(roster[i]).append("\n");
        }
        sb.append("Waitlist: ").append(waitlistSize).append("/").append(maxWaitlistSize).append("\n");
        for (int i = 0; i < waitlistSize; i++) {
            sb.append(waitlist[i]).append("\n");
        }
        return sb.toString();
    }

    public boolean addStudent(Student student) {
        if (student == null || !student.isTuitionPaid()) {
            return false;
        }

        if (rosterSize < maxRosterSize && !containsStudent(roster, student)) {
            roster[rosterSize++] = student;
            return true;
        } else if (waitlistSize < maxWaitlistSize && !containsStudent(waitlist, student)) {
            waitlist[waitlistSize++] = student;
            return true;
        }

        return false;
    }

    public boolean dropStudent(Student student) {
        if (student == null) {
            return false;
        }

        if (removeFromList(roster, student)) {
            if (waitlistSize > 0) {
                roster[rosterSize++] = waitlist[0];
                shiftListLeft(waitlist);
                waitlistSize--;
            }
            return true;
        } else if (removeFromList(waitlist, student)) {
            return true;
        }

        return false;
    }

    private boolean removeFromList(Student[] list, Student student) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].equals(student)) {
                list[i] = null;
                shiftListLeft(list);
                return true;
            }
        }
        return false;
    }

    private void shiftListLeft(Student[] list) {
        int i = 0;
        while (i < list.length - 1 && list[i] != null) {
            list[i] = list[i + 1];
            i++;
        }
    }

    private boolean containsStudent(Student[] list, Student student) {
        for (Student s : list) {
            if (s != null && s.equals(student)) {
                return true;
            }
        }
        return false;
    }
}

import java.util.*;

public class Course {
    private String courseName;
    private Student[] roster;
    private Integer classSize;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Student[] getRoster() {
        return roster;
    }

    public void setRoster(Student[] roster) {
        this.roster = roster;
    }

    public Integer getClassSize() {
        return classSize;
    }

    public void setClassSize(Integer classSize) {
        this.classSize = classSize;
    }

    //    private List<Student> roster = new ArrayList<Student>();

//    public Course(List<Student> roster) {
//        this.roster.addAll(roster);
//        courseName = roster.getFirst().getCourse();
//    }
//
//    public List<Student> getRoster() {
//        return roster;
//    }
//
//    public void setRoster(List<Student> roster) {
//        this.roster = roster;
//    }
//
//    public void addToCourse(Student student){
//        roster.add(student);
//    }
}

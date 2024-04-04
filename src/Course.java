import java.util.*;

public class Course {
    private String courseName;
    private Student[] roster;
    private Integer courseSize;

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

    public Integer getCourseSize() {
        return courseSize;
    }

    public void setCourseSize(Integer courseSize) {
        this.courseSize = courseSize;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName: '" + courseName + '\'' +
                ", courseSize: " + courseSize +
                ", roster: " + Arrays.toString(roster) +
                '}';
    }

    //sorts the course roster by grade
    public void gradeSort(){
        Arrays.sort(roster, Comparator.comparingDouble(Student::getGrade).reversed());
    }
}

public class Student {
    private Integer studentID;
    private String studentName;
    private String course;
    private Double grade;

    public Student(Integer studentID, String studentName, String course, Double grade) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.course = course;
        this.grade = grade;
    }

    public Student() {
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student {" +
                "studentID: " + studentID +
                ", studentName: '" + studentName + '\'' +
                ", course: '" + course + '\'' +
                ", grade: " + grade +
                '}';
    }

//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
}

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

    @Override
    public String toString() {
        return "Student{" +
                "studentID= " + studentID +
                ", studentName= '" + studentName + '\'' +
                ", course= '" + course + '\'' +
                ", grade= " + grade +
                '}';
    }
}

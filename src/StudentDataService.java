//  4/4/24
//  Zack Laine
//  Assignment 4

public class StudentDataService {
    private Student[] allStudents;
    private Integer numCourses = 3; //courses is an inaccurate descriptor, these are like...educational tracks
    private Integer studentCount;
    private Course[] allCourses = new Course[3];


    public Student[] getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(Student[] allStudents) {
        this.allStudents = allStudents;
    }

    public void setStudent(Student student, int i) {
        this.allStudents[i] = student;
    }

    public Integer getNumCourses() {
        return numCourses;
    }

    public void setNumCourses(Integer numCourses) {
        this.numCourses = numCourses;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public Course[] getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(Course[] allCourses) {
        this.allCourses = allCourses;
    }

    StudentDataService(){
        allCourses[0] = new Course();
        allCourses[1] = new Course();
        allCourses[2] = new Course();

        allCourses[0].setCourseName("COMPSCI");
        allCourses[1].setCourseName("STAT");
        allCourses[2].setCourseName("APMTH");
    }

//    Figures out the size of the array that'll be needed for each course
//    and instantiates it
    private void createCourses(){
        Integer compSciCount = 0;
        Integer apMathCount = 0;
        Integer statCount = 0;
        for (Student student : allStudents){
            if (student != null) {
                if (student.getCourse().contains("COMPSCI")) {
                    compSciCount++;
                } else if (student.getCourse().contains("APMTH")) {
                    apMathCount++;
                } else if (student.getCourse().contains("STAT")) {
                    statCount++;
                } else {
                    System.out.println("Student in unknown course track.");
                }
            }
        }

        instantiateCourseArray(allCourses[0], compSciCount);
        instantiateCourseArray(allCourses[1], apMathCount);
        instantiateCourseArray(allCourses[2], statCount);
    }

    private void instantiateCourseArray(Course course, Integer count){
        course.setRoster(new Student[count]);
        course.setCourseSize(count);
    }

    private void populateCourses(){
        Integer compSciCount = 0;
        Integer apMathCount = 0;
        Integer statCount = 0;

        for (Student student : allStudents){
            if (student != null) {
                if (student.getCourse().contains("COMPSCI")) {
                    allCourses[0].getRoster()[compSciCount] = student;
                    compSciCount++;
                } else if (student.getCourse().contains("APMTH")) {
                    allCourses[1].getRoster()[apMathCount] = student;
                    apMathCount++;
                } else if (student.getCourse().contains("STAT")) {
                    allCourses[2].getRoster()[statCount] = student;
                    statCount++;
                } else {
                    System.out.println("Student in unknown course track.");
                }
            }
        }
    }

    void organize(){
        FileService fileService = new FileService();
        studentCount = fileService.countStudents();
        fileService.readFile(this);
        createCourses();
        populateCourses();

        for(Course course : allCourses){
            course.gradeSort();
        }
        fileService.writeFile(this);
    }
}

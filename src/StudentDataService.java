import java.util.*;
import java.io.*;

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

    //refactor into FileService with writeFile(String[])
//    Student[] readFile(){
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE))){
//            allStudents = new Student[studentCount];
//            Student newStudent;
//            String[] lineData;
//
//            header = bufferedReader.readLine();
//
//            for(int i = 1; i < studentCount; i++){
//                newStudent = new Student();
//                lineData = bufferedReader.readLine().split(",|\\r\\n|\\n");
//                newStudent.setStudentID(Integer.parseInt(lineData[0]));
//                newStudent.setStudentName(lineData[1]);
//                newStudent.setCourse(lineData[2]);
//                newStudent.setGrade(Double.parseDouble(lineData[3]));
//                System.out.println(newStudent.toString());
//
//                allStudents[i] = newStudent;
//            }
////            I think this delimiter *should* work for both Windows and Unix csv
////            but have only tested it on Windows
////            scanner.useDelimiter(",|\\r\\n|\\n");
////            scanner.nextLine();
////            Student newStudent;
////
////            while(scanner.hasNext()){
////                newStudent = new Student();
////                newStudent.setStudentID(Integer.parseInt(scanner.next()));
////                newStudent.setStudentName(scanner.next());
////                newStudent.setCourse(scanner.next());
////                newStudent.setGrade(Double.parseDouble(scanner.next()));
////                System.out.println(newStudent.toString());
////
////                allStudents.add(newStudent);
////            }
//        }
//        catch(IOException e){
//            System.out.println("File not found: " + e.getMessage());
//        }
//        return allStudents;
//    }

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
        System.out.println("CS: " +compSciCount + " AP: " + apMathCount + " STAT: " + statCount);
        allCourses[0].setRoster(new Student[compSciCount]);
        allCourses[0].setCourseSize(compSciCount);
        allCourses[1].setRoster(new Student[apMathCount]);
        allCourses[1].setCourseSize(apMathCount);
        allCourses[2].setRoster(new Student[statCount]);
        allCourses[2].setCourseSize(statCount);
    }

//    Puts the relevant students into their course roster
    private void populateCourses(){
        Integer compSciCount = 0;
        Integer apMathCount = 0;
        Integer statCount = 0;

//        checking if the final student in each class has been added
//        while(allCourses[0].getRoster()[allCourses[0].getClassSize()-1] == null &&
//                allCourses[1].getRoster()[allCourses[1].getClassSize()-1] == null &&
//                allCourses[2].getRoster()[allCourses[2].getClassSize()-1] == null) {
//        I decided that was stupid and counters would be simpler
//        while(compSciCount < allCourses[0].getCourseSize() &&
//                apMathCount < allCourses[1].getCourseSize() &&
//                statCount < allCourses[2].getCourseSize()){
//        I should use a for loop what am I doing
        for (Student student : allStudents){
            if (student != null) {
                if (student.getCourse().contains("COMPSCI")) {
                    allCourses[0].getRoster()[compSciCount] = student;
                    System.out.println("CS student added to course.");
                    compSciCount++;
                } else if (student.getCourse().contains("APMTH")) {
                    allCourses[1].getRoster()[apMathCount] = student;
                    System.out.println("AP MATH student added to course.");
                    apMathCount++;
                } else if (student.getCourse().contains("STAT")) {
                    allCourses[2].getRoster()[statCount] = student;
                    System.out.println("STAT student added to course.");
                    statCount++;
                } else {
                    System.out.println("Student in unknown course track.");
                }
            }
        }
//        }
        for (Course course: allCourses){
            System.out.println(course.toString());
        }
    }

//    This counts the actual separate courses, not the tracks
//            so it's not actually relevant oops
//    private void countCourses(){
//        numCourses = 0;
//        String courseNames = "";
//        for(int i = 0; i < studentCount; i ++) {
//            if (allStudents[i] != null) {
////            if the name of the course isn't in the string of course names
////            it gets added and the course count goes up
//                if (!courseNames.contains(allStudents[i].getCourse())) {
//                    numCourses++;
//                    courseNames += ", " + allStudents[i].getCourse();
//                }
//            }
//        }
//        System.out.println(numCourses + " course rosters.");
//    }

    void organize(){
        FileService fileService = new FileService();
        studentCount = fileService.countStudents();
        fileService.readFile(this);
        createCourses();
        populateCourses();
    }

//    void deleteFiles(String fileNames){
//
//    }
}

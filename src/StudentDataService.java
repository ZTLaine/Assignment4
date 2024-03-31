import java.util.*;
import java.io.*;

public class StudentDataService {
    private List<Student> allStudents = new ArrayList<Student>();
    private List<Course> allCourses = new ArrayList<Course>();
    private String outputFiles;
    private Integer numCourses = 3; //hardcoded for now, add in assigning based on unique course IDs?
    private String INPUT_FILE = "student-master-list.csv";
    Integer studentCount;

    List<Student> readFile(){
        try (Scanner scanner = new Scanner(new File(INPUT_FILE))){
//            I think this delimiter *should* work for both Windows and Unix csv
//            but have only tested it on Windows
            scanner.useDelimiter(",|\\r\\n|\\n");
            scanner.nextLine();
            Student newStudent;

            while(scanner.hasNext()){
                newStudent = new Student();
                newStudent.setStudentID(Integer.parseInt(scanner.next()));
                newStudent.setStudentName(scanner.next());
                newStudent.setCourse(scanner.next());
                newStudent.setGrade(Double.parseDouble(scanner.next()));
                System.out.println(newStudent.toString());

                allStudents.add(newStudent);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }

        return allStudents;

    }

//    private static int countStudents(String file){
//        int count = 0;
//        {try()
//    }

    //sorts all the students in the master list into their respective Course list
//    void courseSort(){
//        for(Student student : allStudents){
//            if(allCourses.isEmpty()){
//                Course newCourse = new Course(allStudents);
//            }
//        }
//
//    }

//    void organize(){
//        allStudents
//
//    }

//    void deleteFiles(String fileNames){
//
//    }
}

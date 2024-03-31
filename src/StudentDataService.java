import java.util.*;
import java.io.*;

public class StudentDataService {
    private List<Student> allStudents = new ArrayList<Student>();
    private String outputFiles;
    private Integer numCourses = 3; //hardcoded for now, add in assigning based on unique course IDs?
    private String INPUT_FILE = "student-master-list.csv";

    List<Student> readFile(){
        try (Scanner scanner = new Scanner(new File(INPUT_FILE))){
            scanner.useDelimiter(",|\\r\\n");
            scanner.nextLine();
            Student newStudent;

            while(scanner.hasNext()){
                newStudent = new Student();
                System.out.println("Student: ");
                newStudent.setStudentID(Integer.parseInt(scanner.next()));
                newStudent.setStudentName(scanner.next());
                newStudent.setCourse(scanner.next());
                newStudent.setGrade(Double.parseDouble(scanner.next()));
                System.out.println(newStudent.toString());
                System.out.println("End student.");



                allStudents.add(newStudent);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }

        return allStudents;

    }

    //sorts all the students in the master list into their respective Course list
    void courseSort(){

    }

    void organize(){
//        allStudents

    }

    void deleteFiles(String fileNames){

    }
}

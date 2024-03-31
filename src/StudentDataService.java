import java.util.*;
import java.io.*;

public class StudentDataService {
    private Student[] allStudents;
    private List<Course> allCourses = new ArrayList<Course>();
    private String outputFiles;
    private Integer numCourses = 3; //hardcoded for now, build in assigning based on unique course IDs?
    private String INPUT_FILE = "student-master-list.csv";
    private Integer studentCount = countStudents(INPUT_FILE);

    Student[] readFile(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE))){
            allStudents = new Student[studentCount];
            Student newStudent;
            String[] lineData;

            bufferedReader.readLine();

            for(int i = 1; i < studentCount; i++){
                newStudent = new Student();
                lineData = bufferedReader.readLine().split(",|\\r\\n|\\n");
                newStudent.setStudentID(Integer.parseInt(lineData[0]));
                newStudent.setStudentName(lineData[1]);
                newStudent.setCourse(lineData[2]);
                newStudent.setGrade(Double.parseDouble(lineData[3]));
                System.out.println(newStudent.toString());

                allStudents[i] = newStudent;
            }
//            I think this delimiter *should* work for both Windows and Unix csv
//            but have only tested it on Windows
//            scanner.useDelimiter(",|\\r\\n|\\n");
//            scanner.nextLine();
//            Student newStudent;
//
//            while(scanner.hasNext()){
//                newStudent = new Student();
//                newStudent.setStudentID(Integer.parseInt(scanner.next()));
//                newStudent.setStudentName(scanner.next());
//                newStudent.setCourse(scanner.next());
//                newStudent.setGrade(Double.parseDouble(scanner.next()));
//                System.out.println(newStudent.toString());
//
//                allStudents.add(newStudent);
//            }
        }
        catch(IOException e){
            System.out.println("File not found: " + e.getMessage());
        }
        return allStudents;
    }

    private Integer countStudents(String file){
        Integer count = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(this.INPUT_FILE))){
            while (bufferedReader.readLine() != null){
                count++;
            }
        }
        catch (IOException e){
            System.out.println("Student counting error: " + e.getMessage());
        }
        return count;
    }

    private void countCourses(){
        numCourses = 0;
        String courseNames = "";
        for(int i = 0; i < studentCount; i ++) {
            if (allStudents[i] != null) {
//            if the name of the course isn't in the string of course names
//            it gets added and the course count goes up
                if (!courseNames.contains(allStudents[i].getCourse())) {
                    numCourses++;
                    courseNames += ", " + allStudents[i].getCourse();
                }
            }
        }
        System.out.println(numCourses + " course rosters.");
    }

    //sorts all the students in the master list into their respective Course list
//    void courseSort(){
//        for(Student student : allStudents){
//            if(allCourses.isEmpty()){
//                Course newCourse = new Course(allStudents);
//            }
//        }
//
//    }

    void organize(){
        readFile();
        countCourses();

    }

//    void deleteFiles(String fileNames){
//
//    }
}

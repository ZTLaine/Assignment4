import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
    private String INPUT_FILE = "student-master-list.csv";
    private String OUTPUT_FILE = "course"; //don't forget to +counter to name them right
    private String header;

    void readFile(StudentDataService studentData){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE))){
            studentData.setAllStudents(new Student[studentData.getStudentCount()]);
            Student newStudent;
            String[] lineData;

            header = bufferedReader.readLine();

            for(int i = 1; i < studentData.getStudentCount(); i++){
                newStudent = new Student();
                lineData = bufferedReader.readLine().split(",|\\r\\n|\\n");
                newStudent.setStudentID(Integer.parseInt(lineData[0]));
                newStudent.setStudentName(lineData[1]);
                newStudent.setCourse(lineData[2]);
                newStudent.setGrade(Double.parseDouble(lineData[3]));
                System.out.println(newStudent.toString());

                studentData.setStudent(newStudent, i);
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
    }

    public Integer countStudents(){
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
}

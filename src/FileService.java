import java.io.*;

public class FileService {
    private final String INPUT_FILE = "student-master-list.csv";
    private final String OUTPUT_FILE = "course"; //don't forget to +counter to name them right
    private String header;

    void readFile(StudentDataService studentData){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE))){
            studentData.setAllStudents(new Student[studentData.getStudentCount()]);
            Student newStudent;
            String[] lineData;

            header = bufferedReader.readLine();

            for(int i = 1; i < studentData.getStudentCount(); i++){
                newStudent = new Student();
//            I think this delimiter *should* work for both Windows and Unix csv
                lineData = bufferedReader.readLine().split(",|\\r\\n|\\n");
                newStudent.setStudentID(Integer.parseInt(lineData[0]));
                newStudent.setStudentName(lineData[1]);
                newStudent.setCourse(lineData[2]);
                newStudent.setGrade(Double.parseDouble(lineData[3]));
                System.out.println(newStudent.toString());

                studentData.setStudent(newStudent, i);
            }
        }
        catch(IOException e){
            System.out.println("File not found: " + e.getMessage());
        }
    }

    void writeFile(StudentDataService studentData){
        String fileName;

        for(int i = 1; i <= studentData.getStudentCount(); i++){
            fileName = OUTPUT_FILE + i + ".csv";
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))){
                bufferedWriter.write(header);
                //gets the toString of the course matching the counter
                bufferedWriter.write(studentData.getAllCourses()[i-1].toString());

                System.out.println("Wrote to: " + fileName);
            } catch (IOException e) {
                System.out.println("Problem writing file: " + fileName);
            }
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

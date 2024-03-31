import java.util.*;
import java.lang.*;

public class StudentSortingApplication {
    public static void main(String[] args) {
//        Student zack = new Student(12, "Zack", "CS101", 89.2);
//        System.out.println(zack.toString());
//        String text = "06";
//        zack.setStudentID(Integer.parseInt(text));
//        System.out.println(zack.toString());

        StudentDataService studentDataService = new StudentDataService();
        studentDataService.readFile();
    }
}

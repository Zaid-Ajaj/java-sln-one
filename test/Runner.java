import java.lang.*;
import java.util.*;

public class Runner 
{
    public static void main(String[] args)
    {
        Utility util = new Utility();

        Test.Case("Utility.parseInt returns empty when input is invalid", () -> 
        {   
            OptionalInt result = util.parseInt("invalid-input");
            Test.AreEqual(false, result.isPresent());
        });

        Test.Case("Utility.parseInt returns correct valid when input is valid", () -> 
        {   
            OptionalInt result = util.parseInt("456");
            Test.AreEqual(456, result.getAsInt());
        });

        Test.Case("Student.hasStudentNumber works", () ->
        {
            Student student = new Student("First", "Last", 1);
            int studentNumber = 1;
            int incorrectStudentNumber = 2;
            Test.AreEqual(true, student.hasStudentNumber(studentNumber));
            Test.AreEqual(false, student.hasStudentNumber(incorrectStudentNumber));
            Test.AreEqual(false, student.hasStudentNumber(3));
        });

        Test.Case("Utility.findStudent works", () ->
        {
            Student[] students = 
            {
                new Student("First0", "Last0", 12345),
                new Student("First1", "Last1", 456)
            };

            Optional<Student> existingStudent = util.findStudent(students, 12345);

            Test.AreEqual(true, existingStudent.isPresent(), "Student should exsit");
            Test.AreEqual("First0 Last0, s12345", existingStudent.get().toString(), "formatted student info is correct");

            int nonExistingStdNumber = 1;
            Optional<Student> nonExistingStudent = util.findStudent(students, nonExistingStdNumber);
            Test.AreEqual(false, nonExistingStudent.isPresent(), "Student was not found, as expected");
        });

        Test.Report();
    }
}
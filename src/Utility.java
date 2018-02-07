import java.util.*;
import java.lang.*;


/**
 * Class containing helper utility functions
 * 
 * @author Zaid Ajaj
 * @author Luna Scherntharen
 */
public class Utility
{
    private Scanner scanner = new Scanner(System.in);


    /** Read user input after prompting him/her with a message  */
    public String readUserInput(String inputMsg)
    {
        System.out.print(inputMsg);

        if (scanner.hasNextLine())
        {
            return scanner.nextLine();
        }

        return "";
    } 

    /**  Safely parses integers from an input string, returning empty value when parsing failes. */
    public OptionalInt parseInt(String input)
    {
        try 
        {
            int result = Integer.parseInt(input);
            return OptionalInt.of(result);
        }
        catch (Exception ex)
        {
            return OptionalInt.empty();
        }
    }

    /** Try find a student in an array by his/her student number */
    public Optional<Student> findStudent(Student[] students, int studentNumber)
    {
        for (int i = 0; i < students.length; i++)
        {
            Student currentStudent = students[i];

            // if we find the index AND the student at that index is initialized
            if (currentStudent.hasStudentNumber(studentNumber))
            {
                return Optional.of(currentStudent);
            }
        }

        // at this point, nothing was found, return empty
        Optional<Student> empty = Optional.empty();
        return empty;
    }

    /** Prints out the information of every student in the array  */
    public void printStudents(Student[] students)
    {
        System.out.println("The group now contains:");
        for(Student student : students)
        {
            System.out.println(student.toString());
        }
        System.out.println("");
    }
}
import java.util.*;
import java.lang.*;

/**
 * Assignment 1
 * This program creates and manipulates a group of students with the help of user input
 * 
 * @author Luna-Elise Schernthaner - s4703928 
 * @author Zaid Ajaj - s4807561
 */
public class StudentGroupEditor 
{
    void writeLn(String input)
    {
        System.out.println(input);
    }

    void write(String input)
    {
        System.out.print(input);
    }

    /** Contains the logic of creating and updating the data of a group of students */
    public void run()
    {
        Utility util = new Utility();

        String userInput = util.readUserInput("How many students should there be in the group? ");
        OptionalInt studentCountResult = util.parseInt(userInput);

        if (!studentCountResult.isPresent() || studentCountResult.getAsInt() < 0)
        {
            writeLn("The number you entered is not a valid positive integer. Terminating...");
            return;
        }

        // the input was a valid integer, now just "get()" it
        int studentCount = studentCountResult.getAsInt();

        writeLn("The group will be having " + studentCount + " student(s)");
        writeLn("You will now fill in the information for each one of them, have fun!");
        writeLn("");

        // create an array of student with a size of the input number 
        Student[] studentGroup = new Student[studentCount];

        for (int i = 0; i < studentCount; i++)
        {
            String firstName = util.readUserInput("Enter first name: ");
            String lastName = util.readUserInput("Enter last name: ");
            OptionalInt studentNumberResult = util.parseInt(util.readUserInput("Enter student number: "));

            if (!studentNumberResult.isPresent())
            {
                writeLn("The student number you entered was not valid.");
                return;
            }
            
            // the student number input was valid
            int studentNumber = studentNumberResult.getAsInt();
            
            // populate the array
            studentGroup[i] = new Student(firstName, lastName, studentNumber);

            writeLn("Added: " + studentGroup[i].toString());
            writeLn("");
        }

        util.printStudents(studentGroup);

        Boolean editingStudentInfo = true;

        while (editingStudentInfo) 
        {
            writeLn("Enter the student number of the student you wish to update or a negative number to exit");
            
            userInput = util.readUserInput("Student number: ");

            OptionalInt studentNumberResult = util.parseInt(userInput);
            
            if (!studentNumberResult.isPresent())
            {
                writeLn("The student number you entered doesn't seem to be valid, try again");
                continue;
            }

            int studentNumber = studentNumberResult.getAsInt();

            if (studentNumber < 0) 
            {
                // the user entered a negative index, terminate
                editingStudentInfo = false;
                continue;
            }

            // find student by the student number
            Optional<Student> student = util.findStudent(studentGroup, studentNumber);

            if (!student.isPresent()) 
            {
                writeLn("Could not find a student with the student number you entered, try again.");
                writeLn("");
                continue;
            }

            Student foundStudent = student.get();
            writeLn("Student found: " + foundStudent.toString());
            
            // update the student
            foundStudent.setFirstName(util.readUserInput("Enter new first name: "));
            foundStudent.setLastName(util.readUserInput("Enter new last name: "));

            writeLn("The group was updated!");
            
            util.printStudents(studentGroup);
        }
    }
}

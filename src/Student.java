import java.util.*;
import java.lang.*;

 /**
  * This class describes a student and the basic property he/she has. 
  * @author Zaid Ajaj - s4807561
  * @author Luna-Elise Schernthaner - s4703928
  */
public class Student
{
    private String firstName;
    private String lastName;
    private int studentNumber; 

    /** Tests whether or not a string is empty or consists only of whitespace */
    public Boolean isEmptyOrWhitespace(String input) 
    {
        return input == null 
            || input.isEmpty()
            || input.trim().isEmpty();
    }

    // contructor to initialize an instance of a Student 
    public Student(String firstName, String lastName, int studentNumber)
    {
        // illegal input:
        if (isEmptyOrWhitespace(firstName)) throw new IllegalArgumentException("firstName is invalid");
        if (isEmptyOrWhitespace(firstName)) throw new IllegalArgumentException("lastName is invalid");
        if (studentNumber < 0) throw new IllegalArgumentException("studentNumber must be a positive integer");

        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** Tests whether or not the provided number is equal to the student number of this instance  */
    public boolean hasStudentNumber(int number) {
        return this.studentNumber == number;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", s" + studentNumber;
    }
}

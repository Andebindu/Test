import java.util.Scanner;

public class Modules extends Students{

    //declare modules attributes
    private String moduleCode;
    private String moduleTitle;
    private String moduleDescription;
    private String studentGrade;
    private int studentMark;

    //create a constructor for the modules class
    public Modules(){
        //instatiate modules attributes
        this.moduleCode = null;
        this.moduleTitle = null;
        this.moduleDescription = null;
        this.studentMark = 0;
        this.studentGrade = null;
    } 

    //setter for module's code
    public void setModuleCode(String moduleCode){
        this.moduleCode = moduleCode;
    }

    //getter for module's code
    public String getModuleCode(){
        return this.moduleCode;
    }

    //setter for module's title
    public void setModuleTitle(String moduleTitle){
        this.moduleTitle = moduleTitle;
    }

    //getter for module's title
    public String getModuleTitle(){
        return this.moduleTitle;
    }

    //setter for module's description
    public void setModuleDescription(String moduleDescription){
        this.moduleDescription = moduleDescription;
    }

    //getter for module's code
    public String getModuleDescription(){
        return this.moduleDescription;
    }

    //setter for student's mark and grade per module
    public void setStudentMarkGrade(int studentMark, Scanner dataInput){
        while (studentMark < 0 || studentMark > 100) {
            System.out.println("Invalid mark. Please enter a mark between 0 and 100.");
            studentMark = this.tryMarkAdding(dataInput);
        }

        this.studentMark = studentMark;
        this.studentGrade = this.gradeConverter(this.studentMark);
    }

    //getter for student's grade per module
    public String getStudentGrade(){
        return this.studentGrade;
    }

    //method validate mark inputs
    public int tryMarkAdding(Scanner dataInput) {
        int studentMark;
        while (true) {
            try {
                studentMark = Integer.parseInt(dataInput.nextLine());
                if (studentMark >= 0 && studentMark <= 100) {
                    break;
                } else {
                    System.out.println("Invalid mark. Please enter a mark between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid mark.");
            }
        }
        return studentMark;
    }

    //method to convert mark to grades
    public String gradeConverter(int mark){

        String grade;

        if (mark >= 90 && mark <= 100) {
            grade = "A**";
        } else if (mark >= 80 && mark <= 89) {
            grade = "A*";
        } else if (mark >= 70 && mark <= 79) {
            grade = "A";
        } else if (mark >= 60 && mark <= 69) {
            grade = "B";
        } else if (mark >= 50 && mark <= 59) {
            grade = "C";
        } else if (mark >= 40 && mark <= 49) {
            grade = "D";
        } else {
            grade = "FAIL";
        }
        return grade;

    }

}

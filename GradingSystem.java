import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class GradingSystem {
    public static void main(String[] args) throws Exception {
        //create scanner object to accept input from user
        Scanner dataInput = new Scanner(System.in);
        //create list to store students
        List<Students> students = new ArrayList<>();
        System.out.println();
        //create list to store inputed student IDS
        Set<String> existingStudentIDs = new HashSet<>();
        System.out.println("STUDENTS'S GRADING SYSTEM");
        System.out.println();
        System.out.println("CAREFULLY Follow The Prompts");
        System.out.println();

        //Create Students and module details
        while (true) {
            System.out.println("Input Student Details And Records");
            System.out.println();
            Students student = new Students();
            System.out.print("Enter student's ID: ");
            String studentID = dataInput.nextLine().toUpperCase();

            //check if inputed student ID is empty
            if (!studentID.isEmpty()) {
                //check if input student ID already exists
                if (!existingStudentIDs.contains(studentID)) {
                    //store id if it does not exist
                    student.setStudentID(studentID);
                    System.out.print("Enter student's first name: ");
                    String firstName = dataInput.nextLine();
                    student.setStudentFirstName(firstName);
                    System.out.print("Enter student's last name: ");
                    student.setStudentLastName(dataInput.nextLine());
                    System.out.println();
                    System.out.println("Input Modules And Marks For "+firstName);
                    System.out.println();
                    //create list to store module codes per student
                    Set<String> existingModuleCodes = new HashSet<>();

                    //create modules for each student
                    while (true) {

                        Modules module = new Modules();
                        System.out.print("Enter module code: ");
                        String moduleCode = dataInput.nextLine().toUpperCase();

                        //check if module code entered is empty
                        if (!moduleCode.isEmpty()) {
                            //check if module code already exists
                            if (!existingModuleCodes.contains(moduleCode)) {
                                //store module code into List
                                module.setModuleCode(moduleCode);
                                System.out.print("Enter module title: ");
                                module.setModuleTitle(dataInput.nextLine());
                                System.out.print("Enter module description: ");
                                module.setModuleDescription(dataInput.nextLine());

                                System.out.print("Enter mark for " + moduleCode + ": ");
                                int studentMark = module.tryMarkAdding(dataInput);
                                module.setStudentMarkGrade(studentMark,dataInput);

                                //store all module details for each module in the student modules list
                                student.setModule(module);
                                existingModuleCodes.add(moduleCode);
                                System.out.println();

                                //prompt user to add another module for current student or terminate
                                System.out.print("Add another module for " + firstName + " (yes/no)? ");
                                String addModule = dataInput.nextLine().toLowerCase();
                                if (!addModule.equals("yes")) {
                                    break;
                                }
                                
                            }else{
                                System.out.println("Module with the same code already exists. Please enter a unique module code.");
                            }
                        }else{
                            System.out.println("Module code cannot be empty, please enter a valid module code");
                        }

                    }
                    //store all student details for each student in the students list
                    students.add(student);
                    existingStudentIDs.add(studentID);
                    System.out.println();
                    //prompt user to add another student or terminate
                    System.out.print("Add another student (yes/no)? ");
                    String addStudent = dataInput.nextLine().toLowerCase();
                    if (!addStudent.equals("yes")) {
                        dataInput.close();
                        break;
                    }
                    System.out.println();

                } else {
                    System.out.println("Student with the same ID already exists. Please enter a unique ID.");
                }
            } else {
                System.out.println("Student ID cannot be empty. Please enter a valid ID.");
            }
            
        }

        //set longest fullname as name's column width
        int nameWidth = 0;
        for (Students student : students) {
            int fullNameLength = student.getStudentFullName().length();
            if (fullNameLength > nameWidth) {
                nameWidth = fullNameLength;
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("-------------------");
        System.out.println("Student Grades");
        System.out.println("-------------------");

        //print out all students and respective modules
        for (Students student : students) {
            System.out.printf("%-" + (nameWidth+5) + "s",student.getStudentFullName());
            List<Modules> modules = student.getStudentModules();
            for (Modules module : modules) {
                System.out.print(module.getModuleCode()+": ");
                System.out.print(module.getStudentGrade()+" ");
            }
            System.out.println();
        }
        System.out.println();

    }

}

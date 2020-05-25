import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Lecturer extends Academic implements Functional {

    private boolean isAdvisor;
    private ArrayList<Lecture> lectures;

    public Lecturer(String name, String ID, ArrayList<Lecture> lectures, boolean isAdvisor) {

        super(name, ID);
        setIsAdvisor(isAdvisor);

        setLectures(lectures);
    }

    @Override
    public int menu() {

        while (true) {

            this.staticMenu("MAIN MENU");
            System.out.println("  ╟" + StringUtils.rightPad("───╢    ➀ GRADES      ✎  ╟", 58, '─') + "╢");
            System.out.println("  ╟" + StringUtils.rightPad("───╢    ➁ ABSENTEEISM \uD83D\uDD5A  ╟", 59, '─') + "╢");
            System.out.println("  ╟" + StringUtils.rightPad("───╢    ➂ CALENDAR    \uD83D\uDCC5  ╟", 59, '─') + "╢");
            System.out.println("  ╟" + StringUtils.rightPad("───╢    ④ EXIT    \uD83D\uDEAA      ╟", 60, '─') + "╢");
            System.out.println("  ╚═══════════════════════════════════════════════════════════╝");
            System.out.print  ("  ╙────➲ Select one: ");

            try {

                int selection = sc.nextInt();

                Functional.cls();

                if(selection == 1 || selection == 2 || selection == 3|| selection == 4){

                    return selection;
                }
                else {

                    System.out.println(" ➾ Invalid input. Please enter a valid integer.");
                }
            }
            catch (InputMismatchException e) {

                sc.nextLine();
                System.out.println(" ➾ Invalid input. Please enter a valid integer.");
                System.out.println();
            }
        }
    }

    @Override
    public void grades(){

        while(true) {

            int i = 1;
            // Print Lecturer's Lectures
            for (Lecture l : getLectures()) {

                staticMenu("GRADES");
                System.out.println("  ╠═══════════════════════════════════════════════════════════╣");
                System.out.printf("  ╟────────┤ %d) %8.7s├────────────────────────────────────────╢\n", i, l.getLectureCode());
                i++;
            }
            System.out.println("  ║▁▁▁▁▁▁▁▁│▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁║");
            // Select Lecture
            int lectureIndex = sc.nextInt() - 1;

            i = 1;
            staticMenu("GRADES");
            System.out.println("  ╠═══════════════════════════════════════════════════════════╣");
            // Print That Lecture's Sections
            for (Section s : getLectures().get(lectureIndex).getSections()) {

                System.out.printf("  ╟────────┤ %d) %9.8s├────────────────────────────────────────╢\n", i, s.getSectionNumber());
                i++;
            }

            System.out.println("  ║▁▁▁▁▁▁▁│▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁║");

            // Select Section
            int sectionIndex = sc.nextInt() - 1;

            staticMenu("GRADES");

            int length = 31 + 11 * getLectures().get(lectureIndex).getSections().get(sectionIndex).getSectionStudents().get(0).getMyGrades().get(0).getCourseGrades().size();

            if (length < 61) {

                System.out.println("  ╠═══════════════════════════════════════════════════════════╣");
            }
            else {

                System.out.println("  ╠═══════════════════════════════════════════════════════════╩");
            }

            System.out.print("  ╟──┤" + StringUtils.center("ID", 11) + "├──┤" + StringUtils.center("NAME", 11) + "├");
            for (Grade g : getLectures().get(lectureIndex).getSections().get(sectionIndex).getSectionStudents().get(0).getMyGrades().get(0).getCourseGrades()) {

                System.out.print("──┤" + StringUtils.center(g.getGradeType(), 7) + "├");
            }

            System.out.println();
            // Print the Grades of that Section Students
            for (Student student : getLectures().get(lectureIndex).getSections().get(sectionIndex).getSectionStudents()) {

                System.out.print(student.getName() + student.getID());
                for (Grade g : student.getMyGrades().get(0).getCourseGrades()) {


                    System.out.print("──┤   " + g.getGradeValue() + "   ├");
                }
                System.out.println();
            }


            System.out.println("Enter -1 to go back");
            System.out.println("Enter 0 to enable Edit Mode");

            String selection = sc.next();
            //If Lecturer enters specific value to go back
            if (selection.equals("-1")) {

                break;
            }
            // If Lecturer enters specific value to change grades
            else if (selection.equals("0")) {

                changeGrades(
                        getLectures().get(lectureIndex).getSections().get(sectionIndex),
                        getLectures().get(lectureIndex).getLectureCode()
                );
            }
        }
    }

    public void changeGrades(Section section, String courseCode){

        ArrayList<String> localChanges = new ArrayList<>();

        ArrayList<Student> overwriteID = new ArrayList<>();

        while(true) {

            int i = 1;
            for(String s : localChanges){

                System.out.println(i + "- " + s);
                i++;
            }

            System.out.println("Please Enter the Student ID. Enter -1 to Exit Edit Mode");
            String selection = sc.next();

            if(selection.equals("-1")){

                System.out.println("Do you want to save your changes? (Y / N) Enter anything else to cancel.");
                selection = sc.next();

                if(selection.equals("Y")){

                    System.out.println("Processing the changes...");

                    for(Student s : overwriteID){

                        try {
                            BufferedWriter bw = new BufferedWriter(
                                    new FileWriter(
                                            System.getProperty("user.dir") + "\\SampleFolder\\Student\\" + s.getID() + "\\Grades\\" + courseCode + ".txt"
                                            )
                            );

                            for(Grade g : s.getMyGrades().get(0).getCourseGrades()){

                                String writeLine = g.getGradeType() + " - " + g.getGradeValue();
                                bw.write(writeLine);
                            }
                            bw.close();
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
                else if(selection.equals("N")){

                    System.out.println("Discarding the changes...");
                    break;
                }
                else{

                    System.out.println();
                }
            }

            System.out.println("Please Enter the grading criteria");
            String criteria = sc.next();

            System.out.println("Please Enter the grade");
            int grade = sc.nextInt();

            for (Student s : section.getSectionStudents()) {

                if(s.getID().equals(selection)){

                    for(Grade g : s.getMyGrades().get(0).getCourseGrades()){

                        if(g.getGradeType().equals(criteria)){

                            g.setGradeValue(grade);

                            overwriteID.add(s);
                            localChanges.add(criteria + " grade for " + selection + " is now " + grade + ".");
                        }
                    }
                }
            }

            // Save and Exit
        }
    }

    @Override
    public void absenteeism(){


    }

    public void changeAbsenteeism(){


    }

    @Override
    public void calendar() {

    }

    public void changeCalendar(){


    }

    @Override
    public void staticMenu(String menuName){

        System.out.println("  ╔═══════════════════════════════════════════════════════════╗");
        System.out.println("  ║" + StringUtils.rightPad("Lecturer Login: " + this.getName(), 59) + "║");
        System.out.println("  ║" + StringUtils.rightPad("Advisor Access: " + (getIsAdvisor()?"☑":"☒"), 59) + "║");
        System.out.println("  ╠═══════════════════════════════════════════════════════════╣");
        System.out.println("  ║" + StringUtils.center(menuName, 59) + "║" );

    }

    public ArrayList<Lecture> getLectures() {
        return lectures;
    }
    public boolean getIsAdvisor(){

        return isAdvisor;
    }

    public void setIsAdvisor(boolean isAdvisor){

        this.isAdvisor = isAdvisor;
    }
    public void setLectures(ArrayList<Lecture> lectures) {
        this.lectures = lectures;
    }
}

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
            for(Lecture l : getLectures()){

                System.out.println(i + "- " + l.getLectureCode());
                i++;
            }

            // Select Lecture
            int lectureIndex = sc.nextInt();

            i = 1;
            // Print That Lecture's Sections
            for(Section s : getLectures().get(lectureIndex).getSections()){

                System.out.println(i + "- " + s.getSectionNumber());
                i++;
            }

            // Select Section
            int sectionIndex = sc.nextInt();

            // Print the Grades of that Section Students
            // YİĞİT BURASI SENDE KOÇUM

            /*
            //If Lecturer enters specific value to go back
            if(){

                break;
            }
            // If Lecturer enters specific value to change grades
            else if(){

                changeGrades();
            }

             */
        }
    }

    public void changeGrades(Section section){

        ArrayList<String> localChanges = new ArrayList<>();

        ArrayList<Student> overwriteID = new ArrayList<>();

        while(true) {

            int i = 1;
            for(String s : localChanges){

                System.out.println(i + "- " + s);
                i++;
            }

            // Enter -1 to Exit Edit Mode
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
                                            System.getProperty(
                                                    "user.dir") + "\\SampleFolder\\Student\\" + s.getID() + "\\Grades\\"
                                            )
                            );
                        } catch (IOException e) {
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

            // Please Enter the Student ID
            String idToChange = sc.next();

            // Please Enter the grading criteria
            String criteria = sc.next();

            // Please Enter the grade
            int grade = sc.nextInt();

            for (Student s : section.getSectionStudents()) {

                if(s.getID().equals(idToChange)){

                    for(Grade g : s.getMyGrades().get(0).getCourseGrades()){

                        if(g.getGradeType().equals(criteria)){

                            g.setGradeValue(grade);

                            overwriteID.add(s);
                            localChanges.add(criteria + " grade for " + idToChange + " is now " + grade + ".");
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
        System.out.println("  ╠═══════════════════════════════════════════════════════════╣");
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

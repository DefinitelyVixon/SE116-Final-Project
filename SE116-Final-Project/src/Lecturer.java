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

        System.out.println(getIsAdvisor()?"☑":"☒");

        while (true) {

            this.staticMenu("MAIN MENU");
            System.out.println("  ╟" + StringUtils.rightPad("───╢    ➀ GRADES      ✎  ╟", 58, '─') + "╢");
            System.out.println("  ╟" + StringUtils.rightPad("───╢    ➁ ABSENTEEISM \uD83D\uDD5A  ╟", 59, '─') + "╢");
            System.out.println("  ╟" + StringUtils.rightPad("───╢    ➂ CALENDAR    \uD83D\uDCC5  ╟", 59, '─') + "╢");
            System.out.println("  ╟" + StringUtils.rightPad("───╢    ④ EXIT    \uD83D\uDEAA      ╟", 60, '─') + "╢");
            System.out.println("  ╚═══════════════════════════════════════════════════════════╝");
            System.out.print("  ╙────➲ Select one: ");

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
        while (true) {
            this.staticMenu("GRADES");
            System.out.println("  ╟" + StringUtils.rightPad("───╢  1) MATH153    ╟", 59, '─') + "╢");
            System.out.println("  ╟" + StringUtils.rightPad("───╢  2) MATH154    ╟", 59, '─') + "╢");
        break;
        }
            try {

                int selection = sc.nextInt();

                Functional.cls();

                if (selection == 1 || selection == 2 ) {

                }


            }catch (Exception e){
                System.out.println("lsdfls");
            }
        }



    @Override
    public void absenteeism(){


    }

    @Override
    public void calendar() {

    }

    public void staticMenu(String menuName){

        System.out.println("  ╔═══════════════════════════════════════════════════════════╗");
        System.out.println("  ║" + StringUtils.rightPad("Lecturer Login: " + this.getName(), 59) + "║");
        System.out.println("  ║" + StringUtils.rightPad("Advisor Access: " + this.getIsAdvisor(),59)+"║");
        System.out.println("  ╠═══════════════════════════════════════════════════════════╣");
        System.out.println("  ║" + StringUtils.center(menuName, 59) + "║" );
        System.out.println("  ╠═══════════════════════════════════════════════════════════╣");
    }
    public void gradesA(){
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

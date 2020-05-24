import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Student extends Academic implements Functional {

    private ArrayList<CoursePack> myGrades;

    public Student(String name, String ID, ArrayList<CoursePack> myGrades) {

        super(name, ID);
        setMyGrades(myGrades);
    }

    @Override
    public int menu() {

        while (true) {

            this.staticMenu("MAIN MENU");
            System.out.println("  |" + StringUtils.center("|   1. GRADES   |", 59, '-') + "|");
            System.out.println("  |" + StringUtils.center("|   2. ABSENTEEISM   |", 59, '-') + "|");
            System.out.println("  |" + StringUtils.center("|   3. CALENDAR   |", 59, '-') + "|");
            System.out.println("  |-----------------------------------------------------------|");
            System.out.println("  |-----Select one: ");

            try {

                int selection = sc.nextInt();
                Functional.cls();

                if (selection == 1 || selection == 2 || selection == 3) {
                    return selection;
                }
                else {
                    System.out.println("Yazık kafana !");
                }
            }
            catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println(" > Invalid input. Please enter a valid integer. ");
                System.out.println();
            }
        }
    }

    @Override
    public void grades() {

        Functional.cls();

        this.staticMenu("GRADES");
        System.out.println("  |----- " + getName() + "    ");
        System.out.println("  |----- Lectures  -------------     Grades     ----------|");

        for (int i = 0 ; i < getMyGrades().size() ; i++){

            System.out.printf("  |-----     %-12.7s -------------------------------------|\n" , getMyGrades().get(i).getCourseCode());


            for (int j=0;j<getMyGrades().get(i).getCourseGrades().size();j++){

                System.out.printf("  |------------------------------  %-16.15s--------|\n" ,getMyGrades().get(i).getCourseGrades().get(j));

            }
        }
    }

    @Override
    public void absenteeism() {
        System.out.println();
    }

    @Override
    public void calendar() {

    }

    public void printInfo() {

        System.out.println("Name: " + getName());
        System.out.println("ID: " + getID());

        for(CoursePack cp : myGrades){

            System.out.println("Course Code: " + cp.getCourseCode());
            cp.printGrades();
        }
    }

    public void setMyGrades(ArrayList<CoursePack> myGrades) {
        this.myGrades = myGrades;
    }
    public ArrayList<CoursePack> getMyGrades() {
        return myGrades;
    }

    public void staticMenu(String menuName){

        System.out.println("<<|-----------------------------------------------------------|>>");
        System.out.println("  |" + StringUtils.left(" Student Login: " + this.getName(), 59) + "|");
        System.out.println("  |***********************************************************|");
        System.out.println("  |" + StringUtils.center(menuName, 59) + "|" );
        System.out.println("<<|-----------------------------------------------------------|>>");
    }
}

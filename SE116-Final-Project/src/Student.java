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
    public int menu(){
        while(true) {
            System.out.println("<<------------------------------------------------------------->>");
            System.out.println("| Student Login: Student name  ");
            System.out.println("|****************************************************************");
            System.out.println("|_______________________________________________________________|");
            System.out.println("|----------    1.Grades        ---------------------------------|");
            System.out.println("|----------    2.Absenteeism   ---------------------------------|");
            System.out.println("|----------    3.Calendar      ---------------------------------|");
            System.out.println("|---------------------------------------------------------------|");
            System.out.println("|-----Select one : ");
            try {
                int selection = scan.nextInt();
                space();
                if (selection == 1 || selection == 2 || selection == 3)
                    return selection;
                else
                    System.out.println("Yazık kafana !");
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Invalid input please try integer ");
                System.out.println();
            }
        }
    }

    @Override
    public void grades() {

    }

    @Override
    public void absenteeism() {

    }

    @Override
    public void calendar() {

    }

    @Override
    public void messages() {

    }

    public void printCourseGrades(){

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
}

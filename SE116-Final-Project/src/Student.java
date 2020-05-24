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

            System.out.println("<<------------------------------------------------------------->>");
            System.out.println("| Student Login: " + this.getName());
            System.out.println("|***************************************************************|");
            System.out.println("|_______________________________________________________________|");
            System.out.println("|----------    1. Grades        --------------------------------|");
            System.out.println("|----------    2. Absenteeism   --------------------------------|");
            System.out.println("|----------    3. Calendar      --------------------------------|");
            System.out.println("|---------------------------------------------------------------|");
            System.out.println("|-----Select one: ");
            try {
                int selection = sc.nextInt();
                Functional.cls();
                if (selection == 1 || selection == 2 || selection == 3)
                    return selection;
                else
                    System.out.println("Yazık kafana !");
            }
            catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid input please try integer ");
                System.out.println();
            }
        }
    }

    @Override
    public void grades() {

        Functional.cls();

        System.out.println("|-------------------------------------------------------|");
        System.out.println("|----- " + getName() + "    ");
        System.out.println("|----- Lectures  -------------     Grades     ----------|");

        for (int i = 0 ; i < getMyGrades().size() ; i++){

            System.out.println("|----- " + getMyGrades().get(i).getCourseCode());

            int length = getMyGrades().get(i).getCourseCode().length();

            while(length < 7){

                System.out.print(" ");
                length++;
            }

            System.out.println("  ------------------------------------|");

            for (int j=0;j<getMyGrades().get(i).getCourseGrades().size();j++){

                System.out.println("|------------------------------" + getMyGrades().get(i).getCourseGrades().get(j));

                int length2 = getMyGrades().get(i).getCourseGrades().get(j).length();

                while(length2 < 15){

                    System.out.print(" ");
                    length2++;
                }
                System.out.println(" ---------|");
            }
        }
    }

    @Override
    public void absenteeism() {

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
}

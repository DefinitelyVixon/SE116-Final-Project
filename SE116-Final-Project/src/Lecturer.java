import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Lecturer extends Academic implements Functional {

    private boolean isAdvisor;
    private ArrayList<Lecture> lectures;

    public Lecturer(String name, String ID, boolean isAdvisor) {

        super(name, ID);
        setIsAdvisor(isAdvisor);

        lectures = new ArrayList<>();

    }

    @Override
    public int menu() {
        while (true) {
            System.out.println("<<------------------------------------------------------------->>");
            System.out.println("| Lecturer Login: lecturer name  ");
            System.out.println("| Advisor access : ");
            System.out.println("|****************************************************************");
            System.out.println("|_______________________________________________________________|");
            System.out.println("|----------    1.Grades        ---------------------------------|");
            System.out.println("|----------    2.Absenteeism   ---------------------------------|");
            System.out.println("|----------    3.Calender      ---------------------------------|");
            System.out.println("|---------------------------------------------------------------|");
            System.out.println("|-----Select one : ");
            try {
                int selection = scan.nextInt();
                cls();
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
    public void absenteeism() throws IOException {

        ArrayList<String[]> data = new ArrayList<>();

        File file = new File("C:\\Users\\ilgi\\Desktop\\New folder (3)\\Lecturer\\" + this.getID() + "\\absenteeism.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while ((line = br.readLine()) != null) {

            String[] dataParts = line.split(" - ");

            data.add(dataParts);
        }

    }

    @Override
    public void calendar() {

    }

    @Override
    public void messages() {

    }

    public boolean getIsAdvisor(){

        return isAdvisor;
    }
    public void setIsAdvisor(boolean isAdvisor){

        this.isAdvisor = isAdvisor;
    }
}

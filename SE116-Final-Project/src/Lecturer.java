import org.apache.commons.lang3.StringUtils;

import java.io.*;
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

            this.staticMenu("MAIN MENU");
            System.out.println("  |" + StringUtils.center("|   1. GRADES   |", 59, '-') + "|");
            System.out.println("  |" + StringUtils.center("|   2. ABSENTEEISM   |", 59, '-') + "|");
            System.out.println("  |" + StringUtils.center("|   3. CALENDAR   |", 59, '-') + "|");
            System.out.println("  |-----------------------------------------------------------|");
            System.out.println("  |-----Select one: ");

            try {

                int selection = sc.nextInt();

                Functional.cls();

                if (selection == 1 || selection == 2 || selection == 3){

                    return selection;
                }
                else {

                    System.out.println(" > Invalid input. Please enter a valid integer.");
                }
            }
            catch (InputMismatchException e) {

                sc.nextLine();
                System.out.println(" > Invalid input. Please enter a valid integer.");
                System.out.println();
            }
        }
    }

    @Override
    public void grades() {

    }

    @Override
    public void absenteeism(){

        ArrayList<String[]> data = new ArrayList<>();

        File file = new File(System.getProperty("user.dir") + "\\SampleFolder\\Lecturer\\" + this.getID() + "\\absenteeism.txt");

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {

                String[] dataParts = line.split(" - ");

                data.add(dataParts);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void calendar() {

    }

    public void staticMenu(String menuName){

        System.out.println("<<|-----------------------------------------------------------|>>");
        System.out.println("  |" + StringUtils.left("Lecturer Login: " + this.getName(), 59) + "|");
        System.out.println("  | Advisor Access: " + this.getIsAdvisor());
        System.out.println("  |***********************************************************|");
        System.out.println("  |" + StringUtils.center(menuName, 59) + "|" );
        System.out.println("<<|-----------------------------------------------------------|>>");
    }

    public boolean getIsAdvisor(){

        return isAdvisor;
    }
    public void setIsAdvisor(boolean isAdvisor){

        this.isAdvisor = isAdvisor;
    }
}

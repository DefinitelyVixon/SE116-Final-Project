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

            System.out.println("<<|-----------------------------------------------------------|>>");
            System.out.println("  | Lecturer Login: " + this.getName());
            System.out.println("  | Advisor access : " + this.getIsAdvisor());
            System.out.println("  |***********************************************************|");
            System.out.println("  |___________________________________________________________|");
            System.out.println("  |----------    1. Grades        ----------------------------|");
            System.out.println("  |----------    2. Absenteeism   ----------------------------|");
            System.out.println("  |----------    3. Calendar      ----------------------------|");
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

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));

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

    public boolean getIsAdvisor(){

        return isAdvisor;
    }
    public void setIsAdvisor(boolean isAdvisor){

        this.isAdvisor = isAdvisor;
    }
}

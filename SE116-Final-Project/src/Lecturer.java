import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class Lecturer extends Academic implements Functional {

    private boolean isAdvisor;
    private ArrayList<Lecture> lectures;

    public Lecturer(String name, int ID, boolean isAdvisor) {

        super(name, ID);
        setIsAdvisor(isAdvisor);

        lectures = new ArrayList<>();

    }

    @Override
    public void menu() {

        System.out.println(" __________________________________________________________________________");
        System.out.println("| Lecturer Login: " + this.getName());
        System.out.println("| Advisor Access: " + isAdvisor);
        System.out.println("|__________________________________________________________________________");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|___________________________________________________________________________");

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

        String[] columnNames = {"ID", "Name", "Absenteeism"};



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

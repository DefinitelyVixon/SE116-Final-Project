import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lecturer extends AcademicStaff implements Functional {

    private boolean isAdvisor;
    private ArrayList<Lecture> lectures;


    public Lecturer(String name, int ID, boolean isAdvisor) {
        super(name, ID);
        setIsAdvisor(isAdvisor);
    }

    @Override
    public void grades() {

    }

    @Override
    public void absenteeism() throws IOException {

        ArrayList<String[]> data = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder("C:\\Users\\ilgi\\Desktop\\New folder (3)\\Lecturer\\" + this.getID() + "\\" + section + "\\" + section + "\\absenteeism.txt");

        File file = new File();

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

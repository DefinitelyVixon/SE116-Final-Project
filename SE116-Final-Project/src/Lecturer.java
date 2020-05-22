import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lecturer extends AcademicStaff implements Functional {

    private boolean isAdvisor;

    public Lecturer(String name, int ID, boolean isAdvisor) {
        super(name, ID);
        setIsAdvisor(isAdvisor);
    }

    @Override
    public void grades() {

    }

    @Override
    public void absenteeism(Section section) throws IOException {

        ArrayList<String[]> data = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder("C:\\Users\\ilgi\\Desktop\\New folder (3)\\Lecturer\\" + section.getLecturer().getID() + "\\" + section + "\\" + section + "\\absenteeism.txt");

        File file = new File();

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while ((line = br.readLine()) != null) {

            String[] dataParts = line.split(" - ");

            data.add(dataParts);
        }

        String[] columnNames = {"ID", "Name", "Absenteeism"};

        String[][] dataArr = new String[data.size()][columnNames.length];

        int i = 0;
        while (i < data.size()) {

            dataArr[i] = data.get(i);
            i++;
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

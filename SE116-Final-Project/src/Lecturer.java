import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lecturer extends Academic implements Functional {

    private boolean isAdvisor;
    private ArrayList<Lecture> lectures;

    public Lecturer(String name, String ID, boolean isAdvisor) {

        super(name, ID);
        setIsAdvisor(isAdvisor);

        lectures = new ArrayList<>();

    }

    @Override
    public void menu() {

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

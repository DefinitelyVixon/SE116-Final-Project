import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Methods{

    public void absenteeism() throws IOException {

        JFrame f = new JFrame();

        f.setMinimumSize(new Dimension(720,480));
        f.setMaximumSize(new Dimension(720,480));
        f.setPreferredSize(new Dimension(720,480));

        ArrayList<String[]> data = new ArrayList<>();

        File file = new File("C:\\Users\\ilgi\\Desktop\\New folder (3)\\Lecturer\\burakOrdin\\MATH154\\Section\\absenteeism.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while((line = br.readLine()) != null){

            String[] dataParts = line.split(" - ");

            data.add(dataParts);
        }

        String[] columnNames = {"ID", "Name", "Absenteeism"};

        String[][] dataArr = new String[data.size()][columnNames.length];

        int i = 0;
        while(i < data.size()){

            dataArr[i] = data.get(i);
            i++;
        }

        JTable table = new JTable(dataArr, columnNames);

        table.setBounds(300,45,420,435);

        f.add(table);

        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}

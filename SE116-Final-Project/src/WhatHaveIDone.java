import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.apache.commons.lang3.*;

public class WhatHaveIDone {

    public static void main(String[] args) {

        Student s = createStudent("egeAltiok");

        s.grades();
        s.absenteeism();
    }

    static Student createStudent(String ID) {

        String studentName = null, studentID = null;

        ArrayList<CoursePack> studentGrades = new ArrayList<>();
        ArrayList<CoursePack> studentAbsenteeism = new ArrayList<>();

        File baseFile = new File(System.getProperty("user.dir") + "\\SampleFolder\\Student\\" + ID);

        BufferedReader br;

        String line = null;

        try {

            File[] subFolders = baseFile.listFiles();

            for(File f : subFolders) {

                if(f.isDirectory()){

                    File[] subSubFolders = f.listFiles();

                    for(File t : subSubFolders){

                        br = new BufferedReader(new FileReader(t.getPath()));

                        if(t.getParentFile().getName().equals("Absenteeism")){

                            studentAbsenteeism.add(
                                    new CoursePack(
                                            t.getName(),    // Course Code
                                            br.readLine())  // Value of Absenteeism
                            );
                        }
                        else if(t.getParentFile().getName().equals("Grades")){

                            ArrayList<Grade> grades = new ArrayList<>();

                            while((line = br.readLine()) != null){

                                String[] gradeTypeAndValue = line.split(" - ");

                                grades.add(
                                        new Grade(
                                                gradeTypeAndValue[0],
                                                Integer.parseInt(gradeTypeAndValue[1])
                                        )
                                );
                            }

                            studentGrades.add(
                                    new CoursePack(
                                            t.getName(),  // Course Code
                                            grades        // The Course's Grading Criteria's and Their Values
                                    )
                            );
                        }
                        br.close();
                    }
                }
                else{

                    br = new BufferedReader(new FileReader(f.getPath()));
                    studentName = br.readLine();
                    studentID = br.readLine();
                    br.close();
                }
            }
            return new Student(studentName, studentID, studentGrades, studentAbsenteeism);
        }
        catch(IOException e) {

            e.printStackTrace();
            return null;
        }
    }


    static String readLines(String filePath) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));

        return br.lines().collect(Collectors.joining());
    }

    static int findSubstring(String searchIn, int i) {

        i += 2;
        int subStringEnd = i;

        while (searchIn.charAt(subStringEnd) != '!') {

            subStringEnd++;
        }
        return subStringEnd;
    }
}

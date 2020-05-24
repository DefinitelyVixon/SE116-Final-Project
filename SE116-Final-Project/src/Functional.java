import java.io.*;
import java.util.*;
import java.util.stream.*;

public interface Functional {

    Scanner sc = new Scanner(System.in);

    int menu();

    void grades();
    void absenteeism() throws IOException;
    void calendar();

    static String loginCheck(String loginType){

        int remainingAttempts = 3;

        while(true) {

            try {

                System.out.println(" ➾ Please Enter Your ID: ");
                String ID = sc.nextLine();

                System.out.println();

                File pathFile = new File(System.getProperty("user.dir") + "\\SampleFolder\\Login\\" + loginType + "\\" + ID + ".txt");

                if(remainingAttempts == 0){

                    return null;
                }
                else if (pathFile.exists()) {

                    BufferedReader br = new BufferedReader(new FileReader(pathFile));

                    System.out.println(" ➾ Please Enter Your Password: ");
                    String inputPassword = sc.nextLine();

                    System.out.println();

                    String password = br.readLine();
                    br.close();

                    if (inputPassword.equals(password)) {

                        System.out.println(" ➾ Login successful!");
                        return ID;
                    }
                    else {

                        System.out.println(" ➾ Incorrect Password! " + remainingAttempts + " attempts remaining.");
                        remainingAttempts--;
                    }
                }
                else {

                    System.out.println(" ➾ ID Not Found! " + remainingAttempts + " attempts remaining.");
                    remainingAttempts--;
                }
            }
            catch (IOException e) {

                e.printStackTrace();
            }
        }
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

    static Lecturer createLecturer(String ID){

        return null;
    }

    static void cls() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}

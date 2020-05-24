import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public interface Functional {

    Scanner sc = new Scanner(System.in);

    int menu();

    void grades();
    void absenteeism() throws IOException;
    void calendar();

    static String loginCheck(String loginType) {

        int remainingAttempts = 3;

        while(true) {

            try {

                System.out.println(" > Please Enter Your ID: ");
                String ID = sc.nextLine();

                System.out.println();

                File pathFile = new File("C:\\Users\\ilgi\\Desktop\\SampleFolder\\Login\\" + loginType + "\\" + ID + ".txt");

                if(remainingAttempts == 0){

                    return null;
                }
                else if (pathFile.exists()) {

                    BufferedReader br = new BufferedReader(new FileReader(pathFile));

                    System.out.println(" > Please Enter Your Password: ");
                    String inputPassword = sc.nextLine();

                    System.out.println();

                    String password = br.readLine();
                    br.close();

                    if (inputPassword.equals(password)) {

                        System.out.println(" > Login successful!");
                        return ID;
                    }
                    else {

                        System.out.println(" > Incorrect Password! " + remainingAttempts + " attempts remaining.");
                        remainingAttempts--;
                    }
                }
                else {

                    System.out.println(" > ID Not Found! " + remainingAttempts + " attempts remaining.");
                    remainingAttempts--;
                }
            }
            catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    static Student createStudent(String ID) {

        int i = 0;
        int iUpdate;

        String path = "C:\\Users\\ilgi\\Desktop\\SampleFolder\\Student\\" + ID + ".txt";

        String lines = null;

        try {

            lines = readLines(path);
        }
        catch (IOException e) {

            e.printStackTrace();
        }

        String studentName = null, studentID = null;

        ArrayList<CoursePack> studentGrades = new ArrayList<>();

        while (i < lines.length() - 2) {

            if (lines.charAt(i) == 'N') {

                iUpdate = findSubstring(lines, i);
                studentName = lines.substring(i + 2, iUpdate);
                i = iUpdate;
            }
            else if (lines.charAt(i) == 'I') {

                iUpdate = findSubstring(lines, i);
                studentID = lines.substring(i + 2, iUpdate);
                i = iUpdate;
            }
            else if (lines.charAt(i) == 'L' && lines.charAt(i + 1) == '!') {

                ArrayList<String> courseGrades = new ArrayList<>();

                iUpdate = findSubstring(lines, i);
                String courseCode = lines.substring(i + 2, iUpdate);
                i = iUpdate;

                while (true) {

                    if (lines.charAt(i) == 'G') {

                        iUpdate = findSubstring(lines, i);
                        courseGrades.add(lines.substring(i + 2, findSubstring(lines, i)));
                        i = iUpdate;
                    }
                    else if (lines.charAt(i) == 'L' && lines.charAt(i + 1) == '!') {

                        studentGrades.add(new CoursePack(courseCode, courseGrades));
                        break;
                    }
                    i++;
                }
            }
            else {
                i++;
            }
        }
        System.out.println("Student döndü");
        return new Student(studentName, studentID, studentGrades);
    }

    static Lecturer createLecturer(String ID){

        return null;
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

    static void cls() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}

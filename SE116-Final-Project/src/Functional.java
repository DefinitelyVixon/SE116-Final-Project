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

                System.out.println(" > Please Enter Your ID: ");
                String ID = sc.nextLine();

                System.out.println();

                File pathFile = new File(System.getProperty("user.dir") + "\\SampleFolder\\Login\\" + loginType + "\\" + ID + ".txt");

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

        String path = System.getProperty("user.dir") + "\\SampleFolder\\Student\\" + ID + ".txt";

        String lines = null;

        try {

            lines = readLines(path);
        }
        catch (IOException e) {

            e.printStackTrace();
        }

        String studentName = null, studentID = null;

        ArrayList<CoursePack> studentGrades = new ArrayList<>();

        ArrayList<CoursePack> studentAbsenteeism = new ArrayList<>();

        while (i < lines.length() - 2) {

            if (lines.charAt(i) == 'N' && lines.charAt(i + 1) == '!') {

                iUpdate = findSubstring(lines, i);
                studentName = lines.substring(i + 2, iUpdate);
                i = iUpdate;
            }
            else if (lines.charAt(i) == 'I' && lines.charAt(i + 1) == '!') {

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

                    if(lines.charAt(i) == 'G'){

                        iUpdate = findSubstring(lines, i);
                        courseGrades.add(lines.substring(i + 2, findSubstring(lines, i)));
                        i = iUpdate;
                    }
                    else if((lines.charAt(i) == 'L' || lines.charAt(i) == 'A') && lines.charAt(i + 1) == '!'){

                        studentGrades.add(new CoursePack(courseCode, courseGrades));
                        break;
                    }
                    i++;
                }
            }
            else if (lines.charAt(i) == 'A' && lines.charAt(i + 1) == '!'){

                iUpdate = findSubstring(lines, i);
                String courseCode = lines.substring(i + 2, iUpdate);
                i = iUpdate;

                iUpdate = findSubstring(lines, i - 1);
                studentAbsenteeism.add(new CoursePack(courseCode, lines.substring(i + 1, iUpdate)));
                i = iUpdate;
            }
            else {

                i++;
            }
        }

        return new Student(studentName, studentID, studentGrades, studentAbsenteeism);
    }

    static Lecturer createLecturer(String ID){

        return null;
    }

    static String readLines(String filePath) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));

        return br.lines().collect(Collectors.joining());
    }

    static int findSubstring(String searchIn, int i) {

        //N!Ege ALTIOK!I!20190602002!L!MATH154!G!Midterm: 79!G!Final: 99!L!SE116!G!Midterm: 75!G!Final: 100!G!Labs: 100!G!Project: 100!    A    !MATH154    !     2!A!SE116!3!E!
        //                                                                                                                              i = 125          i = 134
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

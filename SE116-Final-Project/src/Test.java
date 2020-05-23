import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {

    public static int i = 0;

    public static void main(String[] args) {

        int loginAs = menu();

        if(loginAs == 1){


            Student loggedStudent = createStudent();
        }
        else{


            Lecturer loggedLecturer = createLecturer();
        }
    }

    public static int menu() {

        while (true) {

            System.out.println("<<-------------------------------------------------------->>");
            System.out.println("|               OASIS VOL 2                               |");
            System.out.println("|        Izmir University of Economics                    |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|-------       1.Lecturer     -------    2.Student    ----|");
            System.out.println("<<________________________________________________________>>");
            System.out.print("|------Select one :");

            try {

                int selection = Functional.sc.nextInt();

                cls();

                if(selection == 1 || selection == 2){

                    return selection;
                }
                else {

                    System.out.println("Yazık kafana !");
                }
            }
            catch (InputMismatchException e) {
                Functional.sc.nextLine();
                System.out.println("Invalid input please try integer ");
                System.out.println();
            }
        }
    }

    public static void cls() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static Student createStudent() {

        String path = "C:\\Users\\ilgi\\Desktop\\SampleFolder\\Student\\egeAltiok.txt";

        String lines = null;

        try {

            lines = readLines(path);
        }
        catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println(lines);

        String studentName = null, studentID = null;

        ArrayList<CoursePack> studentGrades = new ArrayList<>();

        while (i < lines.length() - 2) {

            if (lines.charAt(i) == 'N') {

                studentName = findSubstring(lines);
            }
            else if (lines.charAt(i) == 'I') {

                studentID = findSubstring(lines);
            }
            else if (lines.charAt(i) == 'L' && lines.charAt(i + 1) == '!') {

                ArrayList<String> courseGrades = new ArrayList<>();

                String courseCode = findSubstring(lines);

                while (true) {

                    if (lines.charAt(i) == 'G') {

                        courseGrades.add(findSubstring(lines));
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
        return new Student(studentName, studentID, studentGrades);
    }

    public static String readLines(String filePath) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));

        return br.lines().collect(Collectors.joining());
    }

    public static String findSubstring(String searchIn) {

        i += 2;
        int subStringStart = i, subStringEnd = i;

        while (true) {

            if (searchIn.charAt(subStringEnd) == '!') {

                i = subStringEnd;
                break;
            }
            subStringEnd++;
        }
        return searchIn.substring(subStringStart, subStringEnd);
    }
}
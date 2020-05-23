import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MethodTesting {

    public static void main(String[] args){

        Student loggedStudent = createStudent();
        System.out.println("Name: " + loggedStudent.getName());
        System.out.println("ID: " + loggedStudent.getID());
        loggedStudent.printCourseGrades();
    }

    public static int i = 0;

    public static Student createStudent(){

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

        while(i < lines.length()){

            if(lines.charAt(i) == 'N') {

                studentName = findSubstring(lines);
            }
            else if(lines.charAt(i) == 'I'){

                studentID = findSubstring(lines);
            }
            else if(lines.charAt(i) == 'L' && lines.charAt(i+1) == '!'){

                System.out.println("New L " + i);

                ArrayList<String> courseGrades = new ArrayList<>();

                String courseCode = findSubstring(lines);

                while(true){

                    if(lines.charAt(i) == 'G'){

                        System.out.println("New G " + i);
                        courseGrades.add(findSubstring(lines));
                    }
                    else if(lines.charAt(i) == 'L' && lines.charAt(i+1) == '!'){

                        studentGrades.add(new CoursePack(courseCode, courseGrades));

                        System.out.println(i);
                        break;
                    }
                    i++;
                }
            }
            i++;
        }
        return new Student(studentName, studentID, studentGrades);
    }

    public static String readLines(String filePath) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));

        return br.lines().collect(Collectors.joining());
    }

    public static String findSubstring(String searchIn){

        i += 2;
        int subStringStart = i, subStringEnd = i;

        while(true){

            if(searchIn.charAt(subStringEnd) == '!'){

                i = subStringEnd;
                break;
            }
            subStringEnd++;
        }
        return searchIn.substring(subStringStart, subStringEnd);
    }

    public static void login(){


    }
}


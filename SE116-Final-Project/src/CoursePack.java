import java.util.ArrayList;

public class CoursePack {

    private String courseCode;
    private ArrayList<String> courseGrades;

    public CoursePack(String courseCode, ArrayList<String> courseGrades){

        setCourseCode(courseCode);
        setCourseGrades(courseGrades);
    }

    public void printGrades(){

        System.out.println("Grades: ");

        for (String s : courseGrades){

            System.out.println(s);
        }
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public void setCourseGrades(ArrayList<String> courseGrades) {
        this.courseGrades = courseGrades;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public ArrayList<String> getCourseGrades() {
        return courseGrades;
    }
}


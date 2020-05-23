import java.io.File;
import java.util.ArrayList;

public class Student extends Academic implements Functional {

    private ArrayList<CoursePack> myGrades;

    public Student(String name, String ID, ArrayList<CoursePack> myGrades) {

        super(name, ID);
        setMyGrades(myGrades);
    }

    @Override
    public void menu(){

    }

    @Override
    public void grades() {

    }

    @Override
    public void absenteeism() {

    }

    @Override
    public void calendar() {

    }

    @Override
    public void messages() {

    }

    public void printCourseGrades(){

        for(CoursePack cp : myGrades){

            System.out.println("Course Code: " + cp.getCourseCode());
            cp.printGrades();
        }
    }

    public void setMyGrades(ArrayList<CoursePack> myGrades) {
        this.myGrades = myGrades;
    }
    public ArrayList<CoursePack> getMyGrades() {
        return myGrades;
    }
}

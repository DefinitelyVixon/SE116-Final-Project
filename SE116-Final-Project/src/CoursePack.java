import java.util.ArrayList;

public class CoursePack {

    private String courseCode;
    private ArrayList<Object> courseData;

    // For Grades
    public CoursePack(String courseCode, ArrayList<Grade> grades){

        setCourseCode(courseCode);

        courseData = new ArrayList<>();
        courseData.addAll(grades);
    }
    // For Absenteeism
    public CoursePack(String courseCode, String data){

        setCourseCode(courseCode);

        courseData = new ArrayList<>();
        courseData.add(data);
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public void setCourseData(ArrayList<Object> courseData) {
        this.courseData = courseData;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public ArrayList<Object> getCourseData() {
        return courseData;
    }
    public ArrayList<Grade> getCourseGrades(){

        ArrayList<Grade> courseGrades = new ArrayList<>();

        for(Object o : getCourseData()){

            if(o instanceof Grade){

                Grade g = (Grade) o;

                courseGrades.add(g);
            }
        }
        return courseGrades;
    }
}


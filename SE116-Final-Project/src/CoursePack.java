import java.util.ArrayList;

public class CoursePack {

    private String courseCode;
    private ArrayList<String> courseData;



    public CoursePack(String courseCode, String data){

        setCourseCode(courseCode);

        courseData = new ArrayList<>();
        courseData.add(data);
    }
    public CoursePack(String courseCode, ArrayList<String> courseData){

        setCourseCode(courseCode);
        setCourseData(courseData);
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public void setCourseData(ArrayList<String> courseData) {
        this.courseData = courseData;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public ArrayList<String> getCourseData() {
        return courseData;
    }
}


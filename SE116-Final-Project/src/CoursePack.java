import java.util.ArrayList;

public class CoursePack {

    private String courseCode;
    private ArrayList<String> courseData;
    private ArrayList<String> events;
    private String date;


    public CoursePack(String courseCode, String data){

        setCourseCode(courseCode);

        courseData = new ArrayList<>();
        courseData.add(data);
    }
    public CoursePack(String courseCode, ArrayList<String> courseData){

        setCourseCode(courseCode);
        setCourseData(courseData);
    }

    public ArrayList<String> getEvents() {
        return events;
    }
    public void setEvents(ArrayList<String> events) {
        this.events = events;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
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


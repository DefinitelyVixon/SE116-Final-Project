

public abstract class Lecture {

    private String lectureCode;
    private String lectureName;

    public Lecture(String lectureCode, String lectureName){

        setLectureCode(lectureCode);
        setLectureName(lectureName);
    }

    public void setLectureCode(String lectureCode) {
        this.lectureCode = lectureCode;
    }
    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }
    public String getLectureCode() {
        return lectureCode;
    }
    public String getLectureName() {
        return lectureName;
    }
}

import java.util.ArrayList;

public class MATH154 extends Lecture {

    private ArrayList<Student> sectionStudents;

    public MATH154(String lectureCode, String lectureName, ArrayList<Student> sectionStudents) {

        super(lectureCode, lectureName);
        setSectionStudents(sectionStudents);
    }

    public void setSectionStudents(ArrayList<Student> sectionStudents) {
        this.sectionStudents = sectionStudents;
    }
    public ArrayList<Student> getSectionStudents() {
        return sectionStudents;
    }
}

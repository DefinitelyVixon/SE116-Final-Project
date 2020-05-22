import java.util.ArrayList;

public class Section {

    private Lecturer lecturer;
    private ArrayList<Student> students;

    public Section(Lecturer lecturer, ArrayList<Student> students){

        setLecturerID(lecturer);
        setStudents(students);
    }

    public void setLecturerID(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public Lecturer getLecturer() {
        return lecturer;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
}

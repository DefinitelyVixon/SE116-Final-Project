import java.util.ArrayList;

public class MATH154 extends Lecture{

    private ArrayList<Section> sections;

    public MATH154(String lectureCode, String lectureName, ArrayList<Section> sections) {

        super(lectureCode, lectureName);
        this.sections = new ArrayList<>();
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }
    public ArrayList<Section> getSections() {
        return sections;
    }
}

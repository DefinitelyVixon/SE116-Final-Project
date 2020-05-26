import java.util.ArrayList;

public abstract class Academic {

    private String name;
    private String ID;
    private ArrayList<ToDo> calendar;

    public Academic(String name, String ID, ArrayList<ToDo> calendar) {

        setName(name);
        setID(ID);
        setCalendar(calendar);
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public ArrayList<ToDo> getCalendar() {
        return calendar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setCalendar(ArrayList<ToDo> myCalendar) {
        this.calendar = myCalendar;
    }
}

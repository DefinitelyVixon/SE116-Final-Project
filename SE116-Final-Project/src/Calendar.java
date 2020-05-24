import java.util.ArrayList;

public class Calendar {

    private ArrayList<String> events;
    private String date;

    public Calendar(String date, ArrayList<String> events){

        setDate(date);
        setEvents(events);
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
}

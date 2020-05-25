import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private List<String> events;
    private String date;

    public Calendar(String date, List<String> events){

        setDate(date);
        setEvents(events);
    }

    public List<String> getEvents() {
        return events;
    }
    public void setEvents(List<String> events) {
        this.events = events;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}

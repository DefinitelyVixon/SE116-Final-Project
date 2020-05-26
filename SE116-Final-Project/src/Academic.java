import java.time.LocalDate;
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

    public void viewCalendar() {

        for (int i = 0; i < getCalendar().size(); i++) {

            System.out.printf("  ╟───┤ %-11.10s├──────────────────────────────────────────╢\n", getCalendar().get(i).getDate());

            for (int j = 0; j < getCalendar().get(i).getEvents().size(); j++) {

                System.out.printf("  ╟──┤ %-51.51s ├──╢\n", getCalendar().get(i).getEvents().get(j));

            }

            System.out.println("  ╠═══════════════════════════════════════════════════════════╣");
        }
        System.out.println("  ╟───────────────────────────────────────────────────────────╢");

        Functional.sc.nextLine();

        changeCalendar();
    }

    public void changeCalendar() {

        // Add A New Event

        System.out.println("Date in Year(int)-Month(int)-Day(int) format");
        String date = Functional.sc.nextLine();
        LocalDate localDate = LocalDate.parse(date);

        System.out.println("Enter Event name");
        String event = Functional.sc.nextLine();

        int addIndex = 0;

        for (ToDo t : getCalendar()) {

            if (t.getDate().isEqual(localDate)) {

                t.getEvents().add(event);
                break;
            } else if (t.getDate().isBefore(localDate) && addIndex == getCalendar().size() - 1) {

                getCalendar().add(new ToDo(localDate, event));
                break;
            } else if (t.getDate().isBefore(localDate)) {

                addIndex++;
            } else if (t.getDate().isAfter(localDate)) {

                getCalendar().add(addIndex, new ToDo(localDate, event));
                break;
            }
        }

        // Delete An Event

    }
}



public abstract class AcademicStaff {

    private String name;
    private int ID;

    public AcademicStaff(String name, int ID){

        setName(name);
        setID(ID);
    }

    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
}

import java.io.File;

public abstract class Academic {

    private String name;
    private String ID;

    public Academic(String name, String ID){

        setName(name);
        setID(ID);
    }

    public String getName() {
        return name;
    }
    public String getID() {
        return ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
}

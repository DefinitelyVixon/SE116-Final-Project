

public class Student extends Academic implements Functional {


    public Student(String name, int ID) {
        super(name, ID);
    }

    @Override
    public void menu(){

        System.out.println(" __________________________________________________________________________");
        System.out.println("| Student Login: " + this.getName());
        System.out.println("| ");
        System.out.println("|__________________________________________________________________________");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|___________________________________________________________________________");
    }

    @Override
    public void grades() {

    }

    @Override
    public void absenteeism() {

    }

    @Override
    public void calendar() {

    }

    @Override
    public void messages() {

    }
}

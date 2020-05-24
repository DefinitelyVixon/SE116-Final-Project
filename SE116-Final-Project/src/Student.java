import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Student extends Academic implements Functional {

    private ArrayList<CoursePack> myGrades;

    private ArrayList<CoursePack> myAbsenteeism;

    public Student(String name, String ID, ArrayList<CoursePack> myGrades, ArrayList<CoursePack> myAbsenteeism) {

        super(name, ID);
        setMyGrades(myGrades);
        setMyAbsenteeism(myAbsenteeism);
    }

    @Override
    public int menu() {

        while (true) {

            this.staticMenu("MAIN MENU");
            System.out.println("  ╟" + StringUtils.rightPad("───╢    ➀ GRADES      ✎  ╟", 58, '─') + "╢");
            System.out.println("  ╟" + StringUtils.rightPad("───╢    ➁ ABSENTEEISM \uD83D\uDD5A  ╟", 59, '─') + "╢");
            System.out.println("  ╟" + StringUtils.rightPad("───╢    ➂ CALENDAR    \uD83D\uDCC5  ╟", 59, '─') + "╢");
            System.out.println("  ╚═══════════════════════════════════════════════════════════╝");
            System.out.print("  ╙────➲ Select one: ");

            try {

                int selection = sc.nextInt();
                Functional.cls();

                if (selection == 1 || selection == 2 || selection == 3) {
                    return selection;
                }
                else {
                    System.out.println("Yazık kafana !");
                }
            }
            catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println(" ➾ Invalid input. Please enter a valid integer. ");
                System.out.println();
            }
        }
    }

    @Override
    public void grades() {

        Functional.cls();

        this.staticMenu("GRADES");

        for (int i = 0 ; i < getMyGrades().size() ; i++){

            System.out.printf("  ║        │ %-8.7s├────────────────────────────────────────╢\n", getMyGrades().get(i).getCourseCode());
            System.out.println("  ╟────────┼─────────┴────────────────────────────────────────╢");


            for (int j=0;j<getMyGrades().get(i).getCourseData().size();j++){

                System.out.printf("  ║        │ %-16.15s                                 ║\n", getMyGrades().get(i).getCourseData().get(j));

            }
            System.out.println("  ║▁▁▁▁▁▁▁▁│▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁║");
        }
    }

    @Override
    public void absenteeism() {

        for (CoursePack cp : getMyAbsenteeism()){

            System.out.println(cp.getCourseCode());
            System.out.println(cp.getCourseData());
        }
    }

    @Override
    public void calendar() {

    }

    public void setMyAbsenteeism(ArrayList<CoursePack> myAbsenteeism) {
        this.myAbsenteeism = myAbsenteeism;
    }
    public void setMyGrades(ArrayList<CoursePack> myGrades) {
        this.myGrades = myGrades;
    }

    public ArrayList<CoursePack> getMyGrades() {
        return myGrades;
    }
    public ArrayList<CoursePack> getMyAbsenteeism() {
        return myAbsenteeism;
    }

    public void staticMenu(String menuName){

        System.out.println("  ╔═══════════════════════════════════════════════════════════╗");
        System.out.println("  ║" + StringUtils.rightPad("  Student Login: " + this.getName(), 59) + "║");
        System.out.println("  ╠═══════════════════════════════════════════════════════════╣");
        System.out.println("  ║" + StringUtils.center(menuName, 59) + "║" );
        System.out.println("  ╠═══════════════════════════════════════════════════════════╣");
    }
}

import java.util.InputMismatchException;

public class Test {

    public static void main(String[] args) {

        int loginAs = menu();

        String ID;

        if(loginAs == 1){

            if((ID = Functional.loginCheck("Student")) != null){

                Student loggedStudent = Functional.createStudent(ID);

                loggedStudent.grades();
            }
            else {

                System.out.println(" > Stop abusing the fucking program you dumbass...");
            }
        }
        else{

            if((ID = Functional.loginCheck("Lecturer")) != null){

                Lecturer loggedLecturer = Functional.createLecturer(ID);
            }
            else {

                System.out.println(" > Stop abusing the fucking program you dumbass...");
            }

        }
    }

    public static int menu() {

        while (true) {

            System.out.println("<<|-----------------------------------------------------------|>>");
            System.out.println("  |                       OASIS VOL 2                         |");
            System.out.println("  |               Izmir University of Economics               |");
            System.out.println("  |-----------------------------------------------------------|");
            System.out.println("  |---------|  1) Student  |--------|  2) Lecturer  |---------|");
            System.out.println("<<|___________________________________________________________|>>");
            System.out.print("    |------Select one :");

            try {

                int selection = Functional.sc.nextInt();

                Functional.sc.nextLine();

                Functional.cls();

                if(selection == 1 || selection == 2){

                    return selection;
                }
                else {

                    System.out.println(" > Yazık kafana!");
                }
            }
            catch (InputMismatchException e) {
                Functional.sc.nextLine();
                System.out.println(" > Invalid input. Please enter a valid integer.");
                System.out.println();
            }
        }
    }




}
import org.apache.commons.lang3.StringUtils;

import java.util.InputMismatchException;

public class Test {

    public static void main(String[] args) {

        int loginAs = menu();

        String ID;

        if(loginAs == 1){

            if((ID = Functional.loginCheck("Student")) != null){

                Student loggedStudent = Functional.createStudent(ID);

                int selection = loggedStudent.menu();

                if(selection == 1){

                    loggedStudent.grades();
                }
                else if (selection == 2){

                    loggedStudent.absenteeism();
                }
                else{

                    loggedStudent.calendar();
                }
            }
            else {

                System.out.println(" > Stop abusing the fucking program you dumbass...");
            }
        }
        else{

            if((ID = Functional.loginCheck("Lecturer")) != null){

                Lecturer loggedLecturer = Functional.createLecturer(ID);

                int selection = loggedLecturer.menu();

                if(selection == 1){

                    loggedLecturer.grades();
                }
                else if(selection == 2){

                    loggedLecturer.absenteeism();
                }
                else{

                    loggedLecturer.calendar();
                }
            }
            else {

                System.out.println(" > Stop abusing the fucking program you dumbass...");
            }

        }
    }

    public static int menu() {

        while (true) {

            System.out.println("<<|-----------------------------------------------------------|>>");
            System.out.println("  |" + StringUtils.center("OASIS 2", 59) + "|");
            System.out.println("  |" + StringUtils.center("IZMIR UNIVERSITY OF ECONOMICS", 59) +"|");
            System.out.println("  |-----------------------------------------------------------|");
            System.out.println("  |---------|  1) Student  |--------|  2) Lecturer  |---------|");
            System.out.println("<<|___________________________________________________________|>>");
            System.out.print("  |------Select one :");

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
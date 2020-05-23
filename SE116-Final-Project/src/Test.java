import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

    }

    public static void loginCheck(){

        System.out.println();
        System.out.println();
        System.out.println();
    }
    static Scanner scan = new Scanner(System.in);

    private static int menu() {
        while (true) {
            System.out.println("<<-------------------------------------------------------->>");
            System.out.println("|               OASIS VOL 2                               |");
            System.out.println("|        Izmir University of Economics                    |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|-------       1.Lecturer     -------    2.Student    ----|");
            System.out.println("<<________________________________________________________>>");
            System.out.print("|------Select one :");
            try {
                int selection = scan.nextInt();
                space();
                if(selection==2||selection==1){
                    return selection;
                }
                else {
                    System.out.println("Yazık kafana !");
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Invalid input please try integer ");
                System.out.println();
            }
        }
    }
    private static void space() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }


}
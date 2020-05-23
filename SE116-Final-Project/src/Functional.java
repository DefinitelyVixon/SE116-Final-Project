import java.io.IOException;
import java.util.Scanner;

public interface Functional {

    Scanner sc = new Scanner(System.in);

    int menu();

    boolean loginCheck();

    void grades();
    void absenteeism() throws IOException;
    void calendar();

}

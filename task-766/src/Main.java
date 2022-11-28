import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
    public static void main(String[] argv) throws IOException {
        new Main().run();
    }

    PrintWriter pw;
    Scanner sc;

    public void run() throws IOException {
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter("output.txt");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        if (k > n * m) {
            pw.print("NO");
        } else {
            pw.print("YES");
        }
        pw.close();
    }
}
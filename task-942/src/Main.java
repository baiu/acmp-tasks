import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    public static void main(String[] argv) throws IOException {
        new Main().run();
    }

    PrintWriter pw;
    Scanner sc;

    public void run() throws IOException {
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter("output.txt");
        int taskCount = sc.nextInt();
        List<Integer> fifthYearStudentTaskTimes = new ArrayList<>();
        for (int i = 0; i < taskCount; i++) {
            fifthYearStudentTaskTimes.add(sc.nextInt());
        }
        List<Integer> thirdYearStudentTaskTimes = new ArrayList<>(fifthYearStudentTaskTimes);
        Collections.reverse(thirdYearStudentTaskTimes);
        List<Integer> firstYearStudentTaskTimes = new ArrayList<>(fifthYearStudentTaskTimes);
        Collections.sort(firstYearStudentTaskTimes);

        Integer fifthYearStudentScore = computeSum(fifthYearStudentTaskTimes);
        Integer thirdYearStudentScore = computeSum(thirdYearStudentTaskTimes);
        Integer firstYearStudentScore = computeSum(firstYearStudentTaskTimes);

        if (fifthYearStudentScore >= thirdYearStudentScore) {
            if (thirdYearStudentScore >= firstYearStudentScore) {
                pw.print(1);
            } else {
                pw.print(3);
            }
        } else if (fifthYearStudentScore >= firstYearStudentScore) {
            pw.print(1);
        } else {
            pw.print(5);
        }

        pw.close();
    }

    private static Integer computeSum(List<Integer> fifthYearStudentTaskTimes) {
        AtomicInteger sum = new AtomicInteger();
        return fifthYearStudentTaskTimes.stream()
                .map(time -> {
                    sum.set(time + sum.get());
                    return sum.get();
                })
                .mapToInt(i -> i)
                .sum();
    }
}
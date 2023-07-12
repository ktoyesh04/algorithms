import java.util.Arrays;
import java.util.Scanner;

public class JobSequencing {

    static class Job {
        int no, deadline, profit;
        Job(int no, int deadline, int profit){
            this.no = no;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of jobs: ");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        System.out.println("Enter the deadline and profit of each job: ");

        int m = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(i + 1, deadline, profit);
            if (deadline > m) {
                m = deadline;
            }
        }
        sc.close();
        Arrays.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));
        int seq[] = new int[n+1];
        int totalProfit = 0;
        for (int i = 0; i < n; i++) {
            int temp = jobs[i].deadline;
            while (seq[temp] != 0 && temp > 0) temp--;
            if (temp > 0) {
                seq[temp] = jobs[i].no;
                totalProfit += jobs[i].profit;
            }
        }

        System.out.println("Job Sequence: ");
        for (int i = 1; i <= m; i++)
            if (seq[i] != 0) System.out.print(seq[i] + " ");
        System.out.println("\nTotal Profit: " + totalProfit);
    }
}
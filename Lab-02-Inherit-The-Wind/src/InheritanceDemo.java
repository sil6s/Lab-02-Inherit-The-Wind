import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();

        // Create 3 Worker instances
        workers.add(new Worker("John", "Doe", "W001", "Mr.", 1990, 15.0));
        workers.add(new Worker("Jane", "Smith", "W002", "Ms.", 1985, 18.0));
        workers.add(new Worker("Bob", "Johnson", "W003", "Mr.", 1995, 14.5));

        // Create 3 SalaryWorker instances
        workers.add(new SalaryWorker("Alice", "Brown", "S001", "Mrs.", 1988, 20.0, 52000));
        workers.add(new SalaryWorker("Charlie", "Davis", "S002", "Mr.", 1992, 22.0, 58000));
        workers.add(new SalaryWorker("Eva", "Wilson", "S003", "Ms.", 1987, 25.0, 65000));

        // Simulate 3 weekly pay periods
        double[] weeklyHours = {40.0, 50.0, 40.0};

        for (int week = 0; week < 3; week++) {
            System.out.println("Week " + (week + 1) + " (Hours worked: " + weeklyHours[week] + ")");
            System.out.println("---------------------------------------");

            for (Worker worker : workers) {
                System.out.println(worker.getFirstName() + " " + worker.getLastName() + ":");
                System.out.println(worker.displayWeeklyPay(weeklyHours[week]));
                System.out.println();
            }

            System.out.println();
        }
    }
}
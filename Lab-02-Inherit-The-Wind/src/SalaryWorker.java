public class SalaryWorker extends Worker {
    private double annualSalary;

    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate, double annualSalary) {
        super(firstName, lastName, ID, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52.0;
    }

    @Override
    public String displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        return String.format("Weekly Pay: $%.2f (based on annual salary of $%.2f)", weeklyPay, annualSalary);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + annualSalary;
    }

    @Override
    public String toJSON() {
        return super.toJSON().replace("}", String.format(",\"annualSalary\":%.2f}", annualSalary));
    }

    @Override
    public String toXML() {
        return super.toXML().replace("</person>", String.format("<annualSalary>%.2f</annualSalary></person>", annualSalary));
    }
}
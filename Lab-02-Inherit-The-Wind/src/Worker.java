public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate) {
        super(firstName, lastName, ID, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyPayRate;
        } else {
            return (40 * hourlyPayRate) + ((hoursWorked - 40) * hourlyPayRate * 1.5);
        }
    }

    public String displayWeeklyPay(double hoursWorked) {
        double regularPay = Math.min(hoursWorked, 40) * hourlyPayRate;
        double overtimePay = Math.max(0, hoursWorked - 40) * hourlyPayRate * 1.5;
        double totalPay = regularPay + overtimePay;

        return String.format("Hours Worked: %.2f\n" +
                        "Regular Pay (40 hours): $%.2f\n" +
                        "Overtime Pay: $%.2f\n" +
                        "Total Pay: $%.2f",
                hoursWorked, regularPay, overtimePay, totalPay);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + hourlyPayRate;
    }

    @Override
    public String toJSON() {
        return super.toJSON().replace("}", String.format(",\"hourlyPayRate\":%.2f}", hourlyPayRate));
    }

    @Override
    public String toXML() {
        return super.toXML().replace("</person>", String.format("<hourlyPayRate>%.2f</hourlyPayRate></person>", hourlyPayRate));
    }
}
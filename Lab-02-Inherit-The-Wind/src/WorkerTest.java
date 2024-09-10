import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    private Worker worker;

    @BeforeEach
    void setUp() {
        worker = new Worker("John", "Doe", "W001", "Mr.", 1990, 15.0);
        System.out.println("\nTest worker created: " + worker.getFirstName() + " " + worker.getLastName());
        System.out.println("----------------------------------------");
    }

    @Test
    void testCalculateWeeklyPay() {
        System.out.println("Testing calculateWeeklyPay method:");
        double pay40 = worker.calculateWeeklyPay(40.0);
        System.out.println("Weekly pay for 40 hours: $" + pay40);
        assertEquals(600.0, pay40, 0.01);

        double pay45 = worker.calculateWeeklyPay(45.0);
        System.out.println("Weekly pay for 45 hours: $" + pay45);
        assertEquals(712.5, pay45, 0.01);
        System.out.println("----------------------------------------");
    }

    @Test
    void testDisplayWeeklyPay() {
        System.out.println("Testing displayWeeklyPay method:");
        String display40 = worker.displayWeeklyPay(40.0);
        System.out.println("Display for 40 hours:\n" + display40);
        String expected40Hours = "Hours Worked: 40.00\n" +
                "Regular Pay (40 hours): $600.00\n" +
                "Overtime Pay: $0.00\n" +
                "Total Pay: $600.00";
        assertEquals(expected40Hours, display40);

        System.out.println("\n");  // Add extra space between 40 and 45 hour displays

        String display45 = worker.displayWeeklyPay(45.0);
        System.out.println("Display for 45 hours:\n" + display45);
        String expected45Hours = "Hours Worked: 45.00\n" +
                "Regular Pay (40 hours): $600.00\n" +
                "Overtime Pay: $112.50\n" +
                "Total Pay: $712.50";
        assertEquals(expected45Hours, display45);
        System.out.println("----------------------------------------");
    }

    @Test
    void testToCSV() {
        System.out.println("Testing toCSV method:");
        String csv = worker.toCSV();
        System.out.println("CSV output: " + csv);
        assertEquals("W001,John,Doe,Mr.,1990,15.0", csv);
        System.out.println("----------------------------------------");
    }

    @Test
    void testToJSON() {
        System.out.println("Testing toJSON method:");
        String json = worker.toJSON();
        System.out.println("JSON output: " + json);
        assertEquals("{\"ID\":\"W001\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"title\":\"Mr.\",\"YOB\":1990,\"hourlyPayRate\":15.00}", json);
        System.out.println("----------------------------------------");
    }

    @Test
    void testToXML() {
        System.out.println("Testing toXML method:");
        String xml = worker.toXML();
        System.out.println("XML output: " + xml);
        assertEquals("<person><ID>W001</ID><firstName>John</firstName><lastName>Doe</lastName><title>Mr.</title><YOB>1990</YOB><hourlyPayRate>15.00</hourlyPayRate></person>", xml);
        System.out.println("----------------------------------------");
    }
}
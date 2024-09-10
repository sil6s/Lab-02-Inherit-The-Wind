import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    // Constructor
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getID() { return ID; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getYOB() { return YOB; }
    public void setYOB(int YOB) { this.YOB = YOB; }

    // Additional Methods
    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear - YOB);
    }

    public String getAge(int year) {
        return String.valueOf(year - YOB);
    }

    public String toCSV() {
        return String.format("%s,%s,%s,%s,%d", ID, firstName, lastName, title, YOB);
    }

    public String toJSON() {
        return String.format("{\"ID\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"YOB\":%d}",
                ID, firstName, lastName, title, YOB);
    }

    public String toXML() {
        return String.format("<person><ID>%s</ID><firstName>%s</firstName><lastName>%s</lastName><title>%s</title><YOB>%d</YOB></person>",
                ID, firstName, lastName, title, YOB);
    }

    @Override
    public String toString() {
        return String.format("Person{ID='%s', firstName='%s', lastName='%s', title='%s', YOB=%d}",
                ID, firstName, lastName, title, YOB);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB &&
                firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                ID.equals(person.ID) &&
                title.equals(person.title);
    }
}
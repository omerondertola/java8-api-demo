package tr.com.tolaas.java8.stream.demo;

import java.util.LinkedList;
import java.util.List;

public class Programmer {

    private String firstName;
    private String lastName;
    private int locPerMonth;
    private List<String> programmingLanguages = new LinkedList<>();
    private int laptops;
    private int seniorityLevel;

    public Programmer() {
    }

    public Programmer(String firstName, String lastName, int locPerMonth, List<String> programmingLanguages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.locPerMonth = locPerMonth;
        this.programmingLanguages = programmingLanguages;
    }

    public Programmer(String firstName, String lastName, int locPerMonth, List<String> programmingLanguages, int laptops) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.locPerMonth = locPerMonth;
        this.programmingLanguages = programmingLanguages;
        this.laptops = laptops;
    }

    public Programmer(String firstName, String lastName, int locPerMonth, List<String> programmingLanguages, int laptops, int seniorityLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.locPerMonth = locPerMonth;
        this.programmingLanguages = programmingLanguages;
        this.laptops = laptops;
        this.seniorityLevel = seniorityLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getLocPerMonth() {
        return locPerMonth;
    }

    public void setLocPerMonth(int locPerMonth) {
        this.locPerMonth = locPerMonth;
    }

    public List<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(List<String> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public int getLaptops() {
        return laptops;
    }

    public void setLaptops(int laptops) {
        this.laptops = laptops;
    }

    public int getSeniorityLevel() {
        return seniorityLevel;
    }

    public void setSeniorityLevel(int seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", locPerMonth=" + locPerMonth +
                ", programmingLanguages=" + programmingLanguages +
                ", laptops=" + laptops +
                ", seniorityLevel=" + seniorityLevel +
                '}';
    }
}

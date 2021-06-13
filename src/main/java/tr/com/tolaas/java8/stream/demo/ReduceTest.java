package tr.com.tolaas.java8.stream.demo;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ReduceTest {

    @Test
    public void testMultiplication() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7);

        Integer reduce = numbers.stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println("Multiplication: "+reduce);
    }

    @Test
    public void testMultiplication2() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7);

        Optional<Integer> reduce = numbers.stream()
                .reduce((a, b) -> a * b);

        System.out.println("Is Present "+ reduce.isPresent());
        System.out.println("Multiplication: "+reduce.get());
    }

    @Test
    public void testMultiplication3() {
        List<Integer> numbers = Arrays.asList();

        Optional<Integer> reduce = numbers.stream()
                .reduce((a, b) -> a * b);

        System.out.println("Is Present "+ reduce.isPresent());
        System.out.println("Multiplication: "+reduce.get());
    }

    @Test
    public void testFindMaxLocProgrammer() {
        List<Programmer> programmerList = ProgrammerDatabase.getProgrammerList();
        Optional<Programmer> best = programmerList.stream()
                .reduce((p1, p2) -> p1.getLocPerMonth() > p2.getLocPerMonth() ? p1 : p2);
        if(best.isPresent()) {
            System.out.println("Highest LOC Programmer: "+best);
        } else {
            System.out.println("No LOC Programmer Found: ");
        }
    }

    @Test
    public void testReduceTotalMonthlyLoc() {
        List<Programmer> programmerList = ProgrammerDatabase.getProgrammerList();
        Integer reduce = programmerList.stream()
                .reduce(0, (totalLoc, programmer) -> totalLoc + programmer.getLocPerMonth(),
                        (loc1, loc2) -> {
                            System.out.println("LOC1= "+ loc1+" LOC2= " + loc2);
                            return loc1;
                        });
        System.out.println("Reduced: "+reduce);
    }

    @Test
    public void testReduceTotalMonthlyLoc2() {
        Integer reduce = ProgrammerDatabase.getProgrammerList()
                .stream()
                .peek(p -> System.out.println(p))
                .reduce(0,
                        (loc, programmer) -> loc + programmer.getLocPerMonth(),
                        (a,b)->b);
        System.out.println("Reduced to: "+reduce);
    }

    @Test
    public void testReduceProgrammerWithMaxLanguages() {
        Optional<Programmer> programmer = ProgrammerDatabase.getProgrammerList()
                .stream()
                .reduce((p1, p2) -> p1.getProgrammingLanguages().size() > p2.getProgrammingLanguages().size() ? p1 : p2);
        System.out.println("Most Langugages: " + programmer.get());
    }

    @Test
    public void testMonthlyLocSecondVersion() {
        LinkedList<List<String>> langs = ProgrammerDatabase.getProgrammerList()
                .stream()
                .reduce(new LinkedList<List<String>>(),
                        (languages, programmer) -> {
                            languages.add(programmer.getProgrammingLanguages());
                            return languages;
                        },
                        (a, b) -> a
                );
        System.out.printf("allLangs ? "+langs);
    }

    @Test
    public void testNoOfLaptops() {
        Integer numberOfLaptops = ProgrammerDatabase.getProgrammerList().stream() // Stream<Programmer>
                .map(Programmer::getLaptops) // Stream<Integer>
                .reduce(0, (a, b) -> a + b);
        System.out.println("Laptops: "+numberOfLaptops);
    }

    @Test
    public void testNoOfLaptops2() {
        Integer numberOfLaptops = ProgrammerDatabase.getProgrammerList().stream() // Stream<Programmer>
                .map(Programmer::getLaptops) // Stream<Integer>
                .reduce(0, Integer::sum);
        System.out.println("Laptops: "+numberOfLaptops);
    }

    @Test
    public void testNoOfSeniorLaptopsAll() {
        Integer numberOfLaptops = ProgrammerDatabase.getProgrammerList().stream() // Stream<Programmer>
                .filter(p -> p.getSeniorityLevel() >= 3)
                .map(Programmer::getLaptops) // Stream<Integer>
                .reduce(0, Integer::sum);
        System.out.println("Laptops: "+numberOfLaptops);
    }

    @Test
    public void testNoOfProductiveSeniorLaptops() {
        Integer numberOfLaptops = ProgrammerDatabase.getProgrammerList().stream() // Stream<Programmer>
                .filter(p -> p.getSeniorityLevel() >= 3)
                .filter(p -> p.getLocPerMonth() > 3000)
                .map(Programmer::getLaptops) // Stream<Integer>
                .reduce(0, Integer::sum);
        System.out.println("Laptops: "+numberOfLaptops);
    }
}

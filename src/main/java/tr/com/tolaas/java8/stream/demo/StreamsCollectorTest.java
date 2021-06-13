package tr.com.tolaas.java8.stream.demo;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class StreamsCollectorTest {

    @Test
    public void testCollectorsJoining() {
        String joinedNames = ProgrammerDatabase.getProgrammerList().stream()
                .map(Programmer::getFirstName)
                .collect(joining());

        System.out.println(joinedNames);
    }

    @Test
    public void testCollectorsJoiningSecondForm() {
        String joinedNames = ProgrammerDatabase.getProgrammerList().stream()
                .map(Programmer::getFirstName)
                .collect(joining("-"));

        System.out.println(joinedNames);
    }

    @Test
    public void testCollectorsJoiningThirdForm() {
        String joinedNames = ProgrammerDatabase.getProgrammerList().stream()
                .map(Programmer::getFirstName)
                .collect(joining("-","<",">"));

        System.out.println(joinedNames);
    }

    @Test
    public void testCollectorsJoiningThirdForm2() {
        String joinedNames = ProgrammerDatabase.getProgrammerList().stream()
                .map(Programmer::getFirstName)
                .collect(joining("-","<",">"));

        System.out.println(joinedNames);
    }

    @Test
    public void testCounting() {
        List<Programmer> programmers = ProgrammerDatabase.getProgrammerList();
        Long count = programmers.stream()
                .filter(programmer -> programmer.getLaptops() > 3)
                .collect(counting());
        System.out.println("Count of programmers : "+ count);
    }

    @Test
    public void testMappingCollector() {
        List<Programmer> programmers = ProgrammerDatabase.getProgrammerList();
        Set<String> programmerNames = programmers.stream()
                .collect(mapping(Programmer::getFirstName, toSet()));
        System.out.println(programmerNames);
    }

    @Test
    public void testMappingCollector2() {
        List<Programmer> programmers = ProgrammerDatabase.getProgrammerList();

        Map<String, List<String>> map = programmers.stream()
                .collect(mapping(Function.identity(),
                        toMap(p -> p.getFirstName(), p -> p.getProgrammingLanguages())));

        System.out.println(map);
    }

    @Test
    public void testMinByYoungestProgrammer() {
        List<Programmer> programmerList = ProgrammerDatabase.getProgrammerList();
        Optional<Programmer> collect = programmerList.stream()
                .collect(minBy(Comparator.comparing(Programmer::getLaptops)));
        System.out.println(collect);

        Optional<Programmer> collect2 = programmerList.stream()
                .collect(maxBy(Comparator.comparing(Programmer::getLaptops)));
        System.out.println(collect2);
    }

    @Test
    public void testSummingIntCollector() {
        Integer sum = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(summingInt(i->i));
        System.out.println("sum is "+ sum);

        Integer sumLaptops = ProgrammerDatabase.getProgrammerList()
                .stream()
                .collect(summingInt(Programmer::getLaptops));
        System.out.println("Laptop Count: "+ sumLaptops);

        Double averageLaptops = ProgrammerDatabase.getProgrammerList()
                .stream()
                .collect(averagingInt(Programmer::getLaptops));
        System.out.println("Average Laptops" + averageLaptops);

    }
}

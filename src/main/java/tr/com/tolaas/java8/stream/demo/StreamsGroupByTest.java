package tr.com.tolaas.java8.stream.demo;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamsGroupByTest {

    @Test
    public void testGroupBy1() {
        ProgrammerDatabase.getProgrammerList()
                .stream()
                .collect(groupingBy(p-> p.getLocPerMonth()))
                .forEach((key, value) -> System.out.println(key + " -> "+value));
    }

    @Test
    public void testGroupBySeniority() {
        ProgrammerDatabase.getProgrammerList()
                .stream()
                .collect(groupingBy(p -> p.getSeniorityLevel(), Collectors.toSet()))
                .forEach((key,value) -> System.out.println(key+" -> "+value));
    }

    @Test
    public void testDoubleGroupBy() {
        Map<Integer, Map<String, List<Programmer>>> collect = ProgrammerDatabase.getProgrammerList()
                .stream()
                .collect(groupingBy(Programmer::getSeniorityLevel,
                        groupingBy(Programmer::getLastName)));

        System.out.println(collect);
    }

    @Test
    public void testGroupingByNMaxBy() {
        Map<Integer, Optional<Programmer>> bestProgrammers = ProgrammerDatabase.getProgrammerList()
                .stream()
                .collect(groupingBy(
                        Programmer::getSeniorityLevel,
                        maxBy(Comparator.comparing(Programmer::getLocPerMonth))
                ));

        System.out.println(bestProgrammers);
    }

    @Test
    public void testGroupingByNMaxByNCollectingThen() {
        Map<Integer, Programmer> bestProgrammers = ProgrammerDatabase.getProgrammerList()
                .stream()
                .collect(groupingBy(
                        Programmer::getSeniorityLevel,
                        collectingAndThen(maxBy(Comparator.comparing(Programmer::getLocPerMonth)),
                                Optional::get)));

        System.out.println(bestProgrammers);
    }

    @Test
    public void testGroupByThirdForm() {
        LinkedHashMap<Integer, Optional<Programmer>> collect = ProgrammerDatabase.getProgrammerList()
                .stream()
                .collect(groupingBy(Programmer::getSeniorityLevel,
                        LinkedHashMap::new,
                        minBy(Comparator.comparing(Programmer::getLaptops)))
                );

        System.out.println(collect);
    }
}

package tr.com.tolaas.java8.stream.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StreamsAnyMatchAllMatchNonMatchTest {

    @Test
    public void testAllMatch() {
        List<Integer> numbers = Arrays.asList(1, 4, 98, 34, 24, 325, 12, 2, 5, 7);

        boolean allMatch = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.printf("All are greater than 0: "+allMatch);
    }

    @Test
    public void testAnyMatch() {
        List<Integer> numbers = Arrays.asList(1, 4, 98, 34, 24, 325, 12, 2, 5, 7);

        boolean anyMatch = numbers.stream()
                .anyMatch(n -> n % 2 == 1);
        System.out.printf("Any one of is odd: "+anyMatch);
    }

    @Test
    public void testNoneMatch() {
        List<Programmer> programmerList = ProgrammerDatabase.getProgrammerList();
        boolean noneMatch = programmerList.stream()
                .noneMatch(p -> p.getProgrammingLanguages().size() == 0);

        System.out.println("All programmers know at least one language: "+noneMatch);
    }
}

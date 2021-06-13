package tr.com.tolaas.java8.stream.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitNSkipFunctionsTest {

    @Test
    public void testStreamsLimit() {
        List<Integer> numbers = Arrays.asList(1, 43, 12, 98, 67, 5, 5, 2, 1, -10, 101);

        Optional<Integer> minValue = numbers.stream()
                .limit(4)
                .peek(n -> System.out.println("number is "+n))
                .reduce((a, b) -> a < b ? a : b);

        System.out.printf("MIN VALUE = "+minValue);
    }

    @Test
    public void testStreamsSkip() {
        List<Integer> numbers = Arrays.asList(1, 43, 12, 98, 67, 5, 5, 2, 1, -10, 101);

        Optional<Integer> minValue = numbers.stream()
                .skip(4)
                .peek(n -> System.out.println("number is "+n))
                .reduce((a, b) -> a < b ? a : b);

        System.out.printf("MIN VALUE = "+minValue);
    }

    @Test
    public void testStreamsSkipSummation() {
        List<Integer> numbers = Arrays.asList(1, 43, 12, 98, 67, 5, 5, 2, 1, -10, 101);

        Optional<Integer> minValue = numbers.stream()
                .skip(4)
                .peek(n -> System.out.println("number is "+n))
                .reduce((a,b) -> Math.abs(a) + Math.abs(b));

        System.out.printf("MIN VALUE = "+minValue);
    }

}

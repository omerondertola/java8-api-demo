package tr.com.tolaas.java8.stream.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxTest {

    @Test
    public void testMaxNumberInList() {
        List<Integer> numbers = Arrays.asList(12, 42, 5, 98, 4, 7, 1, 32, 45);

        Integer maxNumber = numbers.parallelStream()
                .peek(p -> System.out.println("Value: "+p))
                .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println("Max: "+maxNumber);
    }

    @Test
    public void textMaxOptional() {
        List<Integer> numbers = Arrays.asList(12, 42, 5, 98, 4, 7, 1, 32, 45);

        Optional<Integer> maxNumber = numbers.parallelStream()
                .peek(p -> System.out.println("Value: "+p))
                .reduce((a, b) -> a > b ? a : b);
        System.out.println("Max: "+maxNumber);
        System.out.println("Max: "+maxNumber.isPresent());
        System.out.println("Max: "+maxNumber.get());

    }

    @Test
    public void textMaxOptionalEmpty() {
        List<Integer> numbers = Arrays.asList();

        Optional<Integer> maxNumber = numbers.stream()
                .peek(p -> System.out.println("Value: "+p))
                .reduce((a, b) -> a > b ? a : b);
        System.out.println("Max: "+maxNumber);
        System.out.println("Max: "+maxNumber.isPresent());
        System.out.println("Max: "+maxNumber.get());

    }

    @Test
    public void testMinOfNumbers() {
        List<Integer> numbers = Arrays.asList(1, 43, 12, 98, 67, 5, 5, 2, 1, -10, 101);

        Integer minValue = numbers.stream()
                .peek(n -> System.out.println("number is "+n))
                .reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);

        System.out.printf("MIN VALUE = "+minValue);
    }

    @Test
    public void testMinOfNumbersOptional() {
        List<Integer> numbers = Arrays.asList(1, 43, 12, 98, 67, 5, 5, 2, 1, -10, 101);

        Optional<Integer> minValue = numbers.stream()
                .peek(n -> System.out.println("number is "+n))
                .reduce((a, b) -> a < b ? a : b);

        System.out.printf("MIN VALUE = "+minValue);
    }

}

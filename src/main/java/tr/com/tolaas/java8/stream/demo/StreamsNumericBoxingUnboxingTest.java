package tr.com.tolaas.java8.stream.demo;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsNumericBoxingUnboxingTest {

    @Test
    public void testBoxing() {
        List<Integer> collect = IntStream.rangeClosed(1, 10)
                // int
                .boxed()
                // Integer
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testUnBoxing() {
        List<Integer> intList = IntStream.rangeClosed(1, 10)
                // int
                .boxed()
                // Integer
                .collect(Collectors.toList());

        int sum = intList.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(intList);
        System.out.println(sum);
    }

    @Test
    public void testMapToObj() {
        List<Integer> listOfIntegers = IntStream.rangeClosed(1, 10)
                .mapToObj((i) -> {
                    return new Integer(i);
                }).collect(Collectors.toList());
        System.out.println(listOfIntegers);
    }

    @Test
    public void testMapToLong() {
        long sum = IntStream.rangeClosed(1, 10)
                .mapToLong((i) -> i)
                .sum();
        System.out.println("Sum of Longs: "+sum);
    }

    @Test
    public void testMapToDouble() {
        double sum = IntStream.rangeClosed(1, 10)
                .mapToDouble((i) -> i)
                .sum();
        System.out.println("Sum of Double's: "+sum);
    }


}

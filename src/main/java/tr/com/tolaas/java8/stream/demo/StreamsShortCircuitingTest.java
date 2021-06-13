package tr.com.tolaas.java8.stream.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

public class StreamsShortCircuitingTest {

    @Test
    public void testShortCircuiting() {
        List<Integer> numbers = List.of(1, 2,3,4,56,7,8,12,43,53, 12, 45);
        numbers.stream()
                .peek(p-> System.out.println("Value: "+p))
                .forEach(System.out::println);
    }
}

package tr.com.tolaas.java8.stream.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamsNumericStreamsTest {

    @Test
    public void testIntStream() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> reduce = numbers.stream()
                .reduce((a, b) -> a + b);
        System.out.println(reduce);
    }

    @Test
    public void testIntStream2() {
        int sum = IntStream.rangeClosed(1, 6).sum();
        System.out.println(sum);
    }

    @Test
    public void testIntStream3() {
        long count = IntStream.rangeClosed(1, 6).count();
        System.out.printf("Count = "+count);
    }

    @Test
    public void testIntStream4() {
        IntStream intStream = IntStream.range(1, 50);
        System.out.println("Count = "+intStream.count());
        IntStream.range(1,50).forEach(System.out::println);
    }

    @Test
    public void testLongStream() {
        LongStream longStream = LongStream.rangeClosed(1, 50);
        System.out.println("Count = "+longStream.count());
        LongStream.range(1,50).forEach(System.out::println);
    }

    @Test
    public void testDoubleStream() {
        IntStream intStream = IntStream.range(1, 50);
        System.out.println("Count = "+intStream.count());
        IntStream.range(1,50).asDoubleStream().forEach(System.out::println);
    }

    @Test
    public void testIntStreamAggregateSum() {
        IntStream intStream = IntStream.rangeClosed(1, 50);
        System.out.println("SUM = "+intStream.sum());
    }

    @Test
    public void testIntStreamAggregateMax() {
        IntStream intStream = IntStream.rangeClosed(1, 50);
        System.out.println("SUM = "+intStream.max().getAsInt());
        System.out.println("SUM = "+IntStream.rangeClosed(1,50).max());
    }

    @Test
    public void testIntStreamAggregateMin() {
        IntStream intStream = IntStream.rangeClosed(40, 50);
        System.out.println("Min Value = "+intStream.min());
    }

    @Test
    public void testDoubleStreamAggregateAverage() {
        DoubleStream intStream = IntStream.rangeClosed(40, 50).asDoubleStream();
        System.out.println("Average Value = "+intStream.average());
    }

}

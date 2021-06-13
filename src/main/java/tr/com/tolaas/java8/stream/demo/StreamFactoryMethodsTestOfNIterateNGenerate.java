package tr.com.tolaas.java8.stream.demo;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFactoryMethodsTestOfNIterateNGenerate {

    @Test
    public void testOfMethod() {
        Stream.of("Ömer Önder Tola","Sadık", "Cemal", "Peren", "Merve", "Bülent")
                .forEach(System.out::println);
    }

    @Test
    public void testIterateMethod() {
        Stream.iterate(1L, x -> x*2)
                .peek(x -> System.out.println(x))
                .limit(65)
                .collect(Collectors.toSet());
    }

    @Test
    public void testIterateMethod2() {
        Stream.iterate(1L, x -> x+1)
                .peek(x -> System.out.println(x))
                .limit(100)
                .collect(Collectors.toSet());
    }

    @Test
    public void testGenerateMethod() {
        Stream.generate( () -> new Random().nextInt())
                .limit(10)
                .forEach(System.out::println);
    }
}

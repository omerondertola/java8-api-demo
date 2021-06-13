package tr.com.tolaas.java8.stream.demo;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsParallelTest {

    public static void testParallelProcess() {
        long startTime = System.currentTimeMillis();
        List<String> uniqueLangs = ProgrammerDatabase.getProgrammerList()
                .stream()
                .parallel()
                .map(Programmer::getProgrammingLanguages)
                .flatMap(list -> list.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(uniqueLangs);
        System.out.println(elapsedTime);
    }

    public static void testSequentialProcess() {
        long startTime = System.currentTimeMillis();
        List<String> uniqueLangs = ProgrammerDatabase.getProgrammerList()
                .stream()
                .map(Programmer::getProgrammingLanguages)
                .flatMap(list -> list.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(uniqueLangs);
        System.out.println(elapsedTime);
    }

    public static void main(String[] args) {
        StreamsParallelTest.testParallelProcess();

        StreamsParallelTest.testSequentialProcess();
    }
}

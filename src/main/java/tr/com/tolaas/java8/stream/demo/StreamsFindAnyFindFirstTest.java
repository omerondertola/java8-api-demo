package tr.com.tolaas.java8.stream.demo;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class StreamsFindAnyFindFirstTest {

    @Test
    public void testFindAny() {
        Optional<Programmer> angularProgrammer = ProgrammerDatabase.getProgrammerList()
                .parallelStream()
                .filter(p -> p.getProgrammingLanguages().contains("Angular"))
                .findAny();

        System.out.printf("Dart Programmer: "+angularProgrammer);
    }

    @Test
    public void testFindFirst() {
        Optional<Programmer> angularProgrammer = ProgrammerDatabase.getProgrammerList()
                .stream()
                .filter(p -> p.getProgrammingLanguages().contains("Angular"))
                .findFirst();

        System.out.printf("Dart Programmer: "+angularProgrammer);
    }
}

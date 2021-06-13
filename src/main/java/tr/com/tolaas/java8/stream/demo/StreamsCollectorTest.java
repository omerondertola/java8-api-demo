package tr.com.tolaas.java8.stream.demo;

import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.joining;

public class StreamsCollectorTest {

    @Test
    public void testCollectorsJoining() {
        String joinedNames = ProgrammerDatabase.getProgrammerList().stream()
                .map(Programmer::getFirstName)
                .collect(joining());

        System.out.println(joinedNames);
    }

    @Test
    public void testCollectorsJoiningSecondForm() {
        String joinedNames = ProgrammerDatabase.getProgrammerList().stream()
                .map(Programmer::getFirstName)
                .collect(joining("-"));

        System.out.println(joinedNames);
    }

    @Test
    public void testCollectorsJoiningThirdForm() {
        String joinedNames = ProgrammerDatabase.getProgrammerList().stream()
                .map(Programmer::getFirstName)
                .collect(joining("-","<",">"));

        System.out.println(joinedNames);
    }

    @Test
    public void testCollectorsJoiningThirdForm2() {
        String joinedNames = ProgrammerDatabase.getProgrammerList().stream()
                .map(Programmer::getFirstName)
                .collect(joining("-","<",">"));

        System.out.println(joinedNames);
    }
}

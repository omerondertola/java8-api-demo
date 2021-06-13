package tr.com.tolaas.java8.stream.demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ProgrammerDatabase {

    private static List<Programmer> programmerList = new LinkedList<>();

    static {
        List<String> otolaLangs = Arrays.asList("C","C++","Java","Dart","JavaScript","React");
        Programmer otola = new Programmer("Ömer Önder","Tola",3000, otolaLangs, 5, 5);
        programmerList.add(otola);

        List<String> cemalLangs = Arrays.asList("C","C++","Java","Dart","JavaScript");
        Programmer cemal = new Programmer("Cemal","Kopcagöz",5000, cemalLangs,7,5);
        programmerList.add(cemal);

        List<String> sadıkLangs = Arrays.asList("C","C++","Java","Dart","JavaScript","Angular");
        Programmer sadık = new Programmer("Sadık","Atalay",4000, sadıkLangs, 4,2);
        programmerList.add(sadık);

        List<String> lazyLangs = Arrays.asList("Java");
        Programmer lazyProgrammer = new Programmer("Lazy","Coder",500, lazyLangs,2, 1);
        programmerList.add(lazyProgrammer);

        List<String> bestLangs = Arrays.asList("Java","JavaScript","C");
        Programmer bestProgrammer = new Programmer("Best","Coder",10000, bestLangs, 6, 4);
        programmerList.add(bestProgrammer);

        List<String> webLangs = Arrays.asList("JavaScript","React","Angular","HTML","Bootstrap");
        Programmer webProgrammer = new Programmer("Web","Developer",4000, webLangs, 2, 3);
        programmerList.add(webProgrammer);
    }

    public static List<Programmer> getProgrammerList() {
        return programmerList;
    }
}

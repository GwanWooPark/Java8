package park.java8.chapter2._02;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class App {

    public static void main(String[] args) {

        List<String> name = new ArrayList<>();
        name.add("park");
        name.add("kwan");
        name.add("toby");
        name.add("foo");

        name.forEach(System.out::println);
        Spliterator<String> spliterator = name.spliterator();
        while (spliterator.tryAdvance(System.out::println));
    }
}

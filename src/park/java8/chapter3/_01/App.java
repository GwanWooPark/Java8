package park.java8.chapter3._01;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        // stream: 연속된 데이터들을 처리하는 operation들의 모임

        List<String> names = new ArrayList<>();
        names.add("park");
        names.add("kwan");
        names.add("toby");
        names.add("foo");

        List<String> collect = names.parallelStream().map(s -> {
                    System.out.println(s + " " + Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .collect(Collectors.toList());

        collect.forEach(System.out::println);

    }
}

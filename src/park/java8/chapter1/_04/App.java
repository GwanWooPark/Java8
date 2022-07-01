package park.java8.chapter1._04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        // 스태틱 메소드 참조(타입::스태틱 메소드)
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("park"));

        // 특정 객체의 인스턴스 메소드 참조(객체 레퍼런스::인스턴스 메소드)
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("park"));

        // 생성자 참조(입력값이 없는 생성자, 타입::new)
        Supplier<Greeting> newGreeting = Greeting::new;
        System.out.println(newGreeting.get().getName());

        // 생성자 참조(입력 값이 있는 생성자)
        Function<String, Greeting> functionGreeting = Greeting::new;
        System.out.println(functionGreeting.apply("Park").getName());

        // 임의 객체의 인스턴스 메소드 참조
        String[] names = {"park", "kwan", "woo"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

    }
}

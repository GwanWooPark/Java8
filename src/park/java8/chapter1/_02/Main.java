package park.java8.chapter1._02;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {

//        일반적인 방법
//        Plus10 plus10 = new Plus10();
//        System.out.println(plus10.apply(10));

        Function<Integer, Integer> plus10 = i -> i + 10;
        Function<Integer, Integer> mul2 = i -> i * 2;

        System.out.println(plus10.apply(1));
        System.out.println(mul2.apply(2));

        // Higher-Order Function
        // mul 적용 후 plus
        Function<Integer, Integer> mulAndPlus = plus10.compose(mul2);
        System.out.println(mulAndPlus.apply(10));

        // plus 적용 후 mul
        Function<Integer, Integer> plusAndMul = plus10.andThen(mul2);
        System.out.println(plusAndMul.apply(10));

        // Consumer
        Consumer<Integer> printT = i -> System.out.println(i + 10);
        printT.accept(43);

        // Supplier(값을 받기만 함)
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        // Predicate(boolean)
        Predicate<String> startsWithPark = s -> s.startsWith("park");
        Predicate<Integer> isOdd = i -> i % 2 == 1;
        System.out.println(startsWithPark.test("test"));
        System.out.println(isOdd.test(9));

        // UnaryOperator(입력 값의 타입과 반환 값의 타입이 같고 입력 값이 하나일 때)
        UnaryOperator<Integer> plus5 = i -> i + 5;

    }
}

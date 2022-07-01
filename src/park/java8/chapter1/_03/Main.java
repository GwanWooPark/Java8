package park.java8.chapter1._03;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();

    }

    private void run() {
        int baseNumber = 10;

        // TODO: 섀도잉 (클래스 안의 변수와 상위 Scope안의 변수 명이 같을 때 클래스 변수가 적용 됨)

        // 로컬 클래스 (섀도잉 O)
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 20;
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스 (섀도잉 O)
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };

        // 람다 (섀도잉 X: 람다를 감싼 클래스와 Scope가 같기 때문에)
        IntConsumer printInt = i -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(30);
        integerConsumer.accept(30);

    }
}

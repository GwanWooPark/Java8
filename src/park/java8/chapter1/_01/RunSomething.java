package park.java8.chapter1._01;

// 추상 메서드가 하나만 있으면 함수형 인터페이스
@FunctionalInterface
public interface RunSomething {

    int doIt(int number);

    static void printName() {
        System.out.println("Park");
    }

    default void printAge() {
        System.out.println("28");
    }

}

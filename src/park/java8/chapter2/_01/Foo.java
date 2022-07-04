package park.java8.chapter2._01;

// interface안의 모든 메소드는 public
public interface Foo {

    void printName();

    /**
     * @implSpec
     * 이 구현체는 getName으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    };

    String getName();
}

package park.java8.chapter1._02;

import java.util.function.Function;

// 1번째 값: 입력 값
// 2번째 값: 반환 값
public class Plus10 implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}

package park.java8.chpater07._01;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)
public @interface Chicken {

// 1. TYPE_PARAMETER : 타입 변수에 어노테이션 사용 가능
    // 2. TYPE_USE : TYPE_PARAMETER 보다 넓은 범위

    String value();
}

# Java8
자바8 공부


## 1. 함수형 인터페이스와 람다 표현식

###  함수형 인터페이스 (Functional Interface)
- 추상 메소드를 오직 한 개만 가지고 있는 인터페이스 
  - <b>default, static</b> 메소드는 선언되어 있어도 함수형 인터페이스에 영향을 미치지 않는다.
- @FunctionalInterface Annotation을 가지고 있는 인터페이스
- 함수를 <b style="color:red">일급 객체</b>처럼 다룰 수 있다.

  <b>일급 객체</b>
  - 변수에 값을 할당할 수 있어야 함
  ~~~javascript
  let sum = function (a, b){
        return a + b;
  };
  ~~~
  - 다른 함수의 파라미터로 넘겨줄 수 있어야 함
  ~~~javascript
  // 고차함수
  function mul(num) {
        return num * num;
  }
  
  function func(mul, num)  {
        return mul(num);
  }

  let result = func(mul, 2); // 4
  ~~~
  - 함수의 반환 값이 될 수 있어야 함
  ~~~javascript
  // 고차함수
  function plus(a) {
        return function (b) {
            return a + b;
    };
  }
  
  plus(3)(5); // 8
  ~~~~

### 람다 표현식(Lambda Expression)
- 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
- 코드를 줄일 수 있다.
- 메소드 매개변수, 리턴 타입, 변수로 만들어 사용할 수도 있다.

### 자바에서의 함수형 프로그래밍
- 함수를 <b>First class object(일급 객체)</b>로 사용할 수 있다.
- 순수 함수(Pure function)
  - 사이트 이펙트가 없다.(함수 밖에 있는 값을 변경하지 않는다.)
  - 상태가 없다.(함수 밖에 있는 값을 사용하지 않는다.)
- 고차 함수(Higher-Order Function)
  - 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수도 있다.
- 불변성

| 개념                      | 설명                                                              | 적용 예시              |
|-------------------------|-----------------------------------------------------------------|--------------------|
| Function<T, R>          | T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스                                   | R apply(T t)       |
| BiFunction<T, U, R>     | 두 개의 값 (T, U)를 받아서 R 타입을 리턴하는 함수 인터페이스                          | R apply(T t, U u)  |
| Consumer\<T>            | T 타입을 받아서 아무 값도 리턴하지 않는 함수 인터페이스                                | void Accept(T t)   |
| Supplier\<T>            | T 타입의 값을 제공하는 함수 인터페이스                                          | T get()            |
| Predicate\<T>           | T 타입을 받아서 boolean을 리턴하는 함수 인터페이스                                | boolean test (T t) |
| UnaryOperator\<T>       | Function<T,R>의 특수한 형태로, 입력 값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스      |                    |
| BinaryOperator<T, U, R> | BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입력 값 두개를 받아 리턴하는 함수 인터페이스 |                    |


### 람다 표현식
- 람다(Lambda)
  - Expression: (인자 리스트) -> { 바디 }
  - 인자 리스트
    - 인자가 없을 때: ()
    - 인자가 한개 일 때: (args) 괄호 생략 가능하다.
    - 인자가 여러 개 일 때: (a, b)
    - 인자의 타입은 컴파일러가 추론하기 때문에 생략 가능하지만,명시해도 된다.
  - 바디
    - 화살표 오른쪽에 함수 본문을 작성한다.
    - 여러 줄인 경우에 {}를 사용해서 묶는다.
    - 한 줄인 경우에는 {} 생략 가능하며, return도 생략 가능하다.
~~~java
@FunctionalInterface
public interface UseLambda { 
    int add(int a, int b);

    static void printName() {
        System.out.println("Park");
    }
    
    default void printAge() {
        System.out.println("28");
    }
}

public class Main {
    public static void main(String[] args) {
        
        // 람다 표현식
        UseLambda useLambda = (a, b) -> a + b;
        System.out.println(useLambda.add(5, 10)); 
        useLambda.printAge();
        UseLambda.printName();
        // result
        // 15
        // Park
        // 28
    }
}
~~~

### 메소드 레퍼런스
- 메소드 참조 방법 <!--형태 의미 부연 설명 필요-->
  - 스태틱 메소드 참조 (타입::스태틱 메소드)
    - Ex) ```StringUtils::cpapitalize```
    - 함수 내의 static 메소드에만 사용 가능
  - 특정 개체의 인스턴스 메소드 참조 (객체 레퍼런스::인스턴스 메소드)
    - Ex) ```ClassName::hello```
  - 임의 객체의 인스턴스 메소드 참조(타입::인스턴스 메소드)
    - Ex) ```String::compareToIgnoreCase```
  - 생성자 참조(타입::new)
    - Ex) ```Constructor::new```


## 2. 인터페이스의 변화

### 기본 메소드 (Default Methods)
- 인터페이스에 메소드 선언이 아니라 구현체를 제공하는 방법
- 해당 인터페이스를 구현한 클래스를 깨트리지 않고 새 기능을 추가할 수 있다.
- 기본 메소드는 구현체가 모르게 추가된 기능으로 그만큼 리스크가 있다.
  - 컴파일 에러는 아니지만 구현체에 따라 런타임 에러 발생 가능
  - 반드시 문서화 (Ex ```@implSpec```)
- Object가 제공하는 기능(equals, hashCode 등)은 기본 메소드로 제공할 수 없다.
  - 구현체가 재정의 해야함
- 본인이 수정할 수 있는 인터페이스만 기본 메소드를 제공할 수 있다.
- 인터페이스를 상속받는 인터페이스에서 다시 추상 메소드로 변경할 수 있다.
- 인터페이스 구현체가 재정의 할 수도 있다.

### 스태틱 메소드
- 해당 타입 관련 헬터 또는 유틸리티 메소드를 제공할 때 인터페이스에 스태틱 메소드를 제공할 수 있다.


## 3. Stream

### Stream
- Stream이라는 것은 **데이터**가 아닌 연속된 **데이터를 처리**하는 오퍼레이션들의 모임
- Function in nature (Stream이 처리하는 데이터 소스를 변경하지 않는다.)
- 스트림으로 처리하는 데이터는 오직 한 번만 처리
- 중개 오퍼레이션은 근본적으로 Lazy
- 손쉽게 병렬 처리할 수 있다

### 중개 오퍼레이션
- **Stream을 리턴** (정의)
- Stateless, Stateful 오퍼레이션으로 더 상세하게 구분할 수도 있다(대부분은 Stateless)
- distinct나 sorted 처럼 이전 이전 소스 데이터를 참조해야하는 오퍼레이션은 Statueful

### 종료 오퍼레이션
- **Stream을 리턴하지 않음**

### 스트림 파이프라인
- 0 또는 다수의 중개 오퍼레이션과 한 개의 종료 오퍼레이션으로 구성됨
- 스트림의 데이터 소스는 오직 종료 오퍼레이션을 실행할 때에만 처리한다.

### 자주 쓰이는 Stream API

| API                                                                                                                                 | 기능               | 
|-------------------------------------------------------------------------------------------------------------------------------------|------------------|
| Filter(Predicate<? super T> predicate)                                                                                              | 걸러내기             | 
| Map(Function<? super T,? extends R> mapper)<br/> FlatMap(Function<? super T,? extends Stream<? extends R>> mapper)                  | 변경하기             |
| generate(Supplier<T> s), iterate(T seed, UnaryOperator<T> f)                                                                        | 생성하기             | 
| limit(long maxSize), skip(long n)                                                                                                   | 제한하기             | 
| anyMatch(Predicate<? super T> predicate)<br/>allMatch(Predicate<? super T> predicate)<br/>noneMatch(Predicate<? super T> predicate) | 스트림 안의 데이터 조건 판별 |
| reduce(reference 참고)<br/>collect(reference 참고)<br/>sum()<br/>max(Comparator<? super T> comparator)                                  | 스트림을 데이터 하나로 뭉치기 |
| count()                                                                                                                             | 개수 세기            |






---
## Reference
- 백기선, 더 자바, Java 8(인프런 PDF 자료 참고)
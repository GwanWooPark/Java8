# Java8
자바8 공부

## 1. 함수형 인터페이스와 람다 표현식

###  함수형 인터페이스 (Functional Interface)
- 추상 메소드를 오직 한 개만 가지고 있는 인터페이스 
- @FunctionalInterface Annotation을 가지고 있는 인터페이스

### 람다 표현식(Lambda Expression)
- 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
- 코드를 줄일 수 있다.
- 메소드 매개변수, 리턴 타입, 변수로 만들어 사용할 수도 있다.

### 자바에서의 함수형 프로그래밍
- 함수를 First class object로 사용할 수 있다.
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

### 메소드 레퍼런스
- 메소드 참조 방법 <!--형태 의미 부연 설명 필요-->
  - 스태틱 메소드 참조 (타입::스태틱 메소드)
    - Ex) ```StringUtils::cpapitalize```
    - 함수 내의 static 메소드에만 사용 가능
  - 특정 개체의 인스턴스 메소드 참조 (객체 레퍼런스::인스턴스 메소드)
    - Ex) ```Method::hello```
  - 임의 객체의 인스턴스 메소드 참조(타입::인스턴스 메소드)
  - 생성자 참조(타입::new)


## 2. 인터페이스의 변화

### 기본 메소드 (Default Methods)
- 인터페이스에 메소드 선언이 아니라 구현체를 제공하는 방법
- 해당 인터페이스를 구현한 클래스를 깨트리지 않고 새 기능을 추가할 수 있다.
- 기본 메소드는 구현체가 모르게 추가된 기능으로 그만큼 리스크가 있다.
  - 컴파일 에러는 아니지만 구현체에 따라 런타임 에러 발생 가능
  - 반드시 문서화 (Ex ```@implSpec``)
- Object가 제공하는 기능(equals, hashCode 등)은 기본 메소드로 제공할 수 없다.
  - 구현체가 재정의 해야함
- 본인이 수정할 수 있는 인터페이스만 기본 메소드를 제공할 수 있다.
- 인터페이스를 상속받는 인터페이스에서 다시 추상 메소드로 변경할 수 있다.
- 인터페이스 구현체가 재정의 할 수도 있다.

### 스태틱 메소드
- 해당 타입 관련 헬터 또는 유틸리티 메소드를 제공할 때 인터페이스에 스태틱 메소드를 제공할 수 있다.

---
## Reference
- 백기선, 더 자바, Java 8(인프런 PDF 자료 참고)
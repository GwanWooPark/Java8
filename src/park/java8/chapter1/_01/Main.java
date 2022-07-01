package park.java8.chapter1._01;

public class Main {
    public static void main(String[] args) {

//        // 익명 내부 클래스 (anonymous inner class)
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("Hello, Java8");
//            }
//        };

        // Lambda Expression
        // 2줄이면 {} 안에 작성해야함
        RunSomething runSomething = number -> {
            return number + 10;
        };

        System.out.println(runSomething.doIt(20));
    }
}

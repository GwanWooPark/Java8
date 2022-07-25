package park.java8.chpater6._04;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 비동기 작업 실행 가능
//        CompletableFuture<String> future = CompletableFuture.completedFuture("park");

        // 리턴 타입이 없는 경우
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            System.out.println("Hello " + Thread.currentThread().getName());
//        });


        // Callback을 get 호출 전에 정의할 수 있다.
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello   " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply(
                // thenApply: 리턴된 결과 값을 다른 타입으로 변환
                String::toUpperCase);


        System.out.println(future.get());

    }
}

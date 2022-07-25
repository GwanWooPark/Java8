package park.java8.chpater6._05;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Hello " + Thread.currentThread().getName());
//            return "Hello";
//        });
//
//        // Hello가 끝난뒤 World를 해야한다. (따로따로 실행하는 방법)
//        CompletableFuture<String> future = hello.thenCompose(App::getWorld);
//        System.out.println(future.get());
//    }
//
//    private static CompletableFuture<String> getWorld(String message) {
//        return CompletableFuture.supplyAsync(() -> {
//            System.out.println("World " + Thread.currentThread().getName());
//            return message + " World";
//        });


//        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Hello " + Thread.currentThread().getName());
//            return "Hello";
//        });
//
//        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
//            System.out.println("World " + Thread.currentThread().getName());
//            return "World";
//        });
//
//        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> {
//            return h + " " + w;
//        });
//        System.out.println(future.get());


//        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Hello " + Thread.currentThread().getName());
//            return "Hello";
//        });
//
//        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
//            System.out.println("World " + Thread.currentThread().getName());
//            return "World";
//        });
//
//        // 둘중에 먼저 끝나는 것 실행
//        CompletableFuture<Void> future = CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
//        future.get();

        boolean throwError = false;
//
//        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
//            if (throwError) {
//                throw new IllegalArgumentException("에러");
//            }
//
//            System.out.println("Hello " + Thread.currentThread().getName());
//            return "Hello";
//        }).exceptionally(ex -> {
//            System.out.println(ex);
//            return "Error";
//        });
//
//        System.out.println(hello.get());

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException("에러");
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, throwable) -> {
            if (throwable != null) {
                return "ERROR";
            }
            return result;
        });

        System.out.println(hello.get());
    }
}

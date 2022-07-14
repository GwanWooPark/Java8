package park.java8.chpater6._03;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

//        Callable<String> hello = () -> {
//            Thread.sleep(2000L);
//            return "Hello";
//        };
//
//        Future<String> helloFuture = executorService.submit(hello);
//        System.out.println(helloFuture.isDone());
//        System.out.println("Started!");
//
//        // 블록킹
////        helloFuture.get();
//        // 현재 진행중인 작업을 interrupt하면서 종료 (true)
//        // 현재 진행중인 작업을 기다렸다 종료 (false)
//        helloFuture.cancel(true);
//
//        System.out.println(helloFuture.isDone());
//        System.out.println("End!");
//

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> park = () -> {
            Thread.sleep(1000L);
            return "Park";
        };

//        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, park));
//        for (Future<String> future : futures) {
//            System.out.println(future.get());
//
//        }

        String s = executorService.invokeAny(Arrays.asList(hello, java, park));
        System.out.println(s);

        executorService.shutdown();
    }
}

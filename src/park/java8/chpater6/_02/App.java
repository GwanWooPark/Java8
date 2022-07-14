package park.java8.chpater6._02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {

        // Executors: Thread를 만들거나 관리하는 작업을 고수준의 API에게 위임
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        executorService.submit(() -> {
//            System.out.println("Thread " + Thread.currentThread().getName());
//        });
        // 작업의 완료를 기다리고 종료 시킨다.
//        executorService.shutdown();
        // 작업의 완료와 상관없이 종료 시킨다.
//        executorService.shutdownNow();

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(getRunnable("Hello"));
//        executorService.submit(getRunnable("Park"));
//        executorService.submit(getRunnable("Thread"));
//        executorService.submit(getRunnable("In"));
//        executorService.submit(getRunnable("Java"));

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);

        executorService.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + " " + Thread.currentThread().getName());
    }
}

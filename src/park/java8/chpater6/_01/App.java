package park.java8.chpater6._01;

public class App {

    public static void main(String[] args) throws InterruptedException {


        // 2. Runnable 구현 or 람다
        Thread thread = new Thread(() -> {

            System.out.println("Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalArgumentException(e);
            }
        });
        thread.start();

//        MyThread myThread = new MyThread();
//        myThread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
        thread.join();
        System.out.println(thread + " is finished");
    }

    // 1. 불편하게 쓰레드 생성 방법(Thread 상속)
    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }

}

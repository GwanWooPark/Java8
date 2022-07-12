package park.java8.chpater5._01;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Date date = new Date();
        // 기계용 시간
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

//        Thread.sleep(1000 * 5);
//        Date after5Seconds = new Date();
//        System.out.println(after5Seconds);
//        after5Seconds.setTime(time);
//        // Immutable
//        System.out.println(after5Seconds);

        // Type safety 하지 않다.
        // 숫자가 -100 이나 100이 들어올 수도 있음
        Calendar myBirthday = new GregorianCalendar(1995, Calendar.OCTOBER, 16);
        System.out.println(myBirthday.getTime());


    }
}

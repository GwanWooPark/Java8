package park.java8.chpater07._01;

import java.util.Arrays;

@Chicken("양념")
@Chicken("후라이드")
public class App {

    public static void main(String[] args) {

        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> System.out.println(c.value()));

        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });
    }

//    static class FeelsLikeChicken<@Chicken T> {
//
//        public static <C> void print(C c) {
//
//
//        }
//    }
}

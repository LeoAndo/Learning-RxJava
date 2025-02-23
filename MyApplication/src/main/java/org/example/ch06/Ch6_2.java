package org.example.ch06;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class Ch6_2 {
    public static void main(String[] args) {
        var subscribe = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                .map(Ch6_2::intenseCalculation)
                .subscribe(System.out::println);
        var subscribe1 = Observable.range(1, 6)
                .map(Ch6_2::intenseCalculation)
                .subscribe(System.out::println);

        subscribe.dispose();
        subscribe1.dispose();
    }

    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
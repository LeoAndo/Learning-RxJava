package org.example.ch06;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Ch6_5 {
    public static void main(String[] args) {
        var subscribe = Observable.interval(1, TimeUnit.SECONDS)
                .map(Ch6_5::intenseCalculation)
                .subscribe(System.out::println);
        sleep(Long.MAX_VALUE);

        subscribe.dispose();
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
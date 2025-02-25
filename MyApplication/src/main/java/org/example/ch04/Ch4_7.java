package org.example.ch04;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch4_7 {
    public static void main(String[] args) {
        var intervalArguments =
                Observable.just(2, 3, 10, 7);
        var subscribe = intervalArguments.flatMap(i ->
                Observable.interval(i, TimeUnit.SECONDS)
                        .map(i2 -> i + "s interval: " + ((i + 1) * i) + " seconds elapsed")
        ).subscribe(System.out::println);
        sleep(12000);

        subscribe.dispose();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
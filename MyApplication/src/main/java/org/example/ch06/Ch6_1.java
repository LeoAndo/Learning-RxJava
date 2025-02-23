package org.example.ch06;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch6_1 {
    public static void main(String[] args) {
        var subscribe = Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> i + " Mississippi")
                .subscribe(System.out::println);
        sleep(5000);

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
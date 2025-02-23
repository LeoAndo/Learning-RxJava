package org.example.ch01;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch1_3 {
    public static void main(String[] args) {
        var secondIntervals =
                Observable.interval(1, TimeUnit.SECONDS);
        var subscribe = secondIntervals.subscribe(System.out::println);
        /* Hold main thread for 5 secondsso Observable above has chance to fire */
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
package org.example.ch04;

import io.reactivex.Observable;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class Ch4_14 {
    public static void main(String[] args) {
        var strings =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        var seconds = Observable.interval(1, TimeUnit.SECONDS);
        var subscribe = Observable.zip(strings, seconds, (s, l) -> s)
                .subscribe(s -> System.out.println("Received " + s + " at " + LocalTime.now()));
        sleep(6000);

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
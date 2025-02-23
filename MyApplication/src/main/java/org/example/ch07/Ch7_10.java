package org.example.ch07;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch7_10 {
    public static void main(String[] args) {
        var subscribe = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300) // map to elapsed time
                .window(1, TimeUnit.SECONDS)
                .flatMapSingle(obs -> obs.reduce("", (total,
                                                      next) -> total
                        + (total.isEmpty() ? "" : "|") + next))
                .subscribe(System.out::println);
        sleep(5000);

        subscribe.dispose();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
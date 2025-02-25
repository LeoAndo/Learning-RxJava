package org.example.ch06;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch6_19 {
    public static void main(String[] args) {
        var d = Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(() -> System.out.println("Disposing on thread"
                                + Thread.currentThread().getName()))
                .subscribe(i -> System.out.println("Received " +
                        i));
        sleep(3000);
        d.dispose();
        sleep(3000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
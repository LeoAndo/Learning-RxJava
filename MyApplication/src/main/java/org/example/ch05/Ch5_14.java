package org.example.ch05;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch5_14 {
    public static void main(String[] args) {
        var seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .publish()
                        .autoConnect();
//Observer 1
        var subscribe = seconds.subscribe(i -> System.out.println("Observer 1: " +
                i));
        sleep(3000);
//Observer 2
        var subscribe1 = seconds.subscribe(i -> System.out.println("Observer 2: " +
                i));
        sleep(3000);

        subscribe.dispose();
        subscribe1.dispose();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
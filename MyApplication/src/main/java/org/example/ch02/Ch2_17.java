package org.example.ch02;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch2_17 {
    public static void main(String[] args) {
        var subscribe = Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println(s + " Mississippi"));
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
package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_21 {
    public static void main(String[] args) {
        var empty = Observable.never();
        var subscribe = empty.subscribe(System.out::println,
                Throwable::printStackTrace,
                () -> System.out.println("Done!"));
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
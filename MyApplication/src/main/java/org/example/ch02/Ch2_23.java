package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_23 {
    public static void main(String[] args) {
        var subscribe = Observable.error(() -> new Exception("Crash and burn!"))
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));
        subscribe.dispose();
    }
}
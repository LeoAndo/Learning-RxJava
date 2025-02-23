package org.example.ch03;

import io.reactivex.Observable;

public class Ch3_8 {
    public static void main(String[] args) {
        var subscribe = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                .distinct(String::length)
                .subscribe(i -> System.out.println("RECEIVED: " + i));

        subscribe.dispose();
    }
}
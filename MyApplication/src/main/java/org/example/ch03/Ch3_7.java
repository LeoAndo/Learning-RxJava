package org.example.ch03;

import io.reactivex.Observable;

public class Ch3_7 {
    public static void main(String[] args) {
        var subscribe = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                .map(String::length)
                .distinct()
                .subscribe(i -> System.out.println("RECEIVED: " + i));
        subscribe.dispose();
    }
}
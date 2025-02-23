package org.example.ch03;

import io.reactivex.Observable;

public class Ch3_21 {
    public static void main(String[] args) {
        var subscribe = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                .repeat(2)
                .subscribe(s -> System.out.println("Received: " + s));

        subscribe.dispose();
    }
}
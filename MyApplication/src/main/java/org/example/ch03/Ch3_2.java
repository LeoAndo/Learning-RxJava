package org.example.ch03;

import io.reactivex.Observable;

public class Ch3_2 {
    public static void main(String[] args) {
        var subscribe = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .take(3)
                .subscribe(s -> System.out.println("RECEIVED: " + s));

        subscribe.dispose();
    }
}
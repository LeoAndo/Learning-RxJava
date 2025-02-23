package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_8 {
    public static void main(String[] args) {
        var source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        var subscribe = source.map(String::length).filter(i -> i >= 5)
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));
        subscribe.dispose();
    }
}
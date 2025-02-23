package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_10 {
    public static void main(String[] args) {
        var source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        var subscribe = source.map(String::length).filter(i -> i >= 5)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
        subscribe.dispose();
    }
}
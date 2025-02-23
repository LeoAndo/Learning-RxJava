package org.example.ch03;

import io.reactivex.Observable;

import java.util.HashSet;

public class Ch3_39 {
    public static void main(String[] args) {
        var subscribe = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                .collect(HashSet::new, HashSet::add)
                .subscribe(s -> System.out.println("Received: " + s));
        subscribe.dispose();
    }
}
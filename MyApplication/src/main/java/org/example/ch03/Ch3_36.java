package org.example.ch03;

import io.reactivex.Observable;

import java.util.concurrent.ConcurrentHashMap;

public class Ch3_36 {
    public static void main(String[] args) {
        var subscribe = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                .toMap(s -> s.charAt(0), String::length,
                        ConcurrentHashMap::new)
                .subscribe(s -> System.out.println("Received: " + s));
        subscribe.dispose();
    }
}
package org.example.ch03;

import io.reactivex.Observable;

public class Ch3_51 {
    public static void main(String[] args) {
        var subscribe = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                .doOnComplete(() -> System.out.println("Source is done emitting!"))
                .map(String::length)
                .subscribe(i -> System.out.println("Received: " + i));

        subscribe.dispose();
    }
}
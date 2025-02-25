package org.example.ch03;

import io.reactivex.Observable;

public class Ch3_54 {
    public static void main(String[] args) {
        var subscribe = Observable.just(5, 3, 7, 10, 2, 14)
                .reduce((total, next) -> total + next)
                .doOnSuccess(i -> System.out.println("Emitting: " + i))
                .subscribe(i -> System.out.println("Received: " + i));

        subscribe.dispose();
    }
}
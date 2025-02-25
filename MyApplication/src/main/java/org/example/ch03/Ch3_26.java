package org.example.ch03;

import io.reactivex.Observable;

public class Ch3_26 {
    public static void main(String[] args) {
        var subscribe = Observable.just(5, 3, 7, 10, 2, 14)
                .reduce("", (total, next) -> total + (total.equals("") ?
                        "" :
                        ",") + next)
                .subscribe(s -> System.out.println("Received: " +
                        s));

        subscribe.dispose();
    }
}
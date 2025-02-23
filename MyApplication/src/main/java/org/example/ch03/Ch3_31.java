package org.example.ch03;

import io.reactivex.Observable;

public class Ch3_31 {
    public static void main(String[] args) {
        var subscribe = Observable.range(1, 1000)
                .toList(1000)
                .subscribe(s -> System.out.println("Received: " + s));

        subscribe.dispose();
    }
}
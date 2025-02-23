package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_15 {
    public static void main(String[] args) {
        var subscribe = Observable.range(1, 10)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
        subscribe.dispose();
    }
}
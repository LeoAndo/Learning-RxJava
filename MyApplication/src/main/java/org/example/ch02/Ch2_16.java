package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_16 {
    public static void main(String[] args) {
        var subscribe = Observable.range(5, 10)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
        subscribe.dispose();
    }
}
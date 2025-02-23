package org.example.ch03;

import io.reactivex.Observable;

public class Ch3_4 {
    public static void main(String[] args) {
        var subscribe = Observable.range(1, 100)
                .skip(90)
                .subscribe(i -> System.out.println("RECEIVED: " + i));

        subscribe.dispose();
    }
}
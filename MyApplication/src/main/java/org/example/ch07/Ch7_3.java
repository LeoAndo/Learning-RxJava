package org.example.ch07;

import io.reactivex.Observable;

public class Ch7_3 {
    public static void main(String[] args) {
        var subscribe = Observable.range(1, 10)
                .buffer(3, 1)
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}
package org.example.ch07;

import io.reactivex.Observable;

public class Ch7_4 {
    public static void main(String[] args) {
        var subscribe = Observable.range(1, 10)
                .buffer(2, 1)
                .filter(c -> c.size() == 2)
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}
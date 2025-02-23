package org.example.ch03;

import io.reactivex.Observable;

public class Ch3_44 {
    public static void main(String[] args) {
        var subscribe = Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> {
                    try {
                        return 10 / i;
                    } catch (ArithmeticException e) {
                        return -1;
                    }
                })
                .subscribe(i -> System.out.println("RECEIVED: " +
                                i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );

        subscribe.dispose();
    }
}
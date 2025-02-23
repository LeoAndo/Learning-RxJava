package org.example.ch03;

import io.reactivex.Observable;

/**
 * RECEIVED: 1
 * RECEIVED: 2
 * RECEIVED: 3
 * RECEIVED: 2
 * RECEIVED: 1
 */
public class Ch3_9 {
    public static void main(String[] args) {
        var subscribe = Observable.just(1, 1, 1, 2, 2, 3, 3, 2, 1, 1)
                .distinctUntilChanged()
                .subscribe(i -> System.out.println("RECEIVED: " + i));

        subscribe.dispose();
    }
}
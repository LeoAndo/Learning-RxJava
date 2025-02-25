package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_27 {
    public static void main(String[] args) {
        var subscribe = Observable.fromCallable(() -> 1 / 0)
                .subscribe(i -> System.out.println("Received: " + i),
                        e -> System.out.println("Error Captured: " + e));
        subscribe.dispose();
    }
}
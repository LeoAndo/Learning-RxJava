package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_20 {
    public static void main(String[] args) {
        var empty = Observable.empty();
        var subscribe = empty.subscribe(System.out::println,
                Throwable::printStackTrace,
                () -> System.out.println("Done!"));
        subscribe.dispose();
    }
}
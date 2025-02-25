package org.example.ch02;

import io.reactivex.Single;

public class Ch2_28 {
    public static void main(String[] args) {
        var subscribe = Single.just("Hello")
                .map(String::length)
                .subscribe(System.out::println,
                        Throwable::printStackTrace);
        subscribe.dispose();
    }
}
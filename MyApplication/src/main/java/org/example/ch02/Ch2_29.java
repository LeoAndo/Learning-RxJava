package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_29 {
    public static void main(String[] args) {
        var source =
                Observable.just("Alpha", "Beta", "Gamma");
        var subscribe = source.first("Nil") //returns a Single
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}
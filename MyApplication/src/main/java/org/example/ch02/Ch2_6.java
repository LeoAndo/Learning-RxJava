package org.example.ch02;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class Ch2_6 {
    public static void main(String[] args) {
        List<String> items =
                Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        var source = Observable.fromIterable(items);
        var subscribe = source.map(String::length).filter(i -> i >= 5)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
        subscribe.dispose();
    }
}
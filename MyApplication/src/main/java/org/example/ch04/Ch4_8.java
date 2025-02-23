package org.example.ch04;

import io.reactivex.Observable;

public class Ch4_8 {
    public static void main(String[] args) {
        var source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        var subscribe = source.flatMap(s -> Observable.fromArray(s.split("")),
                        (s, r) ->
                                s + "-" + r)
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}
package org.example.ch07;

import io.reactivex.Observable;

public class Ch7_9 {
    public static void main(String[] args) {
        var subscribe = Observable.range(1, 50)
                .window(2, 3)
                .flatMapSingle(obs -> obs.reduce("", (total,
                                                      next) -> total
                        + (total.isEmpty() ? "" : "|") + next))
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}
package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_1 {
    public static void main(String[] args) {
        var source = Observable.create(emitter -> {
            // - `emitter.onNext("Alpha")` などを呼び出してデータ（`String`）を1つずつ流す。
            emitter.onNext("Alpha");
            emitter.onNext("Beta");
            emitter.onNext("Gamma");
            emitter.onNext("Delta");
            emitter.onNext("Epsilon");
            // - 最後に `emitter.onComplete()` を呼び出して、「データの送信が完了した」と通知する。
            emitter.onComplete();
        });
        var subscribe = source.subscribe(s -> System.out.println("RECEIVED: " + s));
        subscribe.dispose();
    }
}
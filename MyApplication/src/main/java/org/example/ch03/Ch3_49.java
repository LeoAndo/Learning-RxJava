package org.example.ch03;

import io.reactivex.Observable;

/**
 * 1. 3回目でもゼロ除算例外が発生した場合（例外が終了条件）、
 * `onError`イベントがトリガーされ、
 * 「RECEIVED ERROR: java.lang.ArithmeticException: / by zero」
 * という形でエラーメッセージを出力します。
 */
public class Ch3_49 {
    public static void main(String[] args) {
        var subscribe = Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                .retry(2)
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );

        subscribe.dispose();
    }
}
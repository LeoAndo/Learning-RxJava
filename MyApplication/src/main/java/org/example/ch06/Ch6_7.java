package org.example.ch06;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.Executors;

/**
 * - `executor.shutdown()` はスレッドプールを停止させ、すべてのスレッドを破棄します。
 * - この指定がなければ、スレッドプールは常に実行状態のまま残ってしまう可能性があります。
 */
public class Ch6_7 {
    public static void main(String[] args) {
        int numberOfThreads = 20;
        var executor =
                Executors.newFixedThreadPool(numberOfThreads);
        var scheduler = Schedulers.from(executor);
        var subscribe = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                .subscribeOn(scheduler)
                .doFinally(executor::shutdown)
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}
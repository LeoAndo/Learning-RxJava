package org.example.ch06;

import io.reactivex.schedulers.Schedulers;
import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

/**
 * - `blockingSubscribe` を使用しているため、
 * データ処理がすべて完了するまでメインスレッドは停止されています。
 * - このコードは、非同期処理の挙動 (例えば処理が並行して実行されるなど)
 * を学習するためのものです。
 */
public class Ch6_6 {
    public static void main(String[] args) {
        // - **`blockingSubscribe`** は購読者を登録し、
        // すべてのデータが発行され処理が完了するまで
        // 「ブロッキング」(現在のスレッドをロック)します。
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                .subscribeOn(Schedulers.computation())
                .map(Ch6_6::intenseCalculation)
                .blockingSubscribe(System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));
    }

    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
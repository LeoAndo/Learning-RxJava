package org.example.ch06;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class Ch6_3 {
    public static void main(String[] args) {
        // 1. 算術計算スケジューラー(`Schedulers.computation()`)を使用して非同期実行環境を設定。
        var subscribe = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                .subscribeOn(Schedulers.computation())
                .map(Ch6_3::intenseCalculation)
                .subscribe(System.out::println);
        var subscribe1 = Observable.range(1, 6)
                .subscribeOn(Schedulers.computation())
                .map(Ch6_3::intenseCalculation)
                .subscribe(System.out::println);
        sleep(20000);

        subscribe.dispose();
        subscribe1.dispose();
    }

    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
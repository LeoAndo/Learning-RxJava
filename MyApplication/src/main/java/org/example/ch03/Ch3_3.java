package org.example.ch03;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * `Observable.interval` はデフォルトで別スレッド上で動作し、指定した時間間隔で値（`long`型の増加するカウンタ）を生成する非同期の `Observable` を作成します。
 * この場合、300ミリ秒間隔で値（0, 1, 2, ...）が連続的に生成されます。
 * <p>
 * `take` 演算子は、指定した時間（今回は2秒）内に受信した項目のみを取り込みます。
 * そのため、合計で2秒間、最大で約7回（2秒 ÷ 300ms ≒ 7）が処理対象として生成されます
 */
public class Ch3_3 {
    public static void main(String[] args) {
        var subscribe = Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
        sleep(5000);

        subscribe.dispose();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
package org.example.ch04;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * - **`Observable.combineLatest`**:
 * - このメソッドは複数の`Observable`を受け取り、それぞれのソースが最新値を生成したときに、両方のソースの最新値を利用してデータ処理を行います。
 * - ここでは、`source1`と`source2`からの最新値を取得し、文字列として整形しています。
 * - `(l1, l2)`はそれぞれ`source1`と`source2`の最新の値を表し、それを文字列に変換して表示しています。
 * - たとえば、`source1`が`4`で`source2`が`2`の場合、出力は`SOURCE 1: 4 SOURCE 2: 2`となります。
 */
public class Ch4_15 {
    public static void main(String[] args) {
        var source1 =
                Observable.interval(300, TimeUnit.MILLISECONDS);
        var source2 =
                Observable.interval(1, TimeUnit.SECONDS);
        var subscribe = Observable.combineLatest(source1, source2,
                        (l1, l2) -> "SOURCE 1: " + l1 + " SOURCE 2: " + l2)
                .subscribe(System.out::println);
        sleep(3000);

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
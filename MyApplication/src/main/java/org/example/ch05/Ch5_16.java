package org.example.ch05;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 1. **`.replay()`**:
 * - `ReplaySubject`を使用して、すべての生成された値をキャッシュし、すべての値（キャッシュされた値＋新しい値）を新しい購読者に提供します。
 * - 例えば、3秒後に`Observer`（購読者）が購読を始めると、それまでキャッシュされてきた値も順番に再送信されます。
 * <p>
 * 2. **`.autoConnect()` **:
 * - `autoConnect()`を使うと、購読者が少なくとも1つ接続された時点で`Observable`が開始されます（データの生成がスタートします）。
 * - ただし、`.replay()`によりキャッシュされた値があるため、複数の購読者が後に接続してもすべての値を受信することができます。
 */
public class Ch5_16 {
    public static void main(String[] args) {
        var seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .replay()
                        .autoConnect();
//Observer 1
        var subscribe = seconds.subscribe(l -> System.out.println("Observer 1: " +
                l));
        sleep(3000);
//Observer 2
        var subscribe1 = seconds.subscribe(l -> System.out.println("Observer 2: " +
                l));
        sleep(3000);

        subscribe.dispose();
        subscribe1.dispose();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
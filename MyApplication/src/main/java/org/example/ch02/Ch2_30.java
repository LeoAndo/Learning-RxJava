package org.example.ch02;

import io.reactivex.Maybe;

/**
 * `Maybe` は以下3つのいずれかのイベントを発行する可能性があります：
 * 1. **1つのデータを発行する**（成功の場合）。
 * 2. **エラーを送る**。
 * 3. **何も発行せずに完了通知を送る**。
 * <p>
 * 1. `Maybe.just(100)`：1つのデータ（`100`）のみを発行して完了通知を送る。
 * 2. `Maybe.empty()`：何も発行せずに完了通知を送る。
 */
public class Ch2_30 {
    public static void main(String[] args) {
        // has emission
        var presentSource = Maybe.just(100);
        var subscribe = presentSource.subscribe(s -> System.out.println("Process 1 received:" + s),
                Throwable::printStackTrace,
                () -> System.out.println("Process 1 done!"));
        //no emission
        var emptySource = Maybe.empty();
        var subscribe1 = emptySource.subscribe(s -> System.out.println("Process 2 received:" + s),
                Throwable::printStackTrace,
                () -> System.out.println("Process 2 done!"));

        subscribe.dispose();
        subscribe1.dispose();
    }
}
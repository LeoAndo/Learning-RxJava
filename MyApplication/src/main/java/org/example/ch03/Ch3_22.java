package org.example.ch03;

import io.reactivex.Observable;

/**
 * - `scan`演算子は、累積処理を行います。この場合、前の値（`accumulator`）と現在の値（`next`）を加算し、その結果を次に渡します。
 * - 各ステップで計算された累積結果を下流に渡します。
 * - 実際の計算過程:
 * - 最初の値: `5`（最初の値そのまま）
 * - 加算: `5 + 3 = 8`
 * - 加算: `8 + 7 = 15`
 * - 加算: `15 + 10 = 25`
 * - 加算: `25 + 2 = 27`
 * - 加算: `27 + 14 = 41`
 * <p>
 * - 結果の流れ: `5, 8, 15, 25, 27, 41`
 */
public class Ch3_22 {
    public static void main(String[] args) {
        var subscribe = Observable.just(5, 3, 7, 10, 2, 14)
                .scan((accumulator, next) -> accumulator + next)
                .subscribe(s -> System.out.println("Received: " + s));

        subscribe.dispose();
    }
}
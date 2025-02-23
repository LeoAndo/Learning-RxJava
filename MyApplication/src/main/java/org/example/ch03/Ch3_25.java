package org.example.ch03;

import io.reactivex.Observable;

/**
 * 1.
 * - `reduce` 演算子は、ストリーム内の要素を累積的に処理し、1つの結果（スカラー値）にまとめる操作を行います。
 * - ここでは、ラムダ式 `(total, next) -> total + next` を使用しています。このラムダ式は、現在の合計値 `total` と次の値 `next` を加算し、次の計算に引き渡します。
 * - 結果として、この操作はストリームの全ての値を合計します。この場合、`5 + 3 + 7 + 10 + 2 + 14 = 41` です。
 * <p>
 * - **`reduce` と `scan` の違い**:
 * - `reduce` はストリームのすべてのデータを処理して、最終的な結果を1つ返します。
 * - `scan` は累積値を逐次的にストリームとして発行します。
 */
public class Ch3_25 {
    public static void main(String[] args) {
        var subscribe = Observable.just(5, 3, 7, 10, 2, 14)
                .reduce((total, next) -> total + next)
                .subscribe(s -> System.out.println("Received: " + s));

        subscribe.dispose();
    }
}
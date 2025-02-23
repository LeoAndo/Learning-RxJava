package org.example.ch03;

import io.reactivex.Observable;

/**
 * - `scan` は **アキュムレータ操作（累積処理）** を実行するオペレーターです。
 * - 初期値 `0` から始め、各ストリーム要素を次々に渡して累積処理を行います。
 * <p>
 * - 初期値 `0` が最初に処理され、次のように処理が進みます：
 * 1. 初期値 `0` が流される。
 * 2. `"Alpha"` が流れた後、`total = 0` に次の累積結果 `total + 1` が計算される。
 * 3. 次の項目 `"Beta"`, `"Gamma"`, `"Delta"`, `"Epsilon"` ごとに、累積値が1ずつ増加する。
 * <p>
 * 結果として、流される数値は以下の通り
 * ```
 * 0, 1, 2, 3, 4, 5
 * ```
 */
public class Ch3_23 {
    public static void main(String[] args) {
        var subscribe = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                .scan(0, (total, next) -> total + 1)
                .subscribe(s -> System.out.println("Received: " + s));

        subscribe.dispose();
    }
}
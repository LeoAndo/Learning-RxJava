package org.example.ch05;

import io.reactivex.Observable;

/**
 * `scan` は「畳み込み処理」を行う演算子で、ストリーム内の各要素に累積処理を適用します。この場合、累積加算 (`Integer::sum`) を行っています。
 * - 初期値 `0` を設定して、ストリームの中の数値を順次足し合わせていきます。
 * - `scan` は累積結果を含む新しい `Observable` を生成するため、ストリームの各ステップで累積結果が発行されます。
 * <p>
 * **累積結果の流れ:**
 * - 初期値: `0`
 * - `0 + 6 = 6`
 * - `6 + 2 = 8`
 * - `8 + 5 = 13`
 * - `13 + 7 = 20`
 * - `20 + 1 = 21`
 * - `21 + 4 = 25`
 * - `25 + 9 = 34`
 * - `34 + 8 = 42`
 * - `42 + 3 = 45`
 * <p>
 * 最終的な出力は次の通りです: `0, 6, 8, 13, 20, 21, 25, 34, 42, 45`
 * <p>
 * #### 3. **`.cache()` **
 * `cache` は、`Observable` が発行したデータをキャッシュし、将来のすべての購読者に対して同じデータを再利用します。
 * - このコードでは、`scan` によって作成された累積結果をキャッシュしています。
 * - キャッシュされた結果にアクセスするために何度再購読しても処理の再計算は発生せず、同じ結果が即座に返されます。
 * - `cache()` を使用することで、リソース消費の削減や再利用性の向上が期待できます。
 */
public class Ch5_19 {
    public static void main(String[] args) {
        var cachedRollingTotals =
                Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
                        .scan(0, Integer::sum)
                        .cache();
        var subscribe = cachedRollingTotals.subscribe(System.out::println);
        subscribe.dispose();
    }
}
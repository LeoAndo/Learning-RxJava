package org.example.ch07;

import io.reactivex.Observable;

/**
 * - `buffer(int count, int skip)`は、指定されたサイズとスキップ量で`Observable`からの値をバッファします。
 * - バッファのパラメータ：
 * - **`count` (2):** バッファに含める要素の数。ここでは、2つの要素が1つのバッファにまとめられます。
 * - **`skip` (3):** バッファ作成の開始地点をスキップする間隔。次のバッファは現在のバッファの先頭から3つ目の要素で開始します。
 * <p>
 * **動作の流れ:**
 * - 元の数列 (1, 2, 3, 4, 5, 6, 7, 8, 9, 10) に対して：
 * - 最初のバッファ: 1, 2 (最初の要素から2つ)
 * - 次のバッファ: 4, 5 (スキップ3後に2つ)
 * - 次のバッファ: 7, 8 (さらにスキップ3後に2つ)
 * - 次のバッファ: 10 (最後の要素は一つしか残っていないため)
 * <p>
 * - **`buffer`オペレーション**：データをチャンク（バッファ）分割するために使用されます。
 * この例では、`count=2`と`skip=3`を指定しているため、バッファの開始地点が一定数ずつスキップされながら、
 * 指定の要素数を収集します。
 */
public class Ch7_2 {
    public static void main(String[] args) {
        var subscribe = Observable.range(1, 10)
                .buffer(2, 3)
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}
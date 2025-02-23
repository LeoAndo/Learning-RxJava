package org.example.ch01;

import io.reactivex.Observable;

public class Ch1_2 {
    public static void main(String[] args) {
        var myStrings =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        // `map` はストリーム中の各要素に対して関数を適用する操作子 (operator) です。
        // ここでは、文字列 (`String`) の長さ (`length`) を計算する関数を適用しています。
        var subscribe = myStrings.map(String::length).subscribe(System.out::println);
        subscribe.dispose();
    }
}
package org.example.ch03;

import io.reactivex.Observable;

public class Ch3_13 {
    public static void main(String[] args) {
        var menu =
                Observable.just("Coffee", "Tea", "Espresso", "Latte");
//print menu
        var subscribe = menu.startWith("COFFEE SHOP MENU")
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}
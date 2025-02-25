package org.example.ch04;

import io.reactivex.Observable;

public class Ch4_6 {
    public static void main(String[] args) {
        var source =
                Observable.just("521934/2342/FOXTROT", "21962/12112/78886/TANGO", "283242/4542/WHISKEY/2348562");
        var subscribe = source.flatMap(s -> Observable.fromArray(s.split("/")))
                .filter(s -> s.matches("[0-9]+")) //use regex to filter integers
                .map(Integer::valueOf)
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}
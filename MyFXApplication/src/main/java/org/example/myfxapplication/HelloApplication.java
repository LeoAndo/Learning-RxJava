package org.example.myfxapplication;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.rxjavafx.observers.JavaFxObserver;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.application.Application;
import javafx.beans.binding.Binding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

//        foo1(stage);
//        foo2(stage);
//        foo3(stage);
        foo4(stage);
        //  foo5(stage);
        //foo6(stage);
    }

    public static void main(String[] args) {
        launch();
    }

    // Ch2_13
    private static void foo1(Stage stage) {
        ToggleButton toggleButton = new ToggleButton("TOGGLE ME");
        Label label = new Label();
        Observable<Boolean> selectedStates =
                valuesOf(toggleButton.selectedProperty());
        selectedStates.map(selected -> selected ? "DOWN" : "UP")
                .subscribe(label::setText);
        VBox vBox = new VBox(toggleButton, label);
        stage.setScene(new Scene(vBox));
        stage.show();
    }

    private static <T> Observable<T> valuesOf(final ObservableValue<T> fxObservable) {
        return Observable.create(observableEmitter -> {
            //emit initial state
            observableEmitter.onNext(fxObservable.getValue());
            //emit value changes uses a listener
            final ChangeListener<T> listener = (observableValue, prev,
                                                current) -> observableEmitter.onNext(current);
            fxObservable.addListener(listener);
        });
    }

    // Ch6_15
    private static void foo2(Stage stage) {
        VBox root = new VBox();
        ListView<String> listView = new ListView<>();
        Button refreshButton = new Button("REFRESH");
        JavaFxObservable.actionEventsOf(refreshButton)
                .observeOn(Schedulers.io())
                .flatMapSingle(a ->
                        Observable.fromArray(getResponse("https://goo.gl/S0xuOi")
                                .split("\\r?\\n")
                        ).toList()
                ).observeOn(JavaFxScheduler.platform())
                .subscribe(list ->
                        listView.getItems().setAll(list));
        root.getChildren().addAll(listView, refreshButton);
        stage.setScene(new Scene(root));
        stage.show();
    }

    private static String getResponse(String path) {
        try {
            return new Scanner(new URL(path).openStream(),
                    "UTF-8").useDelimiter("\\A").next();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // Ch7_16
    private static void foo3(Stage stage) {
        VBox root = new VBox();
        Label counterLabel = new Label("");
        ToggleButton startStopButton = new ToggleButton();
        // Multicast the ToggleButton's true/false selected state
        Observable<Boolean> selectedStates =
                JavaFxObservable.valuesOf(startStopButton.selectedProperty())
                        .publish()
                        .autoConnect(2);
        // Using switchMap() with ToggleButton's selected state willdrive
        // whether to kick off an Observable.interval(),
        // or dispose() it by switching to empty Observable
        selectedStates.switchMap(selected -> {
                    if (selected)
                        return Observable.interval(1,
                                TimeUnit.MILLISECONDS);
                    else
                        return Observable.empty();
                }).observeOn(JavaFxScheduler.platform()) // Observe on JavaFX UI thread
                .map(Object::toString)
                .subscribe(counterLabel::setText);
        // Change ToggleButton's text depending on its state
        selectedStates.subscribe(selected ->
                startStopButton.setText(selected ? "STOP" :
                        "START")
        );
        root.getChildren().addAll(counterLabel, startStopButton);
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Ch7_17
    private static void foo4(Stage stage) {
        VBox root = new VBox();
        root.setMinSize(200, 100);
        Label typedTextLabel = new Label("");
        root.getChildren().addAll(typedTextLabel);
        Scene scene = new Scene(root);
        // Multicast typed keys
        Observable<String> typedLetters =
                JavaFxObservable.eventsOf(scene,
                                KeyEvent.KEY_TYPED)
                        .map(KeyEvent::getCharacter)
                        .share();
        // Signal 300 milliseconds of inactivity
        Observable<String> restSignal =
                typedLetters
                        .throttleWithTimeout(500,
                                TimeUnit.MILLISECONDS)
                        .startWith(""); //trigger initial
        // switchMap() each period of inactivity to
        // an infinite scan() concatenating typed letters
        restSignal.switchMap(s ->
                        typedLetters.scan("", (rolling, next) -> rolling +
                                next)
                ).observeOn(JavaFxScheduler.platform())
                .subscribe(s -> {
                    typedTextLabel.setText(s);
                    System.out.println(s);
                });
        stage.setScene(scene);
        stage.show();
    }

    // Ch9_5
    // not work.
    private static void foo5(Stage stage) {
        VBox root = new VBox();
        Label label = new Label("");
        // Observable with second timer
        Observable<String> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .map(i -> i.toString())
                        .observeOn(JavaFxScheduler.platform());
        // Turn Observable into Binding
        Binding<String> binding =
                JavaFxObserver.toBinding(seconds);
        //Bind Label to Binding
        label.textProperty().bind(binding);
        root.setMinSize(200, 100);
        root.getChildren().addAll(label);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Ch9_6
    // not work
    private static void foo6(Stage stage) {
        VBox root = new VBox();
        Label label = new Label("");
        // Turn Observable into Binding
        Binding<String> binding =
                Observable.interval(1, TimeUnit.SECONDS)
                        .map(i -> i.toString())
                        .observeOn(JavaFxScheduler.platform())
                        .to(JavaFxObserver::toBinding);
        //Bind Label to Binding
        label.textProperty().bind(binding);
        root.setMinSize(200, 100);
        root.getChildren().addAll(label);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
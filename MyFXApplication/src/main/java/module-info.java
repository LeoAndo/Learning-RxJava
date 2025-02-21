module org.example.myfxapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires io.reactivex.rxjava2;
    requires rxjavafx;


    opens org.example.myfxapplication to javafx.fxml;
    exports org.example.myfxapplication;
}
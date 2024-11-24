module com.example.project2_ {
    requires javafx.controls;
    requires javafx.fxml;



    opens com.example.project2_ to javafx.fxml;
    exports com.example.project2_;
}
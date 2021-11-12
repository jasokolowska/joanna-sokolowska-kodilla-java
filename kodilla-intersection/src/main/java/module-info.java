module com.kodilla.kodillaintersection {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.kodilla.intersection to javafx.fxml;
    exports com.kodilla.intersection;
}
module com.example.demokitudjahanyadik {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demokitudjahanyadik to javafx.fxml;
    exports com.example.demokitudjahanyadik;
}
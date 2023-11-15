module com.example.f23comp1011lh1206780assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;

    opens com.example.f23comp1011lh1206780assignment2 to javafx.fxml, com.google.gson;
    exports com.example.f23comp1011lh1206780assignment2;
}
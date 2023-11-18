module com.example.f23comp1011lh1206780assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
    // added this "requires" statement for the bonus of opening the spotify URL in a browser
    requires java.desktop;

    opens com.example.f23comp1011lh1206780assignment2 to javafx.fxml, com.google.gson;
    exports com.example.f23comp1011lh1206780assignment2;
}
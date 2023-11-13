package com.example.f23comp1011lh1206780assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("music-search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Music Search");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/SpotifyLogo.png")));
        // Image sourced from: https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.m.wikipedia.org%2Fwiki%2FFile%3ASpotify_logo_without_text.svg&psig=AOvVaw2EuT44qtgsjFOdJY1CtP0X&ust=1699981530182000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCNDC9-u6wYIDFQAAAAAdAAAAABAE
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
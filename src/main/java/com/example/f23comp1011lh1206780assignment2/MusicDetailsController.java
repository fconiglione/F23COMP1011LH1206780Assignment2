package com.example.f23comp1011lh1206780assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class MusicDetailsController {

    @FXML
    private Label albumNameLabel;

    @FXML
    private Label artistNameLabel;

    @FXML
    private ImageView musicImageVIew;

    @FXML
    private Label releaseDateLabel;

    @FXML
    private Label songNameLabel;

    @FXML
    private Label trackNameLabel;

    @FXML
    void goBackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "music-search-view.fxml");
    }

    @FXML
    void playOnSpotifyButton(ActionEvent event) {

    }

}
package com.example.f23comp1011lh1206780assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.net.spi.InetAddressResolver;
import java.util.List;
import java.util.ResourceBundle;

public class MusicDetailsController implements Initializable {

    @FXML
    private Label albumNameLabel;

    @FXML
    private Label artistNameLabel;

    @FXML
    private ImageView musicImageView;

    @FXML
    private Label releaseDateLabel;

    @FXML
    private Label songNameLabel;

    @FXML
    private Label trackNameLabel;

    private Item musicItem;

    public void setItemDetails(Item item) {
        this.musicItem = item;
        songNameLabel.setText(item.getName());
        trackNameLabel.setText(item.getName());
        albumNameLabel.setText(item.getAlbum().getName());
        releaseDateLabel.setText(item.getAlbum().getReleaseDate());
        artistNameLabel.setText(item.getArtists().get(0).getName());

        // Getting the url of the image from the Image class
        Image albumImage = item.getAlbum().getImages().get(0);
        String imageUrl = albumImage.getUrl();
        try {
            // Setting the image using the retrieved url
            javafx.scene.image.Image image = new javafx.scene.image.Image(imageUrl);
            musicImageView.setImage(image);
        } catch (IllegalArgumentException e)
        {
            // setting a default image just in case an album cover image does not exist
            javafx.scene.image.Image placeholderImage = new javafx.scene.image.Image(getClass().getResourceAsStream("/images/spotify-music-placeholder.png"));
            musicImageView.setImage(placeholderImage);
        }
    }

    @FXML
    void goBackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "music-search-view.fxml");
    }

    @FXML
    void playOnSpotifyButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
package com.example.f23comp1011lh1206780assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.Desktop;
import java.util.ResourceBundle;

public class MusicDetailsController {

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
    // Declaring a music item for passing through JSON data
    private Item musicItem;

    /**
     * This method retrieves data from the selected song/item from the previous screen's listView
     * Referenced from Jaret Wright on YT: https://www.youtube.com/watch?v=Wc1a2KshJ4w
     * @param item
     */
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

    /**
     * This method changes scenes back to the search screen when the back button is clicked
     * @param event
     * @throws IOException
     */
    @FXML
    void goBackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "music-search-view.fxml");
    }

    /**
     * This method opens the spotify song's album in a new browser window when the button is clicked
     * @throws URISyntaxException
     * @throws IOException
     */
    @FXML
    void playOnSpotifyButton() throws URISyntaxException, IOException {
        String spotifyUrl = musicItem.getExternalUrls().getSpotify();
        // Opening the spotifyUrl in the default browser as a bonus
        // Referenced from: https://stackoverflow.com/questions/5226212/how-to-open-url-in-default-webbrowser-using-java
        Desktop.getDesktop().browse(new URI(spotifyUrl));
    }
}
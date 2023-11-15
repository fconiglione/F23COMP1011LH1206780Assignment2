package com.example.f23comp1011lh1206780assignment2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MusicSearchController implements Initializable {

    @FXML
    private ListView<Item> musicListView;

    @FXML
    private TextField musicSearchTextField;

    @FXML
    private Label resultsLabel;

    @FXML
    void searchMusicButton(ActionEvent event) {
        // Getting a new access token by referencing the same method in APIUtility
        String accessToken = APIUtility.getAccessToken();

        // Referencing methods from the APIUtility class to
        // search for the term entered in the text field
        String searchTerm = musicSearchTextField.getText().trim();
        APIResponse apiResponse = APIUtility.searchForTrack(accessToken, searchTerm);

        // Clearing any previous results
        musicListView.getItems().clear();

        if (!apiResponse.getTracks().getItems().isEmpty()) {
            musicListView.getItems().addAll(apiResponse.getTracks().getItems());
            resultsLabel.setText(String.valueOf(apiResponse.getTracks().getItems().size()));
        } else {
            // Providing a "No results found" scenario if there are no results from the search query
            musicListView.getItems().add(new NoResultsItem("No results found"));
            resultsLabel.setText("N/A");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
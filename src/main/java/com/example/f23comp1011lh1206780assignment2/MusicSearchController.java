package com.example.f23comp1011lh1206780assignment2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
    private Button viewDetailsButton;

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

    @FXML
    void viewDetailsButtonMethod(ActionEvent event) throws IOException {
        Item selectedItem = musicListView.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            // FXMLLoader and scene creation
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("music-details-view.fxml"));
            Parent parent = fxmlLoader.load();

            // Access the controller of the new scene and set the item details
            if (fxmlLoader.getController() instanceof MusicDetailsController) {
                MusicDetailsController controller = fxmlLoader.getController();
                controller.setItemDetails(selectedItem);
            }

            Scene scene = new Scene(parent);

            // Stage setting
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewDetailsButton.setVisible(false);

        musicListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Item>() {
            @Override
            public void changed(ObservableValue<? extends Item> observable, Item oldValue, Item newValue) {
                if (newValue != null)
                    viewDetailsButton.setVisible(true);
                else
                    viewDetailsButton.setVisible(false);
            }
        });
    }
}
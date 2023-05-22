package hust.soict.cybersec.aims.screen.controller;

import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.cybersec.aims.media.CompactDisc;
import hust.soict.cybersec.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddTrackScreenController {
    private CompactDisc CD;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSaveTrack;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;

    private boolean allFieldsFilled = false;

    
    public AddTrackScreenController(CompactDisc CD) {
        super();
        this.CD = CD;
    }

    @FXML
    void btnSaveTrackPressed(ActionEvent event) {
        String title = tfTitle.getText();
        int length = 0;
        try {
            length = Integer.parseInt(tfLength.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to parse length!");
            alert.setTitle("Wrong type");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        Track track = new Track(title, length);
        CD.addTrack(track);
        tfTitle.clear();
        tfLength.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Track has been added!");
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        btnSaveTrack.setDisable(true);
        
        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfLength.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
    }   

    private void checkFieldsFilled() {
        if (!tfTitle.getText().isEmpty() && !tfLength.getText().isEmpty()) {
            allFieldsFilled = true;
        } else {
            allFieldsFilled = false;
        }
        btnSaveTrack.setDisable(!allFieldsFilled);
    }

}

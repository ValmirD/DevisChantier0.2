/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package devischantier;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marco
 */
public class ChantierOverviewController implements Initializable {

    @FXML
    private TableView<?> idDesignationID;
    @FXML
    private TableColumn<?, ?> idDesignation;
    @FXML
    private TableColumn<?, ?> idIdentification;
    @FXML
    private Label idChantier;
    @FXML
    private Label idClient;
    @FXML
    private Label idDevis;
    @FXML
    private Label datePrevue;
    @FXML
    private Label dateEffective;
    @FXML
    private Label dateFinEffective;
    @FXML
    private Label dateFinPrevue;
    @FXML
    private Label localisation;
    @FXML
    private Label designation;
    @FXML
    private Label commentaire;
    @FXML
    private Label dateCreation;
    @FXML
    private Label validation;
    @FXML
    private Button nouveau;
    @FXML
    private Button editer;
    @FXML
    private Button supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void gererNouveau(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("ChantierFormNouveau.fxml"));
        AnchorPane camionInfo;
        try {
            camionInfo = (AnchorPane) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(camionInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gererEditer(ActionEvent event) {
    }

    @FXML
    private void gererSupprimer(ActionEvent event) {
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marco
 */
public class MainOverviewController implements Initializable {

    @FXML
    private Button chantier;
    @FXML
    private Button engins;
    @FXML
    private Button materiaux;
    @FXML
    private Button petitsMateriaux;
    @FXML
    private Button codesRef;
    @FXML
    private Button voitures;
    @FXML
    private Button camions;
    @FXML
    private Button ouvriers;
    @FXML
    private Button conducteurs;
    @FXML
    private Button clients;
    @FXML
    private Button devis;

    BorderPane rootLayout;
    Scene scene;
    Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("RootLayout.fxml"));

        try {
            rootLayout = (BorderPane) loader.load();
            scene = new Scene(loader.getRoot());
        } catch (IOException ex) {
            Logger.getLogger(MainOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afficherChantier(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("ChantierOverview.fxml"));
        AnchorPane overview;
        try {
            stage = (Stage) devis.getScene().getWindow();
            stage.setScene(scene);
            overview = (AnchorPane) loader.load();
            rootLayout.setCenter(overview);
        } catch (IOException ex) {
            Logger.getLogger(MainOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void afficherEngins(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("EnginOverview.fxml"));
        AnchorPane overview;
        try {
            stage = (Stage) devis.getScene().getWindow();
            stage.setScene(scene);
            overview = (AnchorPane) loader.load();
            rootLayout.setCenter(overview);
        } catch (IOException ex) {
            Logger.getLogger(MainOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afficherMateriaux(ActionEvent event) {
    }

    @FXML
    private void afficherPetitsMateriaux(ActionEvent event) {
    }

    @FXML
    private void afficherCodesRef(ActionEvent event) {
    }

    @FXML
    private void afficherVoitures(ActionEvent event) {
    }

    @FXML
    private void afficherCamions(ActionEvent event) {
    }

    @FXML
    private void afficherOuvriers(ActionEvent event) {
    }

    @FXML
    private void afficherConducteurs(ActionEvent event) {
    }

    @FXML
    private void afficherClients(ActionEvent event) {
    }

    @FXML
    private void afficherDevis(ActionEvent event) {
    }

}

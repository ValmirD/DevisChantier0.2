/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.dto.CamionDto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Utilitaire;

/**
 * FXML Controller class
 *
 * @author Marco
 */
public class CamionFormController implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField categorie;
    private TextField marque;
    private TextField modele;
    private TextField chassis;
    private TextField carburant;
    private TextField prix;
    private TextField tonnage;
    private TextField capacite;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    @FXML
    private Label message;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField naissance;
    @FXML
    private TextField telephone;
    @FXML
    private TextField email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void validation(ActionEvent event) {
        try {
            int ton = Integer.parseInt(tonnage.getText());
            double cap = Integer.parseInt(capacite.getText());
            double prixCamion = Integer.parseInt(prix.getText());
            CamionDto camion = new CamionDto(10000, categorie.getText(), ton, cap, marque.getText(), modele.getText(), chassis.getText(), carburant.getText(), prixCamion);
            if (Utilitaire.insertCamion(camion)) {
                message.setText("Camion ajouté avec succès !");
                Stage stage = (Stage) pane.getScene().getWindow();
                stage.close();
            } else {
                message.setText("Erreur : le camion n'a pas pu être ajouté ...!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            message.setText("Erreur : le camion n'a pas pu être ajouté !");
        }

    }

    @FXML
    private void annulation(ActionEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.dto.PetitMaterielDto;
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
 * @author Vali
 */
public class PetitMaterielFormController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField nom;
    @FXML
    private TextField type;
    @FXML
    private TextField reference;
    @FXML
    private TextField prix;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    @FXML
    private Label message;

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
            double prixPetitMateriel = Integer.parseInt(prix.getText());
            PetitMaterielDto petitMateriel = new PetitMaterielDto(10000, nom.getText(), type.getText(), reference.getText(), prixPetitMateriel);
            if (Utilitaire.insertPetitMateriel(petitMateriel)) {
                message.setText("PetitMateriel ajouté avec succès !");
                Stage stage = (Stage) pane.getScene().getWindow();
                stage.close();
            } else {
                message.setText("Erreur : le petitMateriel n'a pas pu être ajouté ...!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            message.setText("Erreur : le petitMateriel n'a pas pu être ajouté !");
        }
    }

    @FXML
    private void annulation(ActionEvent event) {
                Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package devischantier;

import db.dto.ChantierDto;
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
public class ChantierFormController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField debutPrevue;
    @FXML
    private TextField debutEffective;
    @FXML
    private TextField finPrevue;
    @FXML
    private TextField finEffective;
    @FXML
    private TextField localisation;
    @FXML
    private TextField designation;
    @FXML
    private TextField commentaire;
    @FXML
    private TextField dateCreation;
    @FXML
    private TextField validation;
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
/*        try {
            int ton = Integer.parseInt(tonnage.getText());
            double cap = Integer.parseInt(capacite.getText());
            double prixChantier = Integer.parseInt(prix.getText());
            ChantierDto chantier = new ChantierDto(10000, categorie.getText(), ton, cap, marque.getText(), modele.getText(), chassis.getText(), carburant.getText(), prixChantier);
            if (Utilitaire.insertChantier(chantier)) {
                message.setText("Chantier ajouté avec succès !");
                Stage stage = (Stage) pane.getScene().getWindow();
                stage.close();
            } else {
                message.setText("Erreur : le chantier n'a pas pu être ajouté ...!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            message.setText("Erreur : le chantier n'a pas pu être ajouté !");
        }*/
    }

    @FXML
    private void annulation(ActionEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

}

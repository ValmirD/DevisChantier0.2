/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.dto.DevisDto;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
public class DevisFormController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField statut;
    @FXML
    private DatePicker dateDevis;
    @FXML
    private TextField designation;
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
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = (java.util.Date) format.parse(dateDevis.getValue().toString());
            java.sql.Date date = new Date(parsed.getTime());
            
            DevisDto devis = new DevisDto(10000, statut.getText(), designation.getText(), date, 10000);
            if (Utilitaire.insertDevis(devis)) {
                message.setText("Devis ajouté avec succès !");
                Stage stage = (Stage) pane.getScene().getWindow();
                stage.close();
            } else {
                message.setText("Erreur : le devis n'a pas pu être ajouté ...!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            message.setText("Erreur : le devis n'a pas pu être ajouté !");
        }
    }

    @FXML
    private void annulation(ActionEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

}

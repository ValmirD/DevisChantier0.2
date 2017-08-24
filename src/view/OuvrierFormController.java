/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import db.dto.OuvrierDto;
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
public class OuvrierFormController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private DatePicker naissance;
    @FXML
    private TextField telephone;
    @FXML
    private TextField email;
    @FXML
    private TextField cout;
    @FXML
    private TextField remuneration;
    @FXML
    private DatePicker entree;
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
            double cout1 = Double.parseDouble(cout.getText());
            double remuneration1 = Double.parseDouble(remuneration.getText());

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = (java.util.Date) format.parse(entree.getValue().toString());
            java.sql.Date date = new Date(parsed.getTime());

            java.util.Date parsed2 = (java.util.Date) format.parse(naissance.getValue().toString());
            java.sql.Date date2 = new Date(parsed2.getTime());

            OuvrierDto ouvrier = new OuvrierDto(10000, remuneration1, nom.getText(), prenom.getText(), date2, telephone.getText(), email.getText(), date, cout1);

            if (Utilitaire.insertOuvrier(ouvrier)) {
                message.setText("Ouvrier ajouté avec succès !");
                Stage stage = (Stage) pane.getScene().getWindow();
                stage.close();
            } else {
                message.setText("Erreur : le ouvrier n'a pas pu être ajouté ...!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            message.setText("Erreur : le ouvrier n'a pas pu être ajouté !");
        }
    }

    @FXML
    private void annulation(ActionEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import db.business.FacadeDB;
import db.dto.EnginDto;
import db.exception.DevisChantierBusinessException;
import db.selDto.EnginSel;
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
public class EnginFormEditerController implements Initializable {

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

    private int idEngin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initVariables(int idEngin) {
        this.idEngin = idEngin;

        try {
            EnginDto engin = FacadeDB.findEnginBySel(new EnginSel(idEngin));
            nom.setText(engin.getNom());
            type.setText(engin.getType());
            reference.setText(engin.getReference());
            prix.setText(Double.toString(engin.getPrixHeure()));
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void validation(ActionEvent event) {
        try {
            double prixEngin = Double.parseDouble(prix.getText());
            EnginDto enginUpdated = new EnginDto(idEngin, nom.getText(), type.getText(), reference.getText(), prixEngin);
            if (Utilitaire.updateEngin(enginUpdated)) {
                message.setText("Engin mis à jour avec succès !");
                Stage stage = (Stage) pane.getScene().getWindow();
                stage.close();
            } else {
                message.setText("Erreur : le engin n'a pas pu être mis à jour ...!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            message.setText("Erreur : le engin n'a pas pu être mis à jour ! 2");
        }
    }

    @FXML
    private void annulation(ActionEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.business.FacadeDB;
import db.dto.CodeReferenceDto;
import db.dto.CodeReferenceDto;
import db.exception.DevisChantierBusinessException;
import db.selDto.CodeReferenceSel;
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
public class CodeReferenceFormEditerController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField reference;
    @FXML
    private TextField typeTravail;
    @FXML
    private TextField prix;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    @FXML
    private Label message;

    private int idCodeReference;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initVariables(int idCodeReference) {
        this.idCodeReference = idCodeReference;

        try {
            CodeReferenceDto codeReference = FacadeDB.findCodeReferenceBySel(new CodeReferenceSel(idCodeReference));
            reference.setText(codeReference.getReference());
            typeTravail.setText(codeReference.getTypeTravail());
            prix.setText(Double.toString(codeReference.getPrixHtva()));
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void validation(ActionEvent event) {
        try {
            double prixCodeReference = Double.parseDouble(prix.getText());
            CodeReferenceDto codeReference = new CodeReferenceDto(idCodeReference, reference.getText(), typeTravail.getText(), prixCodeReference);
            if (Utilitaire.updateCodeReference(codeReference)) {
                message.setText("CodeReference ajouté avec succès !");
                Stage stage = (Stage) pane.getScene().getWindow();
                stage.close();
            } else {
                message.setText("Erreur : le codeReference n'a pas pu être ajouté ...!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            message.setText("Erreur : le codeReference n'a pas pu être ajouté !");
        }
    }

    @FXML
    private void annulation(ActionEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

}

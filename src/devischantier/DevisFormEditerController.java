/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.business.FacadeDB;
import db.dto.DevisDto;
import db.selDto.DevisSel;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
public class DevisFormEditerController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField statut;
    @FXML
    private TextField designation;
    @FXML
    private DatePicker dateDevis;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    @FXML
    private Label message;

    private int idDevis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initVariables(int idDevis) {
        this.idDevis = idDevis;
/*
        try {
            DevisDto devis = FacadeDB.findDevisBySel(new DevisSel(idDevis));
            statut.setText(devis.getStatut());
            designation.setText(devis.getDesignationDevis());
            dateDevis.setText(devis.getDateDevis().toString());
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }*/
    }

    @FXML
    private void validation(ActionEvent event) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = (java.util.Date) format.parse(dateDevis.getValue().toString());
            java.sql.Date date = new Date(parsed.getTime());

            DevisDto devis = new DevisDto(idDevis, statut.getText(), designation.getText(), date, 10000);
            if (Utilitaire.updateDevis(devis)) {
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

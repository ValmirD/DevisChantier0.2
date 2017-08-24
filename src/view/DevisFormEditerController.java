/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import db.business.FacadeDB;
import db.dto.DevisDto;
import db.exception.DevisChantierBusinessException;
import db.selDto.DevisSel;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            DevisDto devis = FacadeDB.findDevisBySel(new DevisSel(idDevis));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = format.parse(devis.getDateDevis().toString());
            SimpleDateFormat y = new SimpleDateFormat("yyyy");
            int year = Integer.parseInt(y.format(date));
            SimpleDateFormat m = new SimpleDateFormat("MM");
            int month = Integer.parseInt(m.format(date));
            SimpleDateFormat d = new SimpleDateFormat("dd");
            int day = Integer.parseInt(d.format(date));
            LocalDate dateN = LocalDate.of(year, month, day);
            statut.setText(devis.getStatut());
            designation.setText(devis.getDesignationDevis());
            dateDevis.setValue(dateN);
         } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(ClientFormEditerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void validation(ActionEvent event) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = (java.util.Date) format.parse(dateDevis.getValue().toString());
            java.sql.Date date = new Date(parsed.getTime());         

            DevisDto devis = new DevisDto(idDevis, designation.getText(), statut.getText(), date, 1000);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.business.FacadeDB;
import db.dto.ChantierDto;
import db.exception.DevisChantierBusinessException;
import db.selDto.ChantierSel;
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
import javafx.scene.control.CheckBox;
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
public class ChantierFormEditerController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField localisation;
    @FXML
    private TextField designation;
    @FXML
    private TextField commentaire;
    @FXML
    private DatePicker debutPrevue;
    @FXML
    private DatePicker debutEffective;
    @FXML
    private DatePicker finPrevue;
    @FXML
    private DatePicker finEffective;
    @FXML
    private DatePicker dateCreation;
    @FXML
    private CheckBox validation;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    @FXML
    private Label message;

    private int idChantier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initVariables(int idChantier) {
        this.idChantier = idChantier;

        try {
            ChantierDto chantiers = FacadeDB.findChantierBySel(new ChantierSel(idChantier));

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = format.parse(chantiers.getDateDebutPrevue().toString());
            SimpleDateFormat y = new SimpleDateFormat("yyyy");
            int year = Integer.parseInt(y.format(date));
            SimpleDateFormat m = new SimpleDateFormat("MM");
            int month = Integer.parseInt(m.format(date));
            SimpleDateFormat d = new SimpleDateFormat("dd");
            int day = Integer.parseInt(d.format(date));
            LocalDate dateN = LocalDate.of(year, month, day);

            java.util.Date date2 = format.parse(chantiers.getDateDebutEffective().toString());
            SimpleDateFormat y2 = new SimpleDateFormat("yyyy");
            int year2 = Integer.parseInt(y2.format(date2));
            SimpleDateFormat m2 = new SimpleDateFormat("MM");
            int month2 = Integer.parseInt(m2.format(date2));
            SimpleDateFormat d2 = new SimpleDateFormat("dd");
            int day2 = Integer.parseInt(d2.format(date2));
            LocalDate dateN2 = LocalDate.of(year2, month2, day2);

            java.util.Date date3 = format.parse(chantiers.getDateFinPrevue().toString());
            SimpleDateFormat y3 = new SimpleDateFormat("yyyy");
            int year3 = Integer.parseInt(y3.format(date3));
            SimpleDateFormat m3 = new SimpleDateFormat("MM");
            int month3 = Integer.parseInt(m3.format(date3));
            SimpleDateFormat d3 = new SimpleDateFormat("dd");
            int day3 = Integer.parseInt(d3.format(date3));
            LocalDate dateN3 = LocalDate.of(year3, month3, day3);

            java.util.Date date4 = format.parse(chantiers.getDateFinPrevue().toString());
            SimpleDateFormat y4 = new SimpleDateFormat("yyyy");
            int year4 = Integer.parseInt(y4.format(date4));
            SimpleDateFormat m4 = new SimpleDateFormat("MM");
            int month4 = Integer.parseInt(m4.format(date4));
            SimpleDateFormat d4 = new SimpleDateFormat("dd");
            int day4 = Integer.parseInt(d4.format(date4));
            LocalDate dateN4 = LocalDate.of(year4, month4, day4);

            java.util.Date date5 = format.parse(chantiers.getDateFinPrevue().toString());
            SimpleDateFormat y5 = new SimpleDateFormat("yyyy");
            int year5 = Integer.parseInt(y5.format(date5));
            SimpleDateFormat m5 = new SimpleDateFormat("MM");
            int month5 = Integer.parseInt(m5.format(date5));
            SimpleDateFormat d5 = new SimpleDateFormat("dd");
            int day5 = Integer.parseInt(d5.format(date5));
            LocalDate dateN5 = LocalDate.of(year5, month5, day5);

            debutPrevue.setValue(dateN);
            debutEffective.setValue(dateN2);
            finPrevue.setValue(dateN3);
            finEffective.setValue(dateN4);
            dateCreation.setValue(dateN5);
            localisation.setText(chantiers.getLocalisation());
            designation.setText(chantiers.getDesignationProjet());
            commentaire.setText(chantiers.getCommentaire());
            validation.setText(Boolean.toString(chantiers.isValidationProjet()));
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(ChantierFormEditerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void validation(ActionEvent event) {
        try {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed1 = (java.util.Date) format.parse(dateCreation.getValue().toString());
            java.sql.Date date1 = new Date(parsed1.getTime());

            java.util.Date parsed2 = (java.util.Date) format.parse(debutPrevue.getValue().toString());
            java.sql.Date date2 = new Date(parsed2.getTime());

            java.util.Date parsed3 = (java.util.Date) format.parse(debutEffective.getValue().toString());
            java.sql.Date date3 = new Date(parsed3.getTime());

            java.util.Date parsed4 = (java.util.Date) format.parse(finPrevue.getValue().toString());
            java.sql.Date date4 = new Date(parsed4.getTime());

            java.util.Date parsed5 = (java.util.Date) format.parse(finEffective.getValue().toString());
            java.sql.Date date5 = new Date(parsed5.getTime());

            ChantierDto chantier = new ChantierDto(idChantier, 1, localisation.getText(), designation.getText(), commentaire.getText(), date1, date2, date3, date4, date5, true);
            if (Utilitaire.updateChantier(chantier)) {
                message.setText("Chantier ajouté avec succès !");
                Stage stage = (Stage) pane.getScene().getWindow();
                stage.close();
            } else {
                message.setText("Erreur : le chantier n'a pas pu être ajouté ...!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            message.setText("Erreur : le chantier n'a pas pu être ajouté !");
        }
    }

    @FXML
    private void annulation(ActionEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

}

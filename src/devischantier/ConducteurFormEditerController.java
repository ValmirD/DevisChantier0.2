/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.business.FacadeDB;
import db.dto.ConducteurDto;
import db.dto.ConducteurDto;
import db.exception.DevisChantierBusinessException;
import db.selDto.ConducteurSel;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Utilitaire;

/**
 * FXML Controller class
 *
 * @author Vali
 */
public class ConducteurFormEditerController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField telephone;
    @FXML
    private TextField telephonePro;
    @FXML
    private TextField email;
    @FXML
    private TextField cout;
    @FXML
    private TextField remuneration;
    @FXML
    private PasswordField password;
    @FXML
    private DatePicker naissance;
    @FXML
    private DatePicker entree;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    @FXML
    private Label message;

    private int idConducteur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initVariables(int idConducteur) {
        this.idConducteur = idConducteur;

        try {
            ConducteurDto conducteur = FacadeDB.findConducteurBySel(new ConducteurSel(idConducteur));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = format.parse(conducteur.getDateNaissance().toString());
            SimpleDateFormat y = new SimpleDateFormat("yyyy");
            int year = Integer.parseInt(y.format(date));
            SimpleDateFormat m = new SimpleDateFormat("MM");
            int month = Integer.parseInt(m.format(date));
            SimpleDateFormat d = new SimpleDateFormat("dd");
            int day = Integer.parseInt(d.format(date));
            LocalDate dateN = LocalDate.of(year, month, day);

            java.util.Date date2 = format.parse(conducteur.getDateNaissance().toString());
            SimpleDateFormat y2 = new SimpleDateFormat("yyyy");
            int year2 = Integer.parseInt(y2.format(date2));
            SimpleDateFormat m2 = new SimpleDateFormat("MM");
            int month2 = Integer.parseInt(m2.format(date2));
            SimpleDateFormat d2 = new SimpleDateFormat("dd");
            int day2 = Integer.parseInt(d2.format(date2));
            LocalDate dateN2 = LocalDate.of(year2, month2, day2);

            nom.setText(conducteur.getNom());
            prenom.setText(conducteur.getPrenom());
            naissance.setValue(dateN);
            telephone.setText(conducteur.getNumeroTelephone());
            telephonePro.setText(conducteur.getNumeroTelephonePro());
            email.setText(conducteur.getEmail());
            entree.setValue(dateN2);
            cout.setText(Double.toString(conducteur.getCout()));
            remuneration.setText(Double.toString(conducteur.getRemuneration()));
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(ConducteurFormEditerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void validation(ActionEvent event) {
        try {
            double cout1 = Double.parseDouble(cout.getText());
            double remuneration1 = Double.parseDouble(remuneration.getText());

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = (java.util.Date) format.parse(naissance.getValue().toString());
            java.sql.Date date = new Date(parsed.getTime());

            java.util.Date parsed2 = (java.util.Date) format.parse(entree.getValue().toString());
            java.sql.Date date2 = new Date(parsed2.getTime());

            //hash du password
            String hash = password.getText();
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                digest.update(hash.getBytes(), 0, hash.length());
                hash = new BigInteger(1, digest.digest()).toString(16);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            ConducteurDto conducteur = new ConducteurDto(idConducteur, hash, telephonePro.getText(), telephone.getText(), remuneration1, nom.getText(), prenom.getText(), date, email.getText(), date2, cout1);
            if (Utilitaire.updateConducteur(conducteur)) {
                message.setText("Conducteur ajouté avec succès !");
                Stage stage = (Stage) pane.getScene().getWindow();
                stage.close();
            } else {
                message.setText("Erreur : le conducteur n'a pas pu être ajouté ...!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            message.setText("Erreur : le conducteur n'a pas pu être ajouté !");
        }
    }

    @FXML
    private void annulation(ActionEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

}

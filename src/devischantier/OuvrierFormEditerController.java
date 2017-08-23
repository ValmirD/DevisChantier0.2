/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.business.FacadeDB;
import db.dto.OuvrierDto;
import db.dto.OuvrierDto;
import db.exception.DevisChantierBusinessException;
import db.selDto.OuvrierSel;
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
public class OuvrierFormEditerController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
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
    private DatePicker naissance;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    @FXML
    private Label message;

    private int idOuvrier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initVariables(int idOuvrier) {
        this.idOuvrier = idOuvrier;
/*
        try {
            OuvrierDto ouvrier = FacadeDB.findOuvrierBySel(new OuvrierSel(idOuvrier));
            nom.setText(ouvrier.getNom());
            prenom.setText(ouvrier.getPrenom());
            naissance.setText(ouvrier.getDateNaissance().toString());
            telephone.setText(ouvrier.getNumeroTelephone());
            email.setText(ouvrier.getEmail());
            entree.setText(ouvrier.getEntreeFonction().toString());
            cout.setText(Double.toString(ouvrier.getCout()));
            remuneration.setText(Double.toString(ouvrier.getRemuneration()));
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }*/
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

            OuvrierDto ouvrier = new OuvrierDto(idOuvrier, remuneration1, nom.getText(), prenom.getText(), date2, telephone.getText(), email.getText(), date, cout1);

            if (Utilitaire.updateOuvrier(ouvrier)) {
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import db.business.FacadeDB;
import db.dto.ClientDto;
import db.exception.DevisChantierBusinessException;
import db.selDto.ClientSel;
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
public class ClientFormEditerController implements Initializable {

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
    private DatePicker naissance;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    @FXML
    private Label message;

    private int idClient;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initVariables(int idClient) {
        this.idClient = idClient;

        try {
            ClientDto clients = FacadeDB.findClientBySel(new ClientSel(idClient));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = format.parse(clients.getDateNaissance().toString());
            SimpleDateFormat y = new SimpleDateFormat("yyyy");
            int year = Integer.parseInt(y.format(date));
            SimpleDateFormat m = new SimpleDateFormat("MM");
            int month = Integer.parseInt(m.format(date));
            SimpleDateFormat d = new SimpleDateFormat("dd");
            int day = Integer.parseInt(d.format(date));
            LocalDate dateN = LocalDate.of(year, month, day);
            nom.setText(clients.getNom());
            prenom.setText(clients.getPrenom());
            naissance.setValue(dateN);
            telephone.setText(clients.getNumeroTelephone());
            email.setText(clients.getEmail());
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
            java.util.Date parsed = (java.util.Date) format.parse(naissance.getValue().toString());
            java.sql.Date date = new Date(parsed.getTime());

            ClientDto client = new ClientDto(idClient, nom.getText(), prenom.getText(), date, telephone.getText(), email.getText());
            if (Utilitaire.updateClient(client)) {
                message.setText("Client ajouté avec succès !");
                Stage stage = (Stage) pane.getScene().getWindow();
                stage.close();
            } else {
                message.setText("Erreur : le client n'a pas pu être ajouté ...!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            message.setText("Erreur : le client n'a pas pu être ajouté !");
        }
    }

    @FXML
    private void annulation(ActionEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

}

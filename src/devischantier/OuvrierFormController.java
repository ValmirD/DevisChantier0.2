/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package devischantier;

import db.dto.OuvrierDto;
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
public class OuvrierFormController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField naissance;
    @FXML
    private TextField telephone;
    @FXML
    private TextField email;
    @FXML
    private TextField entree;
    @FXML
    private TextField cout;
    @FXML
    private TextField remuneration;
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
/*                try {
            double cout1 = Integer.parseInt(cout.getText());
            double remuneration1 = Integer.parseInt(remuneration.getText());
            OuvrierDto ouvrier = new OuvrierDto(10000, nom.getText(), prenom.getText(), naissance, telephone.getText(), email.getText(), entree.getText(), cout1, remuneration1 );
            
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
        }*/
    }

    @FXML
    private void annulation(ActionEvent event) {
                Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }
    
}

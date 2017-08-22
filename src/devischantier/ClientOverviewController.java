/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Marco
 */
public class ClientOverviewController implements Initializable {
    @FXML
    private TableView<?> idNomPrenom;
    @FXML
    private TableColumn<?, ?> idNom;
    @FXML
    private TableColumn<?, ?> idPrenom;
    @FXML
    private Label id;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label naissance;
    @FXML
    private Label telephone;
    @FXML
    private Label email;
    @FXML
    private Button nouveau;
    @FXML
    private Button editer;
    @FXML
    private Button supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gererNouveau(ActionEvent event) {
    }

    @FXML
    private void gererEditer(ActionEvent event) {
    }

    @FXML
    private void gererSupprimer(ActionEvent event) {
    }
    
}

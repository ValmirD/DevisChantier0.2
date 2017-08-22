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
public class VoitureOverviewController implements Initializable {
    @FXML
    private TableView<?> idMarqueModele;
    @FXML
    private TableColumn<?, ?> idMarque;
    @FXML
    private TableColumn<?, ?> idModele;
    @FXML
    private Label id;
    @FXML
    private Label attache;
    @FXML
    private Label marque;
    @FXML
    private Label modele;
    @FXML
    private Label chassis;
    @FXML
    private Label carburant;
    @FXML
    private Label prix;
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

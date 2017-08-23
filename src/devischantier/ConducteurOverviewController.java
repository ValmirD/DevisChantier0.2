/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.business.FacadeDB;
import db.dto.ConducteurDto;
import db.exception.DevisChantierBusinessException;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vali
 */
public class ConducteurOverviewController implements Initializable {

    @FXML
    private TableView<ConducteurDto> idNomPrenom;
    @FXML
    private TableColumn<ConducteurDto, String> idNom;
    @FXML
    private TableColumn<ConducteurDto, String> idPrenom;
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
    private Label telephonePro;
    @FXML
    private Label entree;
    @FXML
    private Label cout;
    @FXML
    private Label remuneration;
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
        editer.setDisable(true);
        displayList();

    }

    @FXML
    private void gererNouveau(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("ConducteurFormNouveau.fxml"));
        AnchorPane conducteurInfo;
        try {
            conducteurInfo = (AnchorPane) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(conducteurInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gererEditer(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("ConducteurFormEditer.fxml"));
        AnchorPane conducteurInfo;
        try {
            conducteurInfo = (AnchorPane) loader.load();

            //passer paramètres au controller suivant
            if (id != null) {
                //ConducteurFormController controller = loader.<ConducteurFormController>getController();
                //controller.initVariables(Integer.parseInt(id.getText()));
            }

            //à mettre dans le controller d'éditeur de conducteur, ainsi que l'attribut de classe -> private int idConducteur.
            /**
             * public void initVariables(int idConducteur) { this.idConducteur =
             * idConducteur;
              }*
             */
            Stage stage = new Stage();
            Scene scene = new Scene(conducteurInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gererSupprimer(ActionEvent event) {
    }

    @FXML
    private void displayList() {
        idNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        idPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        try {
            Collection<ConducteurDto> conducteurs = FacadeDB.getAllConducteur();
            ObservableList<ConducteurDto> data = FXCollections.observableArrayList(conducteurs);
            idNomPrenom.setItems(data);

            idNomPrenom.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    ConducteurDto conducteur = idNomPrenom.getSelectionModel().selectedItemProperty().get();
                    editer.setDisable(false);
                    id.setText(conducteur.getId().toString());
                    nom.setText(conducteur.getNom());
                    prenom.setText(conducteur.getPrenom());
                    naissance.setText(conducteur.getDateNaissance().toString());
                    telephone.setText(conducteur.getNumeroTelephone());
                    telephonePro.setText(conducteur.getNumeroTelephonePro());
                    email.setText(conducteur.getEmail());
                    entree.setText(conducteur.getEntreeFonction().toString());
                    cout.setText(Double.toString(conducteur.getCout()));
                    remuneration.setText(Double.toString(conducteur.getRemuneration()));
                }
            });
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package devischantier;

import db.business.FacadeDB;
import db.dto.OuvrierDto;
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
 * @author Marco
 */
public class OuvrierOverviewController implements Initializable {

    @FXML
    private TableView<OuvrierDto> idNomPrenom;
    @FXML
    private TableColumn<OuvrierDto, String> idNom;
    @FXML
    private TableColumn<OuvrierDto, String> idPrenom;
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
    private Label entree;
    @FXML
    private Label cout;
    @FXML
    private Label remuneration;
    @FXML
    private Label permis;
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
        loader.setLocation(DevisChantier.class.getResource("OuvrierFormNouveau.fxml"));
        AnchorPane ouvrierInfo;
        try {
            ouvrierInfo = (AnchorPane) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(ouvrierInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gererEditer(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("OuvrierFormEditer.fxml"));
        AnchorPane ouvrierInfo;
        try {
            ouvrierInfo = (AnchorPane) loader.load();

            //passer paramètres au controller suivant
            if (id != null) {
                //OuvrierFormController controller = loader.<OuvrierFormController>getController();
                //controller.initVariables(Integer.parseInt(id.getText()));
            }

            //à mettre dans le controller d'éditeur de ouvrier, ainsi que l'attribut de classe -> private int idOuvrier.
            /**
             * public void initVariables(int idOuvrier) { this.idOuvrier =
             * idOuvrier;
              }*
             */
            Stage stage = new Stage();
            Scene scene = new Scene(ouvrierInfo);
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
            Collection<OuvrierDto> ouvriers = FacadeDB.getAllOuvrier();
            ObservableList<OuvrierDto> data = FXCollections.observableArrayList(ouvriers);
            idNomPrenom.setItems(data);

            idNomPrenom.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    OuvrierDto ouvrier = idNomPrenom.getSelectionModel().selectedItemProperty().get();
                    editer.setDisable(false);
                    id.setText(ouvrier.getId().toString());
                    nom.setText(ouvrier.getNom());
                    prenom.setText(ouvrier.getPrenom());
                    naissance.setText(ouvrier.getDateNaissance().toString());
                    telephone.setText(ouvrier.getNumeroTelephone());
                    email.setText(ouvrier.getEmail());
                    entree.setText(ouvrier.getEntreeFonction().toString());
                    cout.setText(Double.toString(ouvrier.getCout()));
                    remuneration.setText(Double.toString(ouvrier.getRemuneration()));
                }
            });
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

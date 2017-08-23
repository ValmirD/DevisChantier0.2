/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.business.FacadeDB;
import db.dto.MateriauDto;
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
import model.Utilitaire;

/**
 * FXML Controller class
 *
 * @author Vali
 */
public class MateriauOverviewController1 implements Initializable {

    @FXML
    private TableView<MateriauDto> idTableNom;
    @FXML
    private TableColumn<MateriauDto, String> idColonneNom;
    @FXML
    private TableColumn<MateriauDto, String> idColonneId;
    @FXML
    private Label id;
    @FXML
    private Label nom;
    @FXML
    private Label type;
    @FXML
    private Label reference;
    @FXML
    private Label fourniture;
    @FXML
    private Label production;
    @FXML
    private Label prix;
    @FXML
    private Button nouveau;
    @FXML
    private Button editer;
    @FXML
    private Button supprimer;
    @FXML
    private Label message;

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
        loader.setLocation(DevisChantier.class.getResource("MateriauFormNouveau.fxml"));
        AnchorPane materiauInfo;
        try {
            materiauInfo = (AnchorPane) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(materiauInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gererEditer(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("MateriauFormEditer.fxml"));
        AnchorPane materiauInfo;
        try {
            materiauInfo = (AnchorPane) loader.load();

            //passer paramètres au controller suivant
            if (id != null) {
                //MateriauFormController controller = loader.<MateriauFormController>getController();
                //controller.initVariables(Integer.parseInt(id.getText()));
            }

            //à mettre dans le controller d'éditeur de materiau, ainsi que l'attribut de classe -> private int idMateriau.
            /**
             * public void initVariables(int idMateriau) { this.idMateriau =
             * idMateriau; }*
             */
            Stage stage = new Stage();
            Scene scene = new Scene(materiauInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gererSupprimer(ActionEvent event) {
        MateriauDto materiau = idTableNom.getSelectionModel().selectedItemProperty().get();
        if (Utilitaire.deleteMateriau(materiau.getId())) {
            message.setText("Suppression avec succès !");
        } else {
            message.setText("Erreur de suppression ...!");
        }
    }

    @FXML
    private void displayList() {
        idColonneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        idColonneId.setCellValueFactory(new PropertyValueFactory<>("id"));
        try {
            Collection<MateriauDto> materiaus = FacadeDB.getAllMateriau();
            ObservableList<MateriauDto> data = FXCollections.observableArrayList(materiaus);
            idTableNom.setItems(data);

            idTableNom.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    MateriauDto materiau = idTableNom.getSelectionModel().selectedItemProperty().get();
                    editer.setDisable(false);
                    id.setText(materiau.getId().toString());
                    nom.setText(materiau.getNom());
                    type.setText(materiau.getType());
                    reference.setText(materiau.getReference());
                    fourniture.setText(materiau.getFourniture());
                    production.setText(materiau.getSiteProduction());
                    prix.setText(Double.toString(materiau.getPrixHtva()));
                }
            });
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

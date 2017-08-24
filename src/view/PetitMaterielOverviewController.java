/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import db.business.FacadeDB;
import db.dto.PetitMaterielDto;
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
public class PetitMaterielOverviewController implements Initializable {

    @FXML
    private TableView<PetitMaterielDto> idTableNom;
    @FXML
    private TableColumn<PetitMaterielDto, String> idColonneNom;
    @FXML
    private Label id;
    @FXML
    private Label nom;
    @FXML
    private Label type;
    @FXML
    private Label reference;
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
        loader.setLocation(DevisChantier.class.getResource("PetitMaterielFormNouveau.fxml"));
        AnchorPane petitMaterielInfo;
        try {
            petitMaterielInfo = (AnchorPane) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(petitMaterielInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gererEditer(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("PetitMaterielFormEditer.fxml"));
        AnchorPane petitMaterielInfo;
        try {
            petitMaterielInfo = (AnchorPane) loader.load();

            //passer paramètres au controller suivant
            if (id != null) {
                PetitMaterielFormEditerController controller = loader.<PetitMaterielFormEditerController>getController();
                controller.initVariables(Integer.parseInt(id.getText()));
            } 
            Stage stage = new Stage();
            Scene scene = new Scene(petitMaterielInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gererSupprimer(ActionEvent event) {
        PetitMaterielDto petitMateriel = idTableNom.getSelectionModel().selectedItemProperty().get();
        if (Utilitaire.deletePetitMateriel(petitMateriel.getId())) {
            message.setText("Suppression avec succès !");
        } else {
            message.setText("Erreur de suppression ...!");
        }
    }

    @FXML
    private void displayList() {
        idColonneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        try {
            Collection<PetitMaterielDto> petitMateriels = FacadeDB.getAllPetitMateriel();
            ObservableList<PetitMaterielDto> data = FXCollections.observableArrayList(petitMateriels);
            idTableNom.setItems(data);

            idTableNom.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    PetitMaterielDto petitMateriel = idTableNom.getSelectionModel().selectedItemProperty().get();
                    editer.setDisable(false);
                    id.setText(petitMateriel.getId().toString());
                    nom.setText(petitMateriel.getNom());
                    type.setText(petitMateriel.getType());
                    reference.setText(petitMateriel.getReference());
                    prix.setText(Double.toString(petitMateriel.getPrixHtva()));
                }
            });
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.business.FacadeDB;
import db.dto.ChantierDto;
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
public class ChantierOverviewController implements Initializable {

    @FXML
    private TableView<ChantierDto> idDesignationID;
    @FXML
    private TableColumn<ChantierDto, String> idDesignation;
    @FXML
    private TableColumn<ChantierDto, String> idIdentification;
    @FXML
    private Label idChantier;
    @FXML
    private Label idClient;
    @FXML
    private Label idDevis;
    @FXML
    private Label datePrevue;
    @FXML
    private Label dateEffective;
    @FXML
    private Label dateFinEffective;
    @FXML
    private Label dateFinPrevue;
    @FXML
    private Label localisation;
    @FXML
    private Label designation;
    @FXML
    private Label commentaire;
    @FXML
    private Label dateCreation;
    @FXML
    private Label validation;
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
        loader.setLocation(DevisChantier.class.getResource("ChantierFormNouveau.fxml"));
        AnchorPane enginInfo;
        try {
            enginInfo = (AnchorPane) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(enginInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gererEditer(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("ChantierFormEditer.fxml"));
        AnchorPane enginInfo;
        try {
            enginInfo = (AnchorPane) loader.load();

            if (idChantier != null) {
                ChantierFormEditerController controller = loader.<ChantierFormEditerController>getController();
                controller.initVariables(Integer.parseInt(idChantier.getText()));
            }

            Stage stage = new Stage();
            Scene scene = new Scene(enginInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gererSupprimer(ActionEvent event) {
        ChantierDto chantier = idDesignationID.getSelectionModel().selectedItemProperty().get();
        if (Utilitaire.deleteChantier(chantier.getId())) {
            message.setText("Suppression avec succès !");
        } else {
            message.setText("Erreur de suppression ...!");
        }
    }

    @FXML
    private void displayList() {
        idDesignation.setCellValueFactory(new PropertyValueFactory<>("designationProjet"));
        idIdentification.setCellValueFactory(new PropertyValueFactory<>("id"));
        try {
            Collection<ChantierDto> chantiers = FacadeDB.getAllChantier();
            ObservableList<ChantierDto> data = FXCollections.observableArrayList(chantiers);
            idDesignationID.setItems(data);

            idDesignationID.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    ChantierDto chantiers = idDesignationID.getSelectionModel().selectedItemProperty().get();
                    editer.setDisable(false);
                    idChantier.setText(chantiers.getId().toString());
                    idClient.setText(Integer.toString(chantiers.getIdClient()));
                    idDevis.setText(Integer.toString(chantiers.getIdDevis()));
                    datePrevue.setText(chantiers.getDateDebutPrevue().toString());
                    if (chantiers.getDateDebutEffective() != null) {
                        dateEffective.setText(chantiers.getDateDebutEffective().toString());
                    }
                    dateFinPrevue.setText(chantiers.getDateFinPrevue().toString());
                    if (chantiers.getDateFinEffective() != null) {
                        dateFinEffective.setText(chantiers.getDateFinEffective().toString());
                    }
                    dateCreation.setText(chantiers.getDateCreationProjet().toString());
                    localisation.setText(chantiers.getLocalisation());
                    designation.setText(chantiers.getDesignationProjet());
                    commentaire.setText(chantiers.getCommentaire());
                    validation.setText(Boolean.toString(chantiers.isValidationProjet()));
                }
            }
            );
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

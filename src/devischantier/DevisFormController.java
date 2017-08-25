/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.business.FacadeDB;
import db.dto.ChantierDto;
import db.dto.DevisDto;
import db.exception.DevisChantierBusinessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Utilitaire;

/**
 * FXML Controller class
 *
 * @author Vali
 */
public class DevisFormController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField statut;
    @FXML
    private DatePicker dateDevis;
    @FXML
    private TextField designation;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    @FXML
    private Label message;
    @FXML
    private ListView<ChantierDto> listChantiers;

    private int idChantier;
    @FXML
    private Button ajoutOuvrier;
    private Button pdf;
    @FXML
    private Button ajoutConducteur;
    @FXML
    private Button ajoutClient;
    @FXML
    private Button ajoutEngin;
    @FXML
    private Button ajoutMateriau;
    @FXML
    private Button ajoutPetitMateriel;
    @FXML
    private Button ajoutCodeReference;
    @FXML
    private Button ajoutVoiture;
    @FXML
    private Button ajoutCamion;
    @FXML
    private Button ajoutChantier;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        displayChantiers();
        ajoutOuvrier.setDisable(true);
        pdf.setDisable(true);
        ajoutClient.setDisable(true);
        ajoutEngin.setDisable(true);
        ajoutMateriau.setDisable(true);
        ajoutPetitMateriel.setDisable(true);
        ajoutCodeReference.setDisable(true);
        ajoutVoiture.setDisable(true);
        ajoutCamion.setDisable(true);
        ajoutConducteur.setDisable(true);
    }

    @FXML
    private void validation(ActionEvent event) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = (java.util.Date) format.parse(dateDevis.getValue().toString());
            java.sql.Date date = new Date(parsed.getTime());

            DevisDto devis = new DevisDto(10000, designation.getText(), statut.getText(), date, idChantier);
            if (Utilitaire.insertDevis(devis)) {
                message.setText("Devis ajouté avec succès !");
                Stage stage = (Stage) pane.getScene().getWindow();
                stage.close();
            } else {
                message.setText("Erreur : le devis n'a pas pu être ajouté ...!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            message.setText("Erreur : le devis n'a pas pu être ajouté !");
        }
    }

    private void displayChantiers() {
        try {
            Collection<ChantierDto> chantiers = FacadeDB.getAllChantier();
            ObservableList<ChantierDto> data = FXCollections.observableArrayList(chantiers);
            listChantiers.setItems(data);
            listChantiers.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    ChantierDto chantier = listChantiers.getSelectionModel().selectedItemProperty().get();
                    idChantier = chantier.getId();
                    System.out.println(idChantier);
                    ajoutOuvrier.setDisable(false);
                    pdf.setDisable(false);
                    ajoutClient.setDisable(false);
                    ajoutEngin.setDisable(false);
                    ajoutMateriau.setDisable(false);
                    ajoutPetitMateriel.setDisable(false);
                    ajoutCodeReference.setDisable(false);
                    ajoutVoiture.setDisable(false);
                    ajoutCamion.setDisable(false);
                    ajoutConducteur.setDisable(false);
                }
            });

        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void annulation(ActionEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void goToDevisAjoutOuvrier(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("DevisAjoutOuvrier.fxml"));
        AnchorPane ouvrierInfo;
        try {
            ouvrierInfo = (AnchorPane) loader.load();

            DevisAjoutOuvrierController controller = loader.<DevisAjoutOuvrierController>getController();
            controller.initVariables(idChantier);

            Stage stage = new Stage();
            Scene scene = new Scene(ouvrierInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void goToDevisAjoutConducteur(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutClient(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutEngin(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutMateriau(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutPetitMateriel(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutCodeReference(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutVoiture(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutCamion(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutChantier(ActionEvent event) {
    }


}

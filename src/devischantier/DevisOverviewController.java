/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package devischantier;

import db.business.FacadeDB;
import db.dto.DevisDto;
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
public class DevisOverviewController implements Initializable {

    @FXML
    private TableView<DevisDto> idDesignationId;
    @FXML
    private TableColumn<DevisDto, String> idDesignation;
    @FXML
    private TableColumn<DevisDto, String> idIdentification;
    @FXML
    private Label idDevis;
    @FXML
    private Label idChantier;
    @FXML
    private Label statut;
    @FXML
    private Label date;
    @FXML
    private Label designation;
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
        loader.setLocation(DevisChantier.class.getResource("DevisFormNouveau.fxml"));
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
        loader.setLocation(DevisChantier.class.getResource("DevisFormEditer.fxml"));
        AnchorPane enginInfo;
        try {
            enginInfo = (AnchorPane) loader.load();

            //passer paramètres au controller suivant
            if (idDevis != null) {
                //EnginFormController controller = loader.<EnginFormController>getController();
                //controller.initVariables(Integer.parseInt(id.getText()));
            }

            //à mettre dans le controller d'éditeur de engin, ainsi que l'attribut de classe -> private int idEngin.
            /**
             * public void initVariables(int idEngin) { this.idEngin = idEngin;
              }*
             */
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
    }

    @FXML
    private void displayList() {
        idDesignation.setCellValueFactory(new PropertyValueFactory<>("designationDevis")); 
        idIdentification.setCellValueFactory(new PropertyValueFactory<>("id"));
        try {
            Collection<DevisDto> devis = FacadeDB.getAllDevis();
            ObservableList<DevisDto> data = FXCollections.observableArrayList(devis);
            idDesignationId.setItems(data);

            idDesignationId.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    DevisDto devis = idDesignationId.getSelectionModel().selectedItemProperty().get();
                    editer.setDisable(false);
                    idDevis.setText(devis.getId().toString());
                    idChantier.setText(devis.getId().toString());
                    statut.setText(devis.getStatut());
                    designation.setText(devis.getDesignationDevis());
                    date.setText(devis.getDateDevis().toString());
                }
            });
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

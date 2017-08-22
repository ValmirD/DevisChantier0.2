/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.business.FacadeDB;
import db.dto.CamionDto;
import db.exception.DevisChantierBusinessException;
import java.awt.event.MouseEvent;
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
public class CamionOverviewController implements Initializable {

    @FXML
    private Label id;
    @FXML
    private Label categorie;
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
    private Label tonnage;
    @FXML
    private Label capacite;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;

    @FXML
    private TableView<CamionDto> table;
    @FXML
    private TableColumn<CamionDto, String> colonneId;
    @FXML
    private TableColumn<CamionDto, String> colonneMarque;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        displayList();

    }

    @FXML
    private void gererNouveau(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("CamionFormNouveau.fxml"));
        AnchorPane camionInfo;
        try {
            camionInfo = (AnchorPane) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(camionInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gererEditer(ActionEvent event) {
    }

    @FXML
    private void gererSupprimer(ActionEvent event) {
    }

    @FXML
    private void displayList() {
        colonneMarque.setCellValueFactory(new PropertyValueFactory<>("marque")); //"marque" doit correspondre pile poil à l'attribut correspondant dans CamionDto
        colonneId.setCellValueFactory(new PropertyValueFactory<>("id"));
        try {
            Collection<CamionDto> camions = FacadeDB.getAllCamion();
            ObservableList<CamionDto> data = FXCollections.observableArrayList(camions);
            table.setItems(data);

            table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    CamionDto camion = table.getSelectionModel().selectedItemProperty().get();
                    id.setText(camion.getId().toString());
                    categorie.setText(camion.getCategorie());
                    marque.setText(camion.getMarque());
                    modele.setText(camion.getModele());
                    chassis.setText(camion.getNumeroChassis());
                    prix.setText(Double.toString(camion.getPrixHtva()));
                    tonnage.setText(Integer.toString(camion.getTonnage()));
                    capacite.setText(Double.toString(camion.getCapacite()));
                }
            });
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.business.FacadeDB;
import db.dto.ClientDto;
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
public class ClientOverviewController implements Initializable {

    @FXML
    private TableView<ClientDto> idNomPrenom;
    @FXML
    private TableColumn<ClientDto, String> idNom;
    @FXML
    private TableColumn<ClientDto, String> idPrenom;
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
        loader.setLocation(DevisChantier.class.getResource("ClientFormNouveau.fxml"));
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
        loader.setLocation(DevisChantier.class.getResource("ClientFormEditer.fxml"));
        AnchorPane enginInfo;
        try {
            enginInfo = (AnchorPane) loader.load();

            //passer paramètres au controller suivant
            if (id != null) {
                CamionFormEditerController controller = loader.<CamionFormEditerController>getController();
                controller.initVariables(Integer.parseInt(id.getText()));
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
        ClientDto client = idNomPrenom.getSelectionModel().selectedItemProperty().get();
        if (Utilitaire.deleteClient(client.getId())) {
            message.setText("Suppression avec succès !");
        } else {
            message.setText("Erreur de suppression ...!");
        }
    }

    @FXML
    private void displayList() {
        idNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        idPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        try {
            Collection<ClientDto> clients = FacadeDB.getAllClient();
            ObservableList<ClientDto> data = FXCollections.observableArrayList(clients);
            idNomPrenom.setItems(data);

            idNomPrenom.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    ClientDto clients = idNomPrenom.getSelectionModel().selectedItemProperty().get();
                    editer.setDisable(false);
                    id.setText(clients.getId().toString());
                    nom.setText(clients.getNom());
                    prenom.setText(clients.getPrenom());
                    naissance.setText(clients.getDateNaissance().toString());
                    telephone.setText(clients.getNumeroTelephone());
                    email.setText(clients.getEmail());
                }
            });
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

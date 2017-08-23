/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package devischantier;

import db.business.FacadeDB;
import db.dto.VoitureDto;
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
public class VoitureOverviewController implements Initializable {

    @FXML
    private TableView<VoitureDto> idMarqueModele;
    @FXML
    private TableColumn<VoitureDto, String> idMarque;
    @FXML
    private TableColumn<VoitureDto, String> idModele;
    @FXML
    private Label id;
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
        editer.setDisable(true);
        displayList();

    }

    @FXML
    private void gererNouveau(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("VoitureFormNouveau.fxml"));
        AnchorPane voitureInfo;
        try {
            voitureInfo = (AnchorPane) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(voitureInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gererEditer(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("VoitureFormEditer.fxml"));
        AnchorPane voitureInfo;
        try {
            voitureInfo = (AnchorPane) loader.load();

            //passer paramètres au controller suivant
            if (id != null) {
                //VoitureFormController controller = loader.<VoitureFormController>getController();
                //controller.initVariables(Integer.parseInt(id.getText()));
            }

            //à mettre dans le controller d'éditeur de voiture, ainsi que l'attribut de classe -> private int idVoiture.
            
              /**public void initVariables(int idVoiture) { this.idVoiture = idVoiture;
              }**/
            Stage stage = new Stage();
            Scene scene = new Scene(voitureInfo);
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
        idMarque.setCellValueFactory(new PropertyValueFactory<>("marque")); 
        idModele.setCellValueFactory(new PropertyValueFactory<>("modele"));
        try {
            Collection<VoitureDto> voitures = FacadeDB.getAllVoiture();
            ObservableList<VoitureDto> data = FXCollections.observableArrayList(voitures);
            idMarqueModele.setItems(data);

            idMarqueModele.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    VoitureDto voiture = idMarqueModele.getSelectionModel().selectedItemProperty().get();
                    editer.setDisable(false);
                    id.setText(voiture.getId().toString());
                    marque.setText(voiture.getMarque());
                    modele.setText(voiture.getModele());
                    chassis.setText(voiture.getNumeroChassis());
                    prix.setText(Double.toString(voiture.getPrixHtva()));
                    carburant.setText(voiture.getCarburant());
                }
            });
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

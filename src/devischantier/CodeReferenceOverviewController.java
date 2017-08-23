/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package devischantier;

import db.business.FacadeDB;
import db.dto.CodeReferenceDto;
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
public class CodeReferenceOverviewController implements Initializable {

    @FXML
    private TableView<CodeReferenceDto> idTableReference;
    @FXML
    private TableColumn<CodeReferenceDto, String> idColonneReference;
    @FXML
    private Label id;
    @FXML
    private Label reference;
    @FXML
    private Label type;
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
        loader.setLocation(DevisChantier.class.getResource("CodeReferenceFormNouveau.fxml"));
        AnchorPane codeReferenceInfo;
        try {
            codeReferenceInfo = (AnchorPane) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(codeReferenceInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gererEditer(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("CodeReferenceFormEditer.fxml"));
        AnchorPane codeReferenceInfo;
        try {
            codeReferenceInfo = (AnchorPane) loader.load();

            //passer paramètres au controller suivant
            if (id != null) {
                //CodeReferenceFormController controller = loader.<CodeReferenceFormController>getController();
                //controller.initVariables(Integer.parseInt(id.getText()));
            }

            //à mettre dans le controller d'éditeur de codeReference, ainsi que l'attribut de classe -> private int idCodeReference.
            
              /**public void initVariables(int idCodeReference) { this.idCodeReference = idCodeReference;
              }**/
            Stage stage = new Stage();
            Scene scene = new Scene(codeReferenceInfo);
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
        idColonneReference.setCellValueFactory(new PropertyValueFactory<>("reference"));
        try {
            Collection<CodeReferenceDto> codeReferences = FacadeDB.getAllCodeReference();
            ObservableList<CodeReferenceDto> data = FXCollections.observableArrayList(codeReferences);
            idTableReference.setItems(data);

            idTableReference.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    CodeReferenceDto codeReference = idTableReference.getSelectionModel().selectedItemProperty().get();
                    editer.setDisable(false);
                    id.setText(codeReference.getId().toString());
                    reference.setText(codeReference.getReference());
                    type.setText(codeReference.getTypeTravail());
                    prix.setText(Double.toString(codeReference.getPrixHtva()));
                }
            });
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

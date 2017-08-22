/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;

/**
 * FXML Controller class
 *
 * @author Marco
 */
public class RootLayoutController implements Initializable {
    @FXML
    private Menu exit;
    @FXML
    private Menu about;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeApplication(Event event) {
        System.out.println("exit");
        Platform.exit();
    }
    
}

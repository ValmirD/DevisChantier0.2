/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.selDto.EnginDuChantierSel;
import db.selDto.EnginSel;

import db.selDto.MateriauDuChantierSel;
import db.selDto.MateriauSel;

import db.selDto.PetitMaterielDuChantierSel;
import db.selDto.PetitMaterielSel;

import db.selDto.CodeReferenceDuChantierSel;
import db.selDto.CodeReferenceSel;

import db.selDto.OuvrierDuChantierSel;
import db.selDto.OuvrierSel;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Utilitaire;

/**
 *
 * @author Vali
 */
public class DevisChantier extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        EnginSel eng = new EnginSel(1);
        EnginDuChantierSel sel = new EnginDuChantierSel(1);
        Utilitaire.MontantEngins(eng,sel);
        
        MateriauSel mat = new MateriauSel(1);
        MateriauDuChantierSel macha = new MateriauDuChantierSel(1);
        Utilitaire.MontantMateriaux(mat,macha);
        
        PetitMaterielSel pemat = new PetitMaterielSel(1);
        PetitMaterielDuChantierSel pemacha = new PetitMaterielDuChantierSel(1);
        Utilitaire.MontantPetitsMateriels(pemat,pemacha);
        
               
        CodeReferenceSel core = new CodeReferenceSel(1);
        CodeReferenceDuChantierSel corecha = new CodeReferenceDuChantierSel(1);
        Utilitaire.MontantCodesReferences(core,corecha);
        
        OuvrierSel ouv = new OuvrierSel(1);
        Utilitaire.CalculAge(ouv);
        
    }
    
}

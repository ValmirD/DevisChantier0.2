/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.dto.EnginDto;
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

import db.selDto.ConducteurDuChantierSel;
import db.selDto.ConducteurSel;

import db.selDto.VoitureDuChantierSel;
import db.selDto.VoitureSel;

import db.selDto.CamionDuChantierSel;
import db.selDto.CamionSel;
import db.dto.CamionDto;

import db.dto.ClientDto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Utilitaire;
import db.business.FacadeDB;
import db.exception.DevisChantierBusinessException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Date;

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
        Utilitaire.montantEngins(eng, sel);

        MateriauSel mat = new MateriauSel(1);
        MateriauDuChantierSel macha = new MateriauDuChantierSel(1);
        Utilitaire.montantMateriaux(mat, macha);

        PetitMaterielSel pemat = new PetitMaterielSel(1);
        PetitMaterielDuChantierSel pemacha = new PetitMaterielDuChantierSel(1);
        Utilitaire.montantPetitsMateriels(pemat, pemacha);

        //AJOUT CODE REFERENCE
        CodeReferenceSel core = new CodeReferenceSel(1);
        CodeReferenceDuChantierSel corecha = new CodeReferenceDuChantierSel(1);
        Utilitaire.montantCodesReferences(core, corecha);
        //AVEC SUPPLEMENT
        CodeReferenceSel core1 = new CodeReferenceSel(1);
        CodeReferenceDuChantierSel corecha1 = new CodeReferenceDuChantierSel(1);
        Utilitaire.supplement(core1, corecha1, 10);
        
        //COUT OUVRIER
        OuvrierSel ouv = new OuvrierSel(1);
        OuvrierDuChantierSel ouvcha = new OuvrierDuChantierSel(1);
        Utilitaire.montantOuvriers(ouv, ouvcha);
        
        //COUT CONDUCTEUR
        ConducteurSel con = new ConducteurSel(1);
        ConducteurDuChantierSel concha = new ConducteurDuChantierSel(1);
        Utilitaire.montantConducteurs(con, concha);
        
        //VOITURE
        VoitureSel voi = new VoitureSel(1);
        VoitureDuChantierSel voicha = new VoitureDuChantierSel(1);
        Utilitaire.montantVoitures(voi, voicha);
        
        //CAMION
        CamionSel cam = new CamionSel(1);
        CamionDuChantierSel camcha = new CamionDuChantierSel(1);
        Utilitaire.montantCamions(cam, camcha); 
        System.out.println((Utilitaire.montantCamions(cam, camcha))*10);
        System.out.println(Utilitaire.montantCamions(cam, camcha));
        
        //AGE
        OuvrierSel ouv2 = new OuvrierSel(1);
        Utilitaire.calculAge(ouv2);
        
        // METHODE CRUD >

        //EnginDto engin = new EnginDto(2, "Tracteur", "Creuser la terre", "BL504", true, 105);
        //Utilitaire.insertEngin(engin);
        //regarder dans la DB l'ID exacte, 6 est obsolète. 
        //Utilitaire.deleteEngin(6);

        //-EnginDto enginUpdated = new EnginDto(7, "Tracteur", "Creuser la pierre", "BL504", false, 55);
        //-Utilitaire.updateEngin(enginUpdated);
        
        //CamionDto camion = new CamionDto(5, "B", 1, 1500, "Audi", "Charger", "254795625", "Diesel", 177);
        //Utilitaire.insertCamion(camion);
        //CamionDto camionUpdated = new CamionDto(3, "B", 1, 1800, "Audi", "Charger", "254795625", "Essence", 177);
        //Utilitaire.updateCamion(camionUpdated);
        //Utilitaire.deleteCamion(3);
        
        //ClientDto client = new ClientDto(5, "Marc", "Zotte", new java.sql.Date(1982-02-02), "0485321", "marc@beno.com");
        //Utilitaire.insertClient(client);
        //regarder dans la DB l'ID exacte, 6 est obsolète. 
        //Utilitaire.deleteEngin(6);
        //Use stmt.setDate(1, new java.sql.Date(cal.getTimeInMillis()))

        //-EnginDto enginUpdated = new EnginDto(7, "Tracteur", "Creuser la pierre", "BL504", false, 55);
        //-Utilitaire.updateEngin(enginUpdated);
        
        
        
        
    }

}

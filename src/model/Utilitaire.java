/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.business.FacadeDB;
import db.exception.DevisChantierBusinessException;

import db.selDto.EnginDuChantierSel;
import db.selDto.EnginSel;
import db.dto.EnginDto;
import db.dto.EnginDuChantierDto;

import db.selDto.MateriauDuChantierSel;
import db.selDto.MateriauSel;
import db.dto.MateriauDto;
import db.dto.MateriauDuChantierDto;

import db.selDto.PetitMaterielDuChantierSel;
import db.selDto.PetitMaterielSel;
import db.dto.PetitMaterielDto;
import db.dto.PetitMaterielDuChantierDto;

import db.selDto.CodeReferenceDuChantierSel;
import db.selDto.CodeReferenceSel;
import db.dto.CodeReferenceDto;
import db.dto.CodeReferenceDuChantierDto;

import db.selDto.OuvrierDuChantierSel;
import db.selDto.OuvrierSel;
import db.dto.OuvrierDto;
import db.dto.OuvrierDuChantierDto;

import db.selDto.ConducteurDuChantierSel;
import db.selDto.ConducteurSel;
import db.dto.ConducteurDto;
import db.dto.ConducteurDuChantierDto;
        
import db.selDto.VoitureDuChantierSel;
import db.selDto.VoitureSel;
import db.dto.VoitureDto;
import db.dto.VoitureDuChantierDto;

import db.selDto.CamionDuChantierSel;
import db.selDto.CamionSel;
import db.dto.CamionDto;
import db.dto.CamionDuChantierDto;

import db.selDto.DevisSel;
import db.dto.DevisDto;


import db.selDto.ClientSel;
import db.dto.ClientDto;

import java.sql.Date;



/**
 *
 * @author Vali
 */
public class Utilitaire {
    
    /*Engins*/
    public static double montantEngins(EnginSel engin, EnginDuChantierSel sel){
        double montant = 0;
        double quantite = 0;
        double nombreHeures = 0;
        double montantTot = 0;
        
        try {
            EnginDto eng = FacadeDB.findEnginBySel(engin);
            montant = eng.getPrixHeure();
            
            EnginDuChantierDto engCha= FacadeDB.findEnginDuChantierBySel(sel);
            quantite = engCha.getQuantite();
            nombreHeures = engCha.getNombreHeures();
            montantTot = nombreHeures*quantite*montant;
            System.out.println(montantTot);
                    
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return montantTot;
    }

    public static void insertEngin(EnginDto eng){
        try {
            FacadeDB.addEngin(eng);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteEngin(int idEng){
        try {
            FacadeDB.deleteEngin(idEng);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateEngin(EnginDto eng){
        try {
            FacadeDB.updateEngin(eng);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }   
    
    /*EnginsDuChantier*/
    
    /*Materiaux*/
    public static double montantMateriaux(MateriauSel sel1, MateriauDuChantierSel sel2){
        double montant = 0;
        double quantite = 0;
        double montantTot = 0;
        
        try {
            MateriauDto eng = FacadeDB.findMateriauBySel(sel1);
            montant = eng.getPrixHtva();
            
            MateriauDuChantierDto matCha= FacadeDB.findMateriauDuChantierBySel(sel2);
            quantite = matCha.getQuantite();
            montantTot = quantite*montant;
            System.out.println(montantTot);
                    
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return montantTot;
    }

    public static void insertMateriau(MateriauDto mat){
        try {
            FacadeDB.addMateriau(mat);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteMateriau(int idMat){
        try {
            FacadeDB.deleteEngin(idMat);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateMateriau(MateriauDto mat){
        try {
            FacadeDB.updateMateriau(mat);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
    /*MateriauxDuChantier*/
    
    /*Petits Materiels*/
    public static double montantPetitsMateriels(PetitMaterielSel sel1, PetitMaterielDuChantierSel sel2){
        double montant = 0;
        double quantite = 0;
        double montantTot = 0;
        
        try {
            PetitMaterielDto eng = FacadeDB.findPetitMaterielBySel(sel1);
            montant = eng.getPrixHtva();
            
            PetitMaterielDuChantierDto pema= FacadeDB.findPetitMaterielDuChantierBySel(sel2);
            quantite = pema.getQuantite();
            montantTot = quantite*montant;
            System.out.println(montantTot);
                    
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return montantTot;
    }  
    
    public static void insertPetitMateriel(PetitMaterielDto pemat){
        try {
            FacadeDB.addPetitMateriel(pemat);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deletePetitMateriel(int idpemat){
        try {
            FacadeDB.deletePetitMateriel(idpemat);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updatePetitMateriel(PetitMaterielDto pemat){
        try {
            FacadeDB.updatePetitMateriel(pemat);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    } 
    
    /*PetitsMaterielsDuChantier*/
    
    /*Codes References*/
    public static double montantCodesReferences(CodeReferenceSel sel1, CodeReferenceDuChantierSel sel2){
        double montant = 0;
        double quantite = 0;
        double montantTot = 0;
        
        try {
            CodeReferenceDto eng = FacadeDB.findCodeReferenceBySel(sel1);
            montant = eng.getPrixHtva();
            
            CodeReferenceDuChantierDto pema= FacadeDB.findCodeReferenceDuChantierBySel(sel2);
            quantite = pema.getQuantite();
            montantTot = quantite*montant;
            System.out.println(montantTot);
                    
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return montantTot;
    }  
    
    public static void insertCodeReference(CodeReferenceDto core){
        try {
            FacadeDB.addCodeReference(core);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteCodeReference(int idpemat){
        try {
            FacadeDB.deleteCodeReference(idpemat);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateCodeReference(CodeReferenceDto core){
        try {
            FacadeDB.updateCodeReference(core);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }   
    
    public static double supplement(CodeReferenceSel sel1, CodeReferenceDuChantierSel sel2, int supp){
            double montant = 0;
            double quantite = 0;
            double montantTot = 0;
        try {
            CodeReferenceDto eng = FacadeDB.findCodeReferenceBySel(sel1);
            montant = eng.getPrixHtva();
            CodeReferenceDuChantierDto pema= FacadeDB.findCodeReferenceDuChantierBySel(sel2);
            quantite = pema.getQuantite();
            montantTot = montant*quantite*supp;
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(montantTot);
        return montantTot;
    }
    
    /*CodesReferencesDuChantier*/
    

    /*Ouvriers*/
    public static Date calculAge(OuvrierSel sel1){
        Date dateNai = null;

        try {
            OuvrierDto ouv = FacadeDB.findOuvrierBySel(sel1);
            dateNai = ouv.getDateNaissance();
            System.out.println(dateNai);
            
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return dateNai;
    }  
    
    public static double montantOuvriers(OuvrierSel sel1, OuvrierDuChantierSel sel2){
        double cout = 0;
        double nombreHeures = 0;
        double montantTot = 0;
        
        try {
            OuvrierDto ouv = FacadeDB.findOuvrierBySel(sel1);
            cout = ouv.getRemuneration();
            
            OuvrierDuChantierDto ouvcha= FacadeDB.findOuvrierDuChantierBySel(sel2);
            nombreHeures = ouvcha.getNombreHeures();
            montantTot = cout*nombreHeures;
            System.out.println(montantTot);
                    
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return montantTot;
    }

    /*OuvriersDuChantier*/ 
    
    
    /*Conducteurs*/
    public static double montantConducteurs(ConducteurSel sel1, ConducteurDuChantierSel sel2){
        double cout = 0;
        double nombreHeures = 0;
        double montantTot = 0;
        
        try {
            ConducteurDto con = FacadeDB.findConducteurBySel(sel1);
            cout = con.getRemuneration();
            
            ConducteurDuChantierDto concha= FacadeDB.findConducteurDuChantierBySel(sel2);
            nombreHeures = concha.getNombreHeures();
            montantTot = cout*nombreHeures;
            System.out.println(montantTot);
                    
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return montantTot;
    }  

    /*ConducteursDuChantier*/
    
    /*Clients*/
    public static void insertClient(ClientDto cli){
        try {
            FacadeDB.addClient(cli);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteClient(int cli){
        try {
            FacadeDB.deleteClient(cli);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateClient(ClientDto cli){
        try {
            FacadeDB.updateClient(cli);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }       
    
    /*Voitures*/    
    public static double montantVoitures(VoitureSel voit, VoitureDuChantierSel sel){
        double montant = 0;
        double nombreJours = 0;
        double montantTot = 0;
        
        try {
            VoitureDto eng = FacadeDB.findVoitureBySel(voit);
            montant = eng.getPrixHtva();     
            VoitureDuChantierDto voiCha= FacadeDB.findVoitureDuChantierBySel(sel);
            nombreJours = voiCha.getNombreJours();
            montantTot = nombreJours*montant;
            System.out.println(montantTot);
                    
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return montantTot;
    }

    public static void insertVoiture(VoitureDto voi){
        try {
            FacadeDB.addVoiture(voi);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteVoiture(int idVoi){
        try {
            FacadeDB.deleteVoiture(idVoi);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateVoiture(VoitureDto voi){
        try {
            FacadeDB.updateVoiture(voi);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }     
    
    /*VoituresDuChantier*/
    
    /*Camions*/    
    public static double montantCamions(CamionSel cam, CamionDuChantierSel sel){
        double montant = 0;
        double nombreHeures = 0;
        double montantTot = 0;
        
        try {
            CamionDto eng = FacadeDB.findCamionBySel(cam);
            montant = eng.getPrixHtva();     
            CamionDuChantierDto camcha= FacadeDB.findCamionDuChantierBySel(sel);
            nombreHeures = camcha.getNombreHeures();
            montantTot = nombreHeures*montant;
            System.out.println(montantTot);
                    
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return montantTot;
    }

    public static void insertCamion(CamionDto cam){
        try {
            FacadeDB.addCamion(cam);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteCamion(int idCam){
        try {
            FacadeDB.deleteCamion(idCam);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateCamion(CamionDto cam){
        try {
            FacadeDB.updateCamion(cam);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
    /*CamionsDuChantier*/
    
    
    /*Devis*/
    public static void insertDevis(DevisDto dev){
        try {
            FacadeDB.addDevis(dev);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteDevis(int idDev){
        try {
            FacadeDB.deleteDevis(idDev);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateDevis(DevisDto dev){
        try {
            FacadeDB.updateDevis(dev);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }      
    
    
    
    
    
    
    
    
    
}


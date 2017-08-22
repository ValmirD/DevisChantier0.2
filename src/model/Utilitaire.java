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

import db.selDto.ChantierSel;
import db.dto.ChantierDto;

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
    public static void insertEnginDuChantier(EnginDuChantierDto engcha){
        try {
            FacadeDB.addEnginDuChantier(engcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteEnginDuChantier(int idEngcha){
        try {
            FacadeDB.deleteEnginDuChantier(idEngcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateEnginDuChantier(EnginDuChantierDto engcha){
        try {
            FacadeDB.updateEnginDuChantier(engcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }       
    
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
    public static void insertMateriauDuChantier(MateriauDuChantierDto matcha){
        try {
            FacadeDB.addMateriauDuChantier(matcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteMateriauDuChantier(int idMatcha){
        try {
            FacadeDB.deleteEnginDuChantier(idMatcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateMateriauDuChantier(MateriauDuChantierDto matcha){
        try {
            FacadeDB.updateMateriauDuChantier(matcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }   
    
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
    
    public static void deletePetitMateriel(int idPemat){
        try {
            FacadeDB.deletePetitMateriel(idPemat);                              
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
    public static void insertPetitMaterielDuChantier(PetitMaterielDuChantierDto pematcha){
        try {
            FacadeDB.addPetitMaterielDuChantier(pematcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deletePetitMaterielDuChantier(int idPematcha){
        try {
            FacadeDB.deletePetitMaterielDuChantier(idPematcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updatePetitMaterielDuChantier(PetitMaterielDuChantierDto pematcha){
        try {
            FacadeDB.updatePetitMaterielDuChantier(pematcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    } 
    
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
    public static void insertCodeReferenceDuChantier(CodeReferenceDuChantierDto corecha){
        try {
            FacadeDB.addCodeReferenceDuChantier(corecha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteCodeReferenceDuChantier(int idCorecha){
        try {
            FacadeDB.deleteCodeReferenceDuChantier(idCorecha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateCodeReferenceDuChantier(CodeReferenceDuChantierDto corecha){
        try {
            FacadeDB.updateCodeReferenceDuChantier(corecha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }       

    /*Ouvriers*/
    public static Date calculAge(OuvrierSel sel1){
        Date creation = null;
        try {
            OuvrierDto ouv = FacadeDB.findOuvrierBySel(sel1);
            creation = ouv.getDateNaissance();

            
            
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return creation;
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
            
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return montantTot;
    }
    
    public static void insertOuvrier(OuvrierDto ouv){
        try {
            FacadeDB.addOuvrier(ouv);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteOuvrier(int idOuv){
        try {
            FacadeDB.deleteOuvrier(idOuv);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateOuvrier(OuvrierDto ouv){
        try {
            FacadeDB.updateOuvrier(ouv);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }     

    /*OuvrierDuChantier*/ 
    public static void insertOuvrierDuChantier(OuvrierDuChantierDto ouvcha){
        try {
            FacadeDB.addOuvrierDuChantier(ouvcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteOuvrierDuChantier(int idOuvcha){
        try {
            FacadeDB.deleteOuvrierDuChantier(idOuvcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateOuvrierDuChantier(OuvrierDuChantierDto ouvcha){
        try {
            FacadeDB.updateOuvrierDuChantier(ouvcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    } 

    
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
                    
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return montantTot;
    }  

    public static void insertConducteur(ConducteurDto con){
        try {
            FacadeDB.addConducteur(con);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteConducteur(int idCon){
        try {
            FacadeDB.deleteConducteur(idCon);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateConducteur(ConducteurDto con){
        try {
            FacadeDB.updateConducteur(con);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }  
    
    /*ConducteurDuChantier*/
    public static void insertConducteurDuChantier(ConducteurDuChantierDto concha){
        try {
            FacadeDB.addConducteurDuChantier(concha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteConducteurDuChantier(int idConcha){
        try {
            FacadeDB.deleteConducteurDuChantier(idConcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateConducteurDuChantier(ConducteurDuChantierDto concha){
        try {
            FacadeDB.updateConducteurDuChantier(concha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }      
    
    /*Clients*/
    public static void insertClient(ClientDto cli){
        try {
            FacadeDB.addClient(cli);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteClient(int idCli){
        try {
            FacadeDB.deleteClient(idCli);                              
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
    public static void insertVoitureDuChantier(VoitureDuChantierDto voicha){
        try {
            FacadeDB.addVoitureDuChantier(voicha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteVoitureDuChantier(int idVoicha){
        try {
            FacadeDB.deleteVoitureDuChantier(idVoicha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateVoitureDuChantier(VoitureDuChantierDto voicha){
        try {
            FacadeDB.updateVoitureDuChantier(voicha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }   
    
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
                    
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return montantTot;
    }

    public static boolean insertCamion(CamionDto cam){
        try {
            FacadeDB.addCamion(cam);  
            return true;
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
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
    public static void insertCamionDuChantier(CamionDuChantierDto camcha){
        try {
            FacadeDB.addCamionDuChantier(camcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteCamionDuChantier(int idCamcha){
        try {
            FacadeDB.deleteCamionDuChantier(idCamcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateCamionDuChantier(CamionDuChantierDto camcha){
        try {
            FacadeDB.updateCamionDuChantier(camcha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }        
    
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
    
    /*Chantier*/
    public static void insertChantier(ChantierDto cha){
        try {
            FacadeDB.addChantier(cha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteChantier(int idCha){
        try {
            FacadeDB.deleteChantier(idCha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateChantier(ChantierDto cha){
        try {
            FacadeDB.updateChantier(cha);                              
        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }         
    
    
    
    
    
    
    
    
}


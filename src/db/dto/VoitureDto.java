/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dto;

/**
 *
 * @author Vali
 */
public class VoitureDto extends EntityDto<Integer> {
    
    private String marque;
    private String modele;
    private String numeroChassis;
    private String carburant;
    private double prixHtva;
    
    public VoitureDto(int idVoiture, String marque, String modele, String numeroChassis, String carburant, double prixHtva) {
        this.id = idVoiture;
        this.marque = marque;
        this.modele = modele;
        this.numeroChassis = numeroChassis;
        this.carburant = carburant;
        this.prixHtva = prixHtva;
    }    

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getNumeroChassis() {
        return numeroChassis;
    }

    public String getCarburant() {
        return carburant;
    }

    public double getPrixHtva() {
        return prixHtva;
    }




    
    
}

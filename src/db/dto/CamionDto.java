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
public class CamionDto extends EntityDto<Integer> {

    private String categorie;
    private int tonnage;
    private double capacite;
    private String marque;
    private String modele;
    private String numeroChassis;
    private String carburant;
    private double prixHtva;

    public CamionDto(int idCamion, String categorie, int tonnage, double capacite, String marque, String modele, String numeroChassis, String carburant, double prixHtva) {
        this.id = idCamion;
        this.categorie = categorie;
        this.tonnage = tonnage;
        this.capacite = capacite;
        this.marque = marque;
        this.modele = modele;
        this.numeroChassis = numeroChassis;
        this.carburant = carburant;
        this.prixHtva = prixHtva;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getTonnage() {
        return tonnage;
    }

    public double getCapacite() {
        return capacite;
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

    @Override
    public String toString() {
        return marque + " " + modele;
    }

}

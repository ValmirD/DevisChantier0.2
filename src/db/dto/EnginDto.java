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
public class EnginDto extends EntityDto<Integer> {
    
    private String nom;
    private String type;
    private String reference;
    private double prixHeure;

    public EnginDto(int idEngin, String nom, String type, String reference, double prixHeure) {
        this.id = idEngin;
        this.nom = nom;
        this.type = type;
        this.reference = reference;
        this.prixHeure = prixHeure;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String getReference() {
        return reference;
    }

    public double getPrixHeure() {
        return prixHeure;
    }
    
    
    
}

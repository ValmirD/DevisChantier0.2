package db.dto;

import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vali
 */
public class OuvrierDto extends EntityDto<Integer> {

    private double remuneration;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String numeroTelephone;
    private String email;
    private Date entreeFonction;
    private double cout;

    public OuvrierDto(int idOuvrier, double remuneration, String nom, String prenom, Date dateNaissance, String numeroTelephone, String email, Date entreeFonction, double cout) {
        this.id = idOuvrier;
        this.remuneration = remuneration;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroTelephone = numeroTelephone;
        this.email = email;
        this.entreeFonction = entreeFonction;
        this.cout = cout;
    }

    public double getRemuneration() {
        return remuneration;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public String getEmail() {
        return email;
    }

    public Date getEntreeFonction() {
        return entreeFonction;
    }

    public double getCout() {
        return cout;
    }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }

}

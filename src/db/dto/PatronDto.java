/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dto;

import java.sql.Date;

/**
 *
 * @author Vali
 */
public class PatronDto extends EntityDto<Integer> {

    private String password;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String email;
    private String numeroTelephonePro;
    private String numeroTelephone;

    public PatronDto(int idPatron, String password, String nom, String prenom, Date dateNaissance, String numeroTelephonePro, String numeroTelephone, String email) {
        this.id = idPatron;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroTelephonePro = numeroTelephonePro;
        this.numeroTelephone = numeroTelephone;
        this.email = email;
    }

    public String getPassword() {
        return password;
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

    public String getEmail() {
        return email;
    }

    public String getNumeroTelephonePro() {
        return numeroTelephonePro;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }



}

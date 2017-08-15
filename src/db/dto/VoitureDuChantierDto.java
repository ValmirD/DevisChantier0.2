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
public class VoitureDuChantierDto extends EntityDto<Integer> {
    
    private int idChantier;
    private int idVoiture;
    private Date debutDisponilibite;
    private Date finDisponilibite;
    private int nombreJours;

    public VoitureDuChantierDto(int idVoitureDuChantier,int idChantier, int idVoiture, Date debutDisponilibite, Date finDisponilibite, int nombreJours) {
        this.id = idVoitureDuChantier;
        this.idChantier = idChantier;
        this.idVoiture = idVoiture;
        this.debutDisponilibite = debutDisponilibite;
        this.finDisponilibite = finDisponilibite;
        this.nombreJours = nombreJours;
    }

    public int getIdChantier() {
        return idChantier;
    }

    public int getIdVoiture() {
        return idVoiture;
    }

    public Date getDebutDisponilibite() {
        return debutDisponilibite;
    }

    public Date getFinDisponilibite() {
        return finDisponilibite;
    }

    public int getNombreJours() {
        return nombreJours;
    }





    
    
    
}

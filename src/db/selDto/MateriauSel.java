/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.selDto;

/**
 *
 * @author Vali
 */
public class MateriauSel {
    
    private int idMateriau;
    private String nom;

    public MateriauSel(int idMateriau, String nom) {
        this.idMateriau = idMateriau;
        this.nom = nom;
    }

        public MateriauSel(int idMateriau) {
        this.idMateriau = idMateriau;
    }

    public int getIdMateriau() {
        return idMateriau;
    }

    public String getNom() {
        return nom;
    }


        
    
    
    
}

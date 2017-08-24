/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.db;

import db.dto.ChantierDto;
import db.exception.DevisChantierDbException;
import db.selDto.ChantierSel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vali
 */
public class ChantierDB {

    public static List<ChantierDto> getAllChantier() throws DevisChantierDbException {
        List<ChantierDto> elements = getCollection(new ChantierSel(0));
        return elements;
    }

    public static List<ChantierDto> getCollection(ChantierSel sel) throws DevisChantierDbException {
        List<ChantierDto> al = new ArrayList<>();
        try {
            String query = "Select idChantier, idClient, localisation, designationProjet, commentaire, dateCreationProjet, dateDebutPrevue, dateDebutEffective, dateFinPrevue, dateFinEffective, validationProjet FROM Chantier ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;
            String where = "";
            /*Pour une valeur numerique */
            if (sel.getIdChantier() != 0) {
                where = where + " idChantier = ? ";
            }
            
            if (sel.getIdClient() != 0) {
                where = where + " idClient = ? ";
            }            
            
            /*Pour une valeur string */
            if (sel.getDesignationProjet()!= null && !sel.getDesignationProjet().equals("")) {
                if (!where.equals("")) {
                    where = where + " AND ";
                }
                where = where + " designationProjet like ? ";
            }
            
          
            if (where.length() != 0) {
                where = " where " + where;
                query = query + where;
                stmt = connexion.prepareStatement(query);
                int i = 1;
                
                if (sel.getIdChantier() != 0) {
                    stmt.setInt(i, sel.getIdChantier());
                    i++;
                }
                
                if (sel.getIdClient() != 0) {
                    stmt.setInt(i, sel.getIdClient());
                    i++;
                }                

                if (sel.getDesignationProjet() != null && !sel.getDesignationProjet().equals("")) {
                    stmt.setString(i, sel.getDesignationProjet() + "%");
                    i++;
                }
            } else {
                stmt = connexion.prepareStatement(query);
            }
            java.sql.ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                al.add(new ChantierDto(
                        rs.getInt("idChantier"), 
                        rs.getInt("idClient"), 
                        rs.getString("localisation"),
                        rs.getString("designationProjet"),
                        rs.getString("commentaire"),
                        rs.getDate("dateCreationProjet"),
                        rs.getDate("dateDebutPrevue"),
                        rs.getDate("dateDebutEffective"),
                        rs.getDate("dateFinPrevue"),                        
                        rs.getDate("dateFinEffective"),
                        rs.getBoolean("validationProjet")                      
                )
                );
            }
        } catch (java.sql.SQLException eSQL) {
            throw new DevisChantierDbException("Instanciation de Chantier impossible:\nSQLException: " + eSQL.getMessage());
        }
        return al;
    }

    public static void deleteDb(int id) throws DevisChantierDbException {
        try {
            java.sql.Statement stmt = DBManager.getConnection().createStatement();
            stmt.execute("Delete from Chantier where idChantier=" + id);
        } catch (DevisChantierDbException | SQLException ex) {
            throw new DevisChantierDbException("Chantier: suppression impossible\n" + ex.getMessage());
        }
    }

    public static void updateDb(ChantierDto el) throws DevisChantierDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();

            java.sql.PreparedStatement update;
            String sql = "Update Chantier set "
                    + "idClient=?, "
                    + "localisation=?, "
                    + "designationProjet=?, "
                    + "commentaire=?, "
                    + "dateCreationProjet=?, "
                    + "dateDebutPrevue=?, "
                    + "dateDebutEffective=?, "
                    + "dateFinPrevue=?, "
                    + "dateFinEffective=?, "
                    + "validationProjet=? "                   
                    + "where idChantier=?";
            System.out.println(sql);
            update = connexion.prepareStatement(sql);
            update.setInt(1, el.getIdClient());
            update.setString(2, el.getLocalisation());
            update.setString(3, el.getDesignationProjet());
            update.setString(4, el.getCommentaire());
            update.setDate(5, el.getDateCreationProjet());
            update.setDate(6, el.getDateDebutPrevue());
            update.setDate(7, el.getDateDebutEffective());
            update.setDate(8, el.getDateFinPrevue());            
            update.setDate(9, el.getDateFinEffective());
            update.setBoolean(10, el.isValidationProjet());
            update.setInt(11, el.getId());
            update.executeUpdate();
        } catch (DevisChantierDbException | SQLException ex) {
            throw new DevisChantierDbException("Chantier, modification impossible:\n" + ex.getMessage());
        }
    }

    public static int insertDb(ChantierDto el) throws DevisChantierDbException {
        try {
            int num = SequenceDB.getNextNum(SequenceDB.CHANTIER);
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement insert;
            insert = connexion.prepareStatement(
                    "Insert into Chantier(idChantier, idClient, localisation, designationProjet, commentaire, dateCreationProjet, dateDebutPrevue, dateDebutEffective, dateFinPrevue, dateFinEffective, validationProjet) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            insert.setInt(1, num);
            insert.setInt(2, el.getIdClient());
            insert.setString(3, el.getLocalisation());
            insert.setString(4, el.getDesignationProjet());
            insert.setString(5, el.getCommentaire());
            insert.setDate(6, el.getDateCreationProjet());
            insert.setDate(7, el.getDateDebutPrevue());
            insert.setDate(8, el.getDateDebutEffective());
            insert.setDate(9, el.getDateFinPrevue());
            insert.setDate(10, el.getDateFinEffective());
            insert.setBoolean(11, el.isValidationProjet());
            insert.executeUpdate();
            return num;
        } catch (DevisChantierDbException | SQLException ex) {
            throw new DevisChantierDbException("Chantier: ajout impossible\n" + ex.getMessage());
        }
    }
}


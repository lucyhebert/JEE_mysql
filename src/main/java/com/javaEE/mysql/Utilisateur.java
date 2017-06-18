package com.javaEE.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Lucy on 18/06/2017.
 */

@Entity(name = "Utilisateurs")
public class Utilisateur {

    @Id
    private String handle;
    private Timestamp inscription;
    private String prenom;
    private String nom;

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public Timestamp getInscription() {
        return inscription;
    }

    public void setInscription(Timestamp inscription) {
        this.inscription = inscription;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

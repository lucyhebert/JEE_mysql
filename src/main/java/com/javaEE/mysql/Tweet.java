package com.javaEE.mysql;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by p1614402 on 24/05/2017.
 */
public class Tweet {

    private Integer id;
    private Timestamp date;
    private String contenu;
    private String auteur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}

package com.javaEE.mysql;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by p1614402 on 24/05/2017.
 */
public class Tweet {

    private Integer id;
    private Timestamp date;
    private String contenu;
    private Utilisateur auteur;
    private List<String> retweetersHandles;

    public Tweet() {
        this.retweetersHandles = new ArrayList<String>();
    }

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

    public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }
}

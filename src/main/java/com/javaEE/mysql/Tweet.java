package com.javaEE.mysql;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by p1614402 on 24/05/2017.
 */

@Entity(name = "tweets")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Timestamp date;

    private String contenu;

    private String auteur;

    @OneToMany
    @JoinTable(
            name="retweets",
            joinColumns = @JoinColumn( name="tweet"),
            inverseJoinColumns = @JoinColumn( name="utilisateur")
    )
    private List<Utilisateur> retweeters;


    public Tweet() {
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

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public List<Utilisateur> getRetweeters() {
        return retweeters;
    }

    public void setRetweeters(List<Utilisateur> retweeters) {
        this.retweeters = retweeters;
    }
}

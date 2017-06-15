package com.javaEE.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by p1614402 on 24/05/2017.
 */

@RestController
public class Controller {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/count")
    public int countTweets() {
        return jdbcTemplate.queryForObject("select count(*) from tweets", Integer.class);
    }

//    @RequestMapping("/list")
//    public List<Tweet> getTweets(@RequestParam(value = "auteur", required = false) String auteur) {
//        if(auteur != null) {
//            return this.jdbcTemplate.query(
//                    "select id, date, contenu, auteur from tweets where auteur =?",
//                    (rs, rowNum) -> {
//                        Tweet tweet = new Tweet();
//                        tweet.setId(rs.getInt("id"));
//                        tweet.setDate(rs.getTimestamp("date"));
//                        tweet.setContenu(rs.getString("contenu"));
//                        tweet.setAuteur(rs.getString("auteur"));
//                        return tweet;
//                    }, auteur);
//        }
//
//        return this.jdbcTemplate.query(
//                "select id, date, contenu, auteur from tweets",
//                (rs, rowNum) -> {
//                    Tweet tweet = new Tweet();
//                    tweet.setId(rs.getInt("id"));
//                    tweet.setDate(rs.getTimestamp("date"));
//                    tweet.setContenu(rs.getString("contenu"));
//                    tweet.setAuteur(rs.getString("auteur"));
//                    return tweet;
//                });
//    }

    @RequestMapping("/list")
    public List<Tweet> getTweets(@RequestParam(value = "auteur", required = false) String auteur) {
        if(auteur != null) {
            return this.jdbcTemplate.query(
                    "select id, date, contenu, auteur from tweets where auteur =? order by date desc",
                    (rs, rowNum) -> {
                        Tweet tweet = new Tweet();
                        tweet.setId(rs.getInt("id"));
                        tweet.setDate(rs.getTimestamp("date"));
                        tweet.setContenu(rs.getString("contenu"));
                        tweet.setAuteur(rs.getString("auteur"));
                        return tweet;
                    }, auteur);
        }

        return this.jdbcTemplate.query(
                "select id, date, contenu, auteur from tweets order by date desc",
                (rs, rowNum) -> {
                    Tweet tweet = new Tweet();
                    tweet.setId(rs.getInt("id"));
                    tweet.setDate(rs.getTimestamp("date"));
                    tweet.setContenu(rs.getString("contenu"));
                    tweet.setAuteur(rs.getString("auteur"));
                    return tweet;
                });
    }

    @RequestMapping(value="/tweet", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void createTweet(@RequestParam String auteur, @RequestParam String contenu) {
        jdbcTemplate.update("insert into tweets(auteur, contenu) values(?, ?)", auteur, contenu);
    }

    @RequestMapping("/utilisateurs")
    public List<String> getAuteurs() {

        return this.jdbcTemplate.query(
                "select handle, inscription, prenom, nom from utilisateurs order by inscription",
                (rs, rowNum) -> {
                    String handle = (rs.getString("handle"));
                    handle += " " + (rs.getString("inscription"));
                    handle += " " + (rs.getString("prenom"));
                    handle += " " + (rs.getString("nom"));
                    return handle;
                });
    }

    @RequestMapping(value="/retweet", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<HttpStatus> createRetweet(@RequestParam String utilisateur, @RequestParam String tweet) {
        String auteur = jdbcTemplate.queryForObject("select auteur from tweets where id = " + tweet, String.class);

        if(!utilisateur.equals(auteur)) {
            jdbcTemplate.update("insert into retweets(tweet, utilisateur) values(?, ?)", tweet, utilisateur);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

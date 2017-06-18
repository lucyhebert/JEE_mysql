package com.javaEE.mysql;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Lucy on 18/06/2017.
 */
public interface TweetRepository extends CrudRepository<Tweet, Integer> {

    List<Tweet> findAllByOrderByDateDesc();
    List<Tweet> findByAuteurOrderByDateDesc(String auteur);
}

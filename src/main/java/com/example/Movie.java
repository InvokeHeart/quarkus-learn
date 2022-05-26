package com.example;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;

@ApplicationScoped
@Superior
public class Movie {
    private String name;
    private String text;


    public Movie(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Movie() {
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

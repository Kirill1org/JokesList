package com.koromyslov.jokeslist.ResponseDAO;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JokeDAOList {

    @SerializedName("value")
    @Expose
    private List<JokeDAO> jokeDAOList = null;


    public List<JokeDAO> getJokeDAOList() {
        return jokeDAOList;
    }

}

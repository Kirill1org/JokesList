package com.koromyslov.jokeslist.Model;

import com.koromyslov.jokeslist.ResponseDAO.JokeDAOList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface JokesService {
    @GET("random/{countOfJokes}")
    Observable<JokeDAOList> getJokesList(@Path("countOfJokes") int countOfJokes);

}

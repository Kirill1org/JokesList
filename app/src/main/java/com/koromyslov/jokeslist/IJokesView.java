package com.koromyslov.jokeslist;

import com.arellomobile.mvp.MvpView;
import com.koromyslov.jokeslist.ResponseDAO.Joke;

import java.util.List;

public interface IJokesView extends MvpView {

    void showJokes(List<Joke> jokeList);

    void showError(Throwable e);

}

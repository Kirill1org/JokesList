package com.koromyslov.jokeslist.Presenter;

import android.widget.Button;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.koromyslov.jokeslist.Model.JokesService;
import com.koromyslov.jokeslist.Model.NetworkModule;
import com.koromyslov.jokeslist.ResponseDAO.Joke;
import com.koromyslov.jokeslist.ResponseDAO.JokeDAO;
import com.koromyslov.jokeslist.ResponseDAO.JokeDAOList;
import com.koromyslov.jokeslist.IJokesView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class JokePresenter extends MvpPresenter<IJokesView> implements IJokePresenter {


    private List<Joke> jokesResultList = new ArrayList<>();
    private Button reloadBtn;

    @Override
    public void getJokes(int countOfJokes) {

        JokesService api = new NetworkModule().jokesService;

        api.getJokesList(countOfJokes)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::addToListJokes, Throwable -> getViewState().showError(Throwable));
    }

    public void addToListJokes(JokeDAOList jokeDAOList) {
        for (JokeDAO jokeDAOUnit : jokeDAOList.getJokeDAOList()) {
            jokesResultList.add(new Joke(jokeDAOUnit.getJoke()));
        }
        getViewState().showJokes(jokesResultList);
    }
}

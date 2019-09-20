package com.koromyslov.jokeslist.Presenter;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface IJokePresenter {

    @StateStrategyType(SkipStrategy.class)
    void getJokes(int countOfJokes);
}

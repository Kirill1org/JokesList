package com.koromyslov.jokeslist.View;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.koromyslov.jokeslist.IJokesView;
import com.koromyslov.jokeslist.Presenter.JokePresenter;
import com.koromyslov.jokeslist.R;
import com.koromyslov.jokeslist.ResponseDAO.Joke;

import java.util.List;


public class JokesFragment extends MvpAppCompatFragment implements IJokesView {

    private RecyclerView rv;
    private Button reloadBtn;
    private EditText editCount;


    @InjectPresenter
    JokePresenter mJokePresenter;

    public JokesFragment() {
        // Required empty public constructor
    }


    public static JokesFragment newInstance() {
        JokesFragment fragment = new JokesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_jokes, container, false);
        rv = rootView.findViewById(R.id.recyclerView);
        reloadBtn = rootView.findViewById(R.id.reload_btn);
        editCount = rootView.findViewById(R.id.editCount);


        reloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mJokePresenter.getJokes(Integer.valueOf(editCount.getText().toString()));
            }
        });

        return rootView;
    }

    @Override
    public void showJokes(List<Joke> jokeList) {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new RVAdapter(getActivity(), jokeList));
        rv.setVerticalScrollBarEnabled(true);
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

}

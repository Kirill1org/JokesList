package com.koromyslov.jokeslist.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.koromyslov.jokeslist.R;
import com.koromyslov.jokeslist.ResponseDAO.Joke;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.JokeViewHolder> {

    private List<Joke> jokeList;
    private LayoutInflater inflater;
    private Context context;

    public RVAdapter(Context context, List<Joke> jokeList) {
        this.jokeList = jokeList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);


    }

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JokeViewHolder(inflater.inflate(R.layout.joke_model, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        holder.bind(jokeList.get(position));
    }

    @Override
    public int getItemCount() {
        return jokeList.size();
    }


    class JokeViewHolder extends RecyclerView.ViewHolder {

        private TextView jokeTest;

        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);

            jokeTest = itemView.findViewById(R.id.jokes_text_view);
        }

        public void bind(Joke joke) {
            jokeTest.setText(joke.getJokeText());
        }

    }
}

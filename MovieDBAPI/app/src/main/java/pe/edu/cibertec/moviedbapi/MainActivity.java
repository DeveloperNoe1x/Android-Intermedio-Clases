package pe.edu.cibertec.moviedbapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> items;

   // @BindView(R.id.tv_pokemon)
    EditText et_pokemon;

    MovieAdapter movieAdapter;

   // @BindView(R.id.rv_lista)
    RecyclerView rv_lista;

    Button bt_search ;

    //@OnClick(R.id.bt_search)
    void searchMovies(){
        String apikey = "3cae426b920b29ed2fb1c0749f258325";
        final String movie = et_pokemon.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonInterface pokemoninterface = retrofit.create(PokemonInterface.class);
        Call<MovieResponse> movieresponse = pokemoninterface.searchMovies(apikey,movie);
        movieresponse.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()){
                    MovieResponse movieresponse = response.body();
                    items = movieresponse.getMovies();

                    movieAdapter = new MovieAdapter(items);
                    rv_lista.setAdapter(movieAdapter);
                    rv_lista.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d("MainActivity",t.toString());
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  ButterKnife.bind(this);

        et_pokemon = findViewById(R.id.tv_pokemon);
        rv_lista = findViewById(R.id.rv_lista);
        bt_search = findViewById(R.id.bt_search);

        items = new ArrayList<>();

        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchMovies();



            }
        });


    }



}

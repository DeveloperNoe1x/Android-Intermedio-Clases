package pe.edu.cibertec.moviedbapi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;



public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.LayoutMovie> {

    ArrayList<Movie> movies;

    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public LayoutMovie onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_layout,viewGroup,false);
        LayoutMovie vh = new LayoutMovie(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull LayoutMovie viewHolder, int position) {

        viewHolder.tvName.setText(movies.get(position).getTitle());
        viewHolder.tvoperacion.setText(movies.get(position).getOverview());
        viewHolder.dtfecha.setText(movies.get(position).getReleaseDate());

        Glide.with(viewHolder.itemView).load("http://image.tmdb.org/t/p/w185/" + movies.get(position).getPorterPath()).into(viewHolder.ivMovie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class LayoutMovie extends RecyclerView.ViewHolder{

      //  @BindView(R.id.tv_nombre)
        TextView tvName;

       // @BindView(R.id.dt_fecha)
        TextView dtfecha;

        // @BindView(R.id.tv_overview)
        TextView tvoperacion;

        // @BindView(R.id.ivpokemon)
        ImageView ivMovie;

        public  LayoutMovie(@NonNull View ItemView){
            super(ItemView);
           // ButterKnife.bind(this,itemView);
            tvName = itemView.findViewById(R.id.tv_nombre);
            dtfecha = itemView.findViewById(R.id.dt_fecha) ;
            tvoperacion = itemView.findViewById(R.id.tv_overview);
            ivMovie = itemView.findViewById(R.id.ivpokemon);

        }
    }

}

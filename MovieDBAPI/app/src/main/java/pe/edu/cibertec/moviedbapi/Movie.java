package pe.edu.cibertec.moviedbapi;

import com.google.gson.annotations.SerializedName;

public class Movie {

    private String title;
    private String overview;

    @SerializedName("poster_path")
    private String porterPath;

    @SerializedName("release_date")
    private String releaseDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPorterPath() {
        return porterPath;
    }

    public void setPorterPath(String porterPath) {
        this.porterPath = porterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}

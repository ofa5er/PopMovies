package me.oueslati.fakher.popmovies.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import me.oueslati.fakher.popmovies.Model.Movie;


public class TheMoviedbJsonUtil {
    private static final String TAG = TheMoviedbJsonUtil.class.getSimpleName();
    private static final String THEMOVIEDB_RESULTS = "results";
    private static final String THEMOVIEDB_POSTER_PATH = "poster_path";

    public static Movie[] getMoviesFromJson(String movieJsonStr) throws JSONException {
        JSONObject movieJson = new JSONObject(movieJsonStr);
        JSONArray movieArray =
                movieJson.getJSONArray(THEMOVIEDB_RESULTS);

        Movie[] result = new Movie[movieArray.length()];

        for (int i = 0; i < movieArray.length(); i++) {
            String posterPath;
            JSONObject movie = movieArray.getJSONObject(i);
            posterPath = movie.getString(THEMOVIEDB_POSTER_PATH);
            Movie mv = new Movie();
            mv.setPosterPath(posterPath);
            result[i] = mv;
        }
        return result;
    }
}

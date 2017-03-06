package me.oueslati.fakher.popmovies.url;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;

import me.oueslati.fakher.popmovies.R;
import me.oueslati.fakher.popmovies.util.TheMoviedbNetworkUtil;

import static org.junit.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
public class ThemoviedbJsonUtilInstrumentedTest {
    @Test
    public void buildURLMostPopular_isCorrect() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        String expectedUrlString = "https://api.themoviedb.org/3/movie/popular?" +
                "api_key=" + appContext.getString(R.string.themoviedb_application_key);
        TheMoviedbNetworkUtil.API_Key = appContext.getString(R.string.themoviedb_application_key);
        URL actualURL = TheMoviedbNetworkUtil.buildURLMostPopular();
        String actualURLString = actualURL.toString();
        assertEquals(actualURLString, expectedUrlString);
    }

    @Test
    public void buildURLTopRated_isCorrect() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        String expectedUrlString = "https://api.themoviedb.org/3/movie/top_rated?" +
                "api_key=" + appContext.getString(R.string.themoviedb_application_key);
        TheMoviedbNetworkUtil.API_Key = appContext.getString(R.string.themoviedb_application_key);
        URL actualURL = TheMoviedbNetworkUtil.buildURLTopRated();
        String actualURLString = actualURL.toString();
        assertEquals(actualURLString, expectedUrlString);
    }

}

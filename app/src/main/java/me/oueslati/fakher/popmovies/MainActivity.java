package me.oueslati.fakher.popmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.oueslati.fakher.popmovies.util.TheMoviedbNetworkUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TheMoviedbNetworkUtil.API_Key = getString(R.string.themoviedb_application_key);
    }
}

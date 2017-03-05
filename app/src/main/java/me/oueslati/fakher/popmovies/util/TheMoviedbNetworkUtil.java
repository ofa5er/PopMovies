package me.oueslati.fakher.popmovies.util;


import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 */

public class TheMoviedbNetworkUtil {

    private static final String TAG = TheMoviedbNetworkUtil.class.getSimpleName();
    private static final String THEMOVIEDB_API_URL = "https://api.themoviedb.org/3";
    private static final String POPULAR_MOVIES_ENTRY_POINT = "/movie/popular";


    private static final String API_KEY_PARAM = "api_key";

    public static String API_Key = "";


    public static URL buildURLMostPopular() {
        Uri searchQueryUri = Uri.parse(THEMOVIEDB_API_URL + POPULAR_MOVIES_ENTRY_POINT).buildUpon()
                .appendQueryParameter(API_KEY_PARAM, API_Key)
                .build();
        try {
            return new URL(searchQueryUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Perform a HTTP request using an URL and return the response in a String format.
     *
     * @param url the URL of the request.
     * @return Return the response of the HTTP request.
     * @throws IOException return an exception if there an IO error
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        Log.v(TAG, "getResponseFromHttpUrl - URL :" + url.toString());
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();
            String response = null;
            if (hasInput) {
                response = scanner.next();
            }
            scanner.close();
            Log.v(TAG, "getResponseFromHttpUrl - Response :" + response);
            return response;
        } finally {
            urlConnection.disconnect();
        }
    }
}

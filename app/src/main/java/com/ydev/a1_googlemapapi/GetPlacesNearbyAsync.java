package com.ydev.a1_googlemapapi;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by YRT on 28/03/2018.
 */

public class GetPlacesNearbyAsync extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                    "location=-33.8670522,151.1957362" +
                    "&radius=50000" +
                    "&type=restaurant" +
                    "&keyword=cruise" +
                    "&key=AIzaSyA6Qa5JPT6O1dmqwZj0im0dqQzgYIDauao\n");
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        }catch (Exception e){
            return null;
        }finally {
            urlConnection.disconnect();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Log.d("AsyncTask", s);
    }
}

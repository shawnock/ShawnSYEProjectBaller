package com.example.shawnocked.syeballerapp;

import android.os.AsyncTask;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by shawnocked on 5/4/17.
 */

// Three AsyncTask's arguments are params, progress, and result, which are all string here
public class UserInfoBackGroundTask extends AsyncTask<String, String, String> {

    protected String err="Opssss!!";

    @Override
    protected String doInBackground(String... params) {
        try {

            // my IP address to serve as the server
            String local = "http://10.70.25.39:8000/";
            String machine = "http://localhost:8000/";

            HttpURLConnection httpURLConnection = null;

            // open a HttpURLConnection
            httpURLConnection = (HttpURLConnection) new URL(local+""+params[0]).openConnection();

            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);

            // set request headers
            httpURLConnection.setRequestProperty("gender", params[1]);
            httpURLConnection.setRequestProperty("height", params[2]);
            httpURLConnection.setRequestProperty("weight", params[3]);
            httpURLConnection.setRequestProperty("basketballStyle", params[4]);
            httpURLConnection.setRequestProperty("favorableBasketballCourt", params[5]);
            httpURLConnection.setRequestProperty("availableTime", params[6]);
            httpURLConnection.setRequestProperty("position", params[7]);


            httpURLConnection.connect();
            Log.d("It is connected now !"," okay");

            String respond=Integer.toString(httpURLConnection.getResponseCode());

            // the response body has been read, disconnect
            Log.d("Disconnect !<===== !!>",respond);
            httpURLConnection.disconnect();
            return respond;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return err;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("Finshed ", "Execution");
    }
}

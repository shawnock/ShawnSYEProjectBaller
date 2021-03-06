package com.example.shawnocked.syeballerapp;


import android.os.AsyncTask;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.URL;

public class BackgroundTask extends AsyncTask<String, String, String> {

    protected String err="Opssss!!";

    @Override
    protected void onPreExecute(){
    }
    @Override
    protected String doInBackground (String... params){

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
            httpURLConnection.setRequestProperty("email", params[1]);
            httpURLConnection.setRequestProperty("passcode", params[2]);

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
    protected void onPostExecute (String result){
        Log.d("Finshed ", "Execution");
    }

}
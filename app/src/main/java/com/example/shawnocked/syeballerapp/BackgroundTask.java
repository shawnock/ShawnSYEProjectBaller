package com.example.shawnocked.syeballerapp;


import android.os.AsyncTask;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.URL;

public class BackgroundTask extends AsyncTask<String, String, String> {

    protected String r="Opssss!!";

    @Override
    protected void onPreExecute(){
    }
    @Override
    protected String doInBackground (String... params){

        try {

            String local = "http://192.168.1.18:8000/";
            String machine = "http://localhost:8000/";

            HttpURLConnection httpURLConnection = null;

            httpURLConnection = (HttpURLConnection) new URL(local+""+params[0]).openConnection();

            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("email", params[1]);
            httpURLConnection.setRequestProperty("passcode", params[2]);

            httpURLConnection.connect();
            Log.d("It is connected now !! "," okay");

            String respond=Integer.toString(httpURLConnection.getResponseCode());

            Log.d("Disconnect !<===== !!>",respond);
            httpURLConnection.disconnect();
            return respond;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }


    @Override
    protected void onPostExecute (String result){
        Log.d("Finshed ", "Execution");
    }

}
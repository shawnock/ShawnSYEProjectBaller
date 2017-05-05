package com.example.shawnocked.syeballerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.TimeUnit;

/**
 * Created by shawnocked on 2/23/17.
 */

public class SignUpActivity extends Activity {
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button next_page_button = (Button) findViewById(R.id.sign_up_button);
        username = (EditText) findViewById(R.id.signup_enter_username);
        password = (EditText) findViewById(R.id.signup_enter_password);
        next_page_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String re="";
                BackgroundTask asyncLoad = new BackgroundTask();
                asyncLoad.execute("signup/", username.getText().toString(),password.getText().toString());
                try{
                    re = asyncLoad.get(5, TimeUnit.SECONDS);
                    Log.d("HOPE ON ==============>",re);
                    if(re.equals("200")) {
                        Intent intent = new Intent(SignUpActivity.this, ProfileActivity.class);
                        startActivity(intent);
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        );
    }


}

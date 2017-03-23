package com.example.shawnocked.syeballerapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.zip.Inflater;

import static java.security.AccessController.getContext;

/**
 * A class contain users' basic information
 * Created by shawnocked on 11/8/16.
 */

public class UserInfo {

    private String gender;
    private String height;
    private String weight;
    private String basketballStyle;
    private String favorableBasketballCourt;
    private String availableTime;
    private String position;


    public UserInfo(String gender,
                    String height,
                    String weight,
                    String basketballStyle,
                    String favorableBasketballCourt,
                    String availableTime,
                    String position)
    {
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.basketballStyle = basketballStyle;
        this.favorableBasketballCourt = favorableBasketballCourt;
        this.availableTime = availableTime;
        this.position = position;
    }

}

package com.example.shawnocked.syeballerapp;

import android.app.Fragment;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * A class containing an array for listview adapter
 * Created by shawnocked on 2/9/17.
 */

public class UserList {
    public String information;
    public EditText editText;

    public UserList(String info, EditText editText){
        this.information = info;
        this.editText = editText;
    }

    public static ArrayList<UserList> getList(Fragment fragment) {
        EditText input = (EditText) fragment.getActivity().findViewById(R.id.enter_username);
        ArrayList<UserList> userLists = new ArrayList<>();
        userLists.add(new UserList("Gender: ", input));
        userLists.add(new UserList("Height: ", input));
        userLists.add(new UserList("Weight: ", input));
        userLists.add(new UserList("Basketball Style: ", input));
        userLists.add(new UserList("Favorable Basketball Court: ", input));
        userLists.add(new UserList("Available Time: ", input));
        userLists.add(new UserList("Position: ", input));
        return userLists;
    }

    public EditText getEditText() {
        return editText;
    }
}

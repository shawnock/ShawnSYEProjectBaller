package com.example.shawnocked.syeballerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shawnocked on 11/8/16.
 */

public class CustomUsersAdapter extends ArrayAdapter<UserList>{
    public CustomUsersAdapter(Context context, ArrayList<UserList> userLists) {super(context, 0, userLists);}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        UserList userList = getItem(position);

        if(convertView == null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }

        TextView input = (TextView) convertView.findViewById(R.id.username);
        EditText userInfoEnter = (EditText) convertView.findViewById(R.id.enter_username);

        input.setText(userList.information);

        return convertView;
    }

}

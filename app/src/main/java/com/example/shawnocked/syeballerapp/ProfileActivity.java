package com.example.shawnocked.syeballerapp;


import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileActivity extends Activity {

    private ListItemFragment listItemFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        listItemFragment = (ListItemFragment) getFragmentManager().findFragmentById(R.id.list_item_fragment);
        populateUsersList();

    }

    private void populateUsersList() {
        // Construct the data source
        ArrayList<UserList> arrayOfUserInput = UserList.getList(listItemFragment);

        // Create the adapter to convert the array to views
        CustomUsersAdapter adapter = new CustomUsersAdapter(this, arrayOfUserInput);

        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.list_info);
        listView.setAdapter(adapter);
    }

}

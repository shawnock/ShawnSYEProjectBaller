package com.example.shawnocked.syeballerapp;


import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileActivity extends Activity{

    private ListItemFragment listItemFragment;
    CustomUsersAdapter adapter;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        Button done_button = (Button) findViewById(R.id.doneButton);

        listItemFragment = (ListItemFragment) getFragmentManager().findFragmentById(R.id.list_item_fragment);
        populateUsersList();




        // this part only return the UserList
/*        final EditText gender = (EditText) listView.getItemAtPosition(0);
        final EditText height = (EditText) listView.getItemAtPosition(1);
        final EditText weight = (EditText) listView.getItemAtPosition(2);
        final EditText style = (EditText) listView.getItemAtPosition(3);
        final EditText court = (EditText) listView.getItemAtPosition(4);
        final EditText time = (EditText) listView.getItemAtPosition(5);
        final EditText pst = (EditText) listView.getItemAtPosition(6);*/

        // tried UserList but will return the user input
        //final UserList test = (UserList) listView.getItemAtPosition(0);

        // last try
        // chunk of userinfo... so sad that cannot make it work correctly

        final View gender = this.adapter.getViewByPosition(0, this.listView);
        final View height = this.adapter.getViewByPosition(1, this.listView);
        final View weight = this.adapter.getViewByPosition(2, this.listView);
        final View style = this.adapter.getViewByPosition(3, this.listView);
        final View court = this.adapter.getViewByPosition(4, this.listView);
        final View time = this.adapter.getViewByPosition(5, this.listView);
        final View pst = this.adapter.getViewByPosition(6, this.listView);


        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String re="";
                UserInfoBackGroundTask asyncLoad = new UserInfoBackGroundTask();

                //Log.d(test.getEditText().getText().toString(), "This is the Message");

                asyncLoad.execute("userinfo/", gender.toString(), height.toString(), weight.toString(),
                        style.toString(), court.toString(), time.toString(), pst.toString());
                try{
                    re = asyncLoad.get(5, TimeUnit.SECONDS);
                    Log.d("HOPE ON ==============>",re);
                    if(re.equals("200")) {
                        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

    }

    private void populateUsersList() {
        // Construct the data source
        ArrayList<UserList> arrayOfUserInput = UserList.getList(listItemFragment);

        // Create the adapter to convert the array to views
        this.adapter = new CustomUsersAdapter(this, arrayOfUserInput);

        // Attach the adapter to a ListView
        this.listView = (ListView) findViewById(R.id.list_info);
        listView.setAdapter(adapter);
    }

}

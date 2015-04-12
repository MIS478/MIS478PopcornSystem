package com.mis478.popcornapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Donation extends ActionBarActivity {
    public final static String test = "com.mis478.popcornapp.test";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        //Get info from the previous screen
        Intent intent = getIntent();
    }

    public void ScoutMain(View view) {
        Intent intent = new Intent(this, ScoutMainPage.class);
        startActivity(intent);
    }

    public void CustomerInfo(View view) {
        Intent intent = new Intent(this, CustomerInfo.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_donation, menu);
        return true;
    }

    public void ToFinalize(View view) {
        //when the "Next" button is hit it creates an intent
        Intent finalize = new Intent(this, OrderFinalization.class);

        //finds the EditText boxes on the screen that contain the Customer's info
        EditText amount = (EditText) findViewById(R.id.editText17);

        //parses the EditText into a string
        String AmountText = amount.getText().toString();


        //attaches the donation amount to the intent
        finalize.putExtra(test, AmountText);

        //starts the next screen
        startActivity(finalize);
    }

    public void ToProducts(View view) {
        Intent products = new Intent(this, OrderFinalization.class);
        startActivity(products);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

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
        setTitle("Donations");

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
        getMenuInflater().inflate(R.menu.menu_scout_status_page, menu);
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
        if (id == R.id.scoutGoal) {
            Intent intent = new Intent(this, ScoutGoal.class);
            startActivity(intent);
        }
        if (id == R.id.deliveryMode) {
            Intent intent = new Intent(this, DeliveryMode.class);
            startActivity(intent);
        }
        if (id == R.id.pastSales) {
            Intent intent = new Intent(this, PastSales.class);
            startActivity(intent);
        }

        if (id == R.id.sales_mode) {
            Intent intent = new Intent(this, SalesMode.class);
            startActivity(intent);
        }
        if (id == R.id.donation) {
            Intent intent = new Intent(this, Donation.class);
            startActivity(intent);
        }
        if (id == R.id.ScoutMain) {
            Intent intent = new Intent(this, ScoutMainPage.class);
            startActivity(intent);
        }
        if (id == R.id.log) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}

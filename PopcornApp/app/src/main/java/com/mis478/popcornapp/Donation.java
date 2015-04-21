package com.mis478.popcornapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Donation extends ActionBarActivity {


    //declaring local variables
    public RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        //Get info from the previous screen
        Intent intent = getIntent();

        //initializing variables
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    public void ScoutMain(View view) {
        Intent intent = new Intent(this, ScoutMainPage.class);
        startActivity(intent);
    }

    public void ToFinalize(View view) {
        //when the "Next" button is hit it creates an intent
        Intent finalize = new Intent(this, CustomerInfo.class);

        //finds the EditText boxes on the screen that contain the Customer's info
        EditText damnt = (EditText) findViewById(R.id.donationamount);


        //parses the EditText into a string
        String damnttext = damnt.getText().toString();

        //Verifies the information is inputted correctly.  If not then it will throw an error message
        if (damnttext.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Amount")
                    .setMessage("An amount is required to go forward")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else {
            //starts the next screen
            startActivity(finalize);
        }
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.ScoutMain) {
            Intent intent = new Intent(this, ScoutMainPage.class);
            startActivity(intent);
        }
        if (id == R.id.deliveryMode) {
            Intent intent = new Intent(this, DeliveryMode.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }
}
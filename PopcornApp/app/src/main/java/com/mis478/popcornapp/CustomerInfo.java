package com.mis478.popcornapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class CustomerInfo extends ActionBarActivity {
    public final static String fNameIntent = "com.mis478.popcornapp.fname";
    public final static String lNameIntent = "com.mis478.popcornapp.lname";
    public final static String addressIntent = "com.mis478.popcornapp.address";
    public final static String cityIntent = "com.mis478.popcornapp.city";
    public final static String stateIntent = "com.mis478.popcornapp.state";
    public final static String zipIntent = "com.mis478.popcornapp.zip";
    public final static String phoneIntent = "com.mis478.popcornapp.phone";
    public final static String emailIntent = "com.mis478.popcornapp.email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_info);
        Intent intent = getIntent();
    }
    public void ToFinalize(View view)
    {
        //when the "Next" button is hit it creates an intent
        Intent finalize = new Intent(this, OrderFinalization.class);

        //finds the EditText boxes on the screen that contain the Customer's info
        EditText fName = (EditText) findViewById(R.id.FnameBox);
        EditText lName = (EditText) findViewById(R.id.LnameBox);
        EditText address = (EditText) findViewById(R.id.AddressBox);
        EditText city = (EditText) findViewById(R.id.CityBox);
        EditText state = (EditText) findViewById(R.id.StateBox);
        EditText zip = (EditText) findViewById(R.id.ZipBox);
        EditText phoneNumber = (EditText) findViewById(R.id.PnumberBox);
        EditText email = (EditText) findViewById(R.id.EmailBox);

        //parses the EditText into a string
        String fNameText = fName.getText().toString();
        String lNameText = lName.getText().toString();
        String addressText = address.getText().toString();
        String cityText = city.getText().toString();
        String stateText = state.getText().toString();
        String zipText = zip.getText().toString();
        String phoneNumberText = phoneNumber.getText().toString();
        String emailText = email.getText().toString();

        //Verifies the information is inputted correctly.  If not then it will throw an error message
        if (fNameText.isEmpty())
        {
            new AlertDialog.Builder(this)
                    .setTitle("Missing First Name")
                    .setMessage("A first name is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else if (lNameText.isEmpty())
        {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Last Name")
                    .setMessage("A last name is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else if (addressText.isEmpty())
        {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Address")
                    .setMessage("A delivery address is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else if (cityText.isEmpty())
        {
            new AlertDialog.Builder(this)
                    .setTitle("Missing City Name")
                    .setMessage("A city name is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else if (stateText.isEmpty())
        {
            new AlertDialog.Builder(this)
                    .setTitle("Missing State Name")
                    .setMessage("A state is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else if (zipText.isEmpty())
        {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Zip Code")
                    .setMessage("A zip code is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else if (phoneNumberText.isEmpty() && emailText.isEmpty())
        {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Phone Number or Email")
                    .setMessage("A phone number and/or email is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else {
            //attaches the customers info to the intent
            finalize.putExtra(fNameIntent, fNameText);
            finalize.putExtra(lNameIntent, lNameText);
            finalize.putExtra(addressIntent, addressText);
            finalize.putExtra(cityIntent, cityText);
            finalize.putExtra(stateIntent, stateText);
            finalize.putExtra(zipIntent, zipText);
            finalize.putExtra(phoneIntent, phoneNumberText);
            finalize.putExtra(emailIntent, emailText);

            //starts the next screen
            startActivity(finalize);
        }
    }
    public void ToProducts(View view)
    {
        Intent products = new Intent(this, OrderFinalization.class);
        startActivity(products);
    }
}

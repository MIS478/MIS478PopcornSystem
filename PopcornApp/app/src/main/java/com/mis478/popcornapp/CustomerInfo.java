package com.mis478.popcornapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class CustomerInfo extends ActionBarActivity implements AdapterView.OnItemSelectedListener {
    public final static String fNameIntent = "com.mis478.popcornapp.fname";
    public final static String lNameIntent = "com.mis478.popcornapp.lname";
    public final static String addressIntent = "com.mis478.popcornapp.address";
    public final static String cityIntent = "com.mis478.popcornapp.city";
    public final static String stateIntent = "com.mis478.popcornapp.state";
    public final static String zipIntent = "com.mis478.popcornapp.zip";
    public final static String phoneIntent = "com.mis478.popcornapp.phone";
    public final static String emailIntent = "com.mis478.popcornapp.email";
    Spinner StateSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_info);
        Intent intent = getIntent();
        setTitle("Customer Information");
        StateSpinner = (Spinner) findViewById(R.id.StateSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.state_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        StateSpinner.setAdapter(adapter);
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        StateSpinner.setOnItemSelectedListener(this);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void ToFinalize(View view) {
        //when the "Next" button is hit it creates an intent
        Intent finalize = new Intent(this, OrderFinalization.class);

        //finds the EditText boxes on the screen that contain the Customer's info
        EditText fName = (EditText) findViewById(R.id.FnameBox);
        EditText lName = (EditText) findViewById(R.id.LnameBox);
        EditText address = (EditText) findViewById(R.id.AddressBox);
        EditText city = (EditText) findViewById(R.id.CityBox);
        Spinner state = (Spinner) findViewById(R.id.StateSpinner);
        EditText zip = (EditText) findViewById(R.id.ZipBox);
        EditText phoneNumber = (EditText) findViewById(R.id.PnumberBox);
        EditText email = (EditText) findViewById(R.id.EmailBox);

        //parses the EditText into a string
        String fNameText = fName.getText().toString();
        String lNameText = lName.getText().toString();
        String addressText = address.getText().toString();
        String cityText = city.getText().toString();
        //String stateText = state.getSelectedItem().toString();
        String zipText = zip.getText().toString();
        String phoneNumberText = phoneNumber.getText().toString();
        String emailText = email.getText().toString();

        //Verifies the information is inputted correctly.  If not then it will throw an error message
        if (fNameText.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Missing First Name")
                    .setMessage("A first name is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else if (lNameText.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Last Name")
                    .setMessage("A last name is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else if (addressText.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Address")
                    .setMessage("A delivery address is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else if (cityText.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Missing City Name")
                    .setMessage("A city name is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
//        } else if (stateText.isEmpty()) {
//            new AlertDialog.Builder(this)
//                    .setTitle("Missing State Name")
//                    .setMessage("A state is required")
//                    .setIcon(android.R.drawable.ic_dialog_alert)
//                    .show();
        } else if (zipText.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Zip Code")
                    .setMessage("A zip code is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else if (phoneNumberText.isEmpty() && emailText.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Phone Number or Email")
                    .setMessage("A phone number and/or email is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else {
            //attaches the customers info to the intent
            finalize.putExtra(fNameIntent, fNameText);
            finalize.putExtra(lNameIntent, lNameText);
            finalize.putExtra(addressIntent, addressText);
            finalize.putExtra(cityIntent, cityText);
            //finalize.putExtra(stateIntent, stateText);
            finalize.putExtra(zipIntent, zipText);
            finalize.putExtra(phoneIntent, phoneNumberText);
            finalize.putExtra(emailIntent, emailText);

            //starts the next screen
            startActivity(finalize);
        }
    }

    public void ToProducts(View view) {
        Intent products = new Intent(this, SalesMode.class);
        startActivity(products);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_customer_info, menu);
        return true;
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

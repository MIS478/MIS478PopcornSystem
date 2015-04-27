package com.mis478.popcornapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;


public class CustomerInfo extends ActionBarActivity implements AdapterView.OnItemSelectedListener {
    Spinner StateSpinner;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_info);
        intent = getIntent();
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

    public void onItemSelected(AdapterView<?> parentView, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        ((TextView)parentView.getChildAt(0)).setTextColor(Color.WHITE);
    }

    public void onNothingSelected(AdapterView<?> parentView) {
        // Another interface callback
        ((TextView)parentView.getChildAt(0)).setTextColor(Color.WHITE);
    }

    public void ToFinalize(View view) {
        //when the "Next" button is hit it creates an intent
        Intent finalize = new Intent(this, OrderFinalization.class);
        Bundle OrderedProducts = intent.getExtras();
        Bundle Finalization = new Bundle();

        //finds the EditText boxes on the screen that contain the Customer's info
        EditText fName = (EditText) findViewById(R.id.FnameBox);
        EditText lName = (EditText) findViewById(R.id.LnameBox);
        EditText streetNumber = (EditText) findViewById(R.id.StreetNumberBox);
        EditText streetName = (EditText) findViewById(R.id.StreetNameBox);
        EditText city = (EditText) findViewById(R.id.CityBox);
        Spinner state = (Spinner) findViewById(R.id.StateSpinner);
        EditText zip = (EditText) findViewById(R.id.ZipBox);
        EditText phoneNumber = (EditText) findViewById(R.id.PnumberBox);
        EditText email = (EditText) findViewById(R.id.EmailBox);

        //parses the EditText into a string
        String fNameText = fName.getText().toString();
        String lNameText = lName.getText().toString();
        String streetNumberText = streetNumber.getText().toString();
        String streetNameText = streetName.getText().toString();
        String cityText = city.getText().toString();
        String stateText = state.getSelectedItem().toString();
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
        } else if (streetNumberText.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Address")
                    .setMessage("A delivery address is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else if (streetNameText.isEmpty()) {
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
        } else if (stateText.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Missing State Name")
                    .setMessage("A state is required")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
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
            Finalization.putString("FNAME", fNameText);
            Finalization.putString("LNAME", lNameText);
            Finalization.putString("STREETNUMBER", streetNumberText);
            Finalization.putString("STREETNAME", streetNameText);
            Finalization.putString("CITY", cityText);
            Finalization.putString("STATE", stateText);
            Finalization.putString("ZIP", zipText);
            Finalization.putString("PHONE", phoneNumberText);
            Finalization.putString("EMAIL", emailText);

            Finalization.putString("BUFFCHEDAMT", OrderedProducts.getString("BUFFCHEDAMT"));
            Finalization.putString("BUFFCHEDPRICE", OrderedProducts.getString("BUFFCHEDPRICE"));
            Finalization.putString("CARMCORNAMT", OrderedProducts.getString("CARMCORNAMT"));
            Finalization.putString("CARMCORNPRICE", OrderedProducts.getString("CARMCORNPRICE"));
            Finalization.putString("CHEESELOVEAMT", OrderedProducts.getString("CHEESELOVEAMT"));
            Finalization.putString("CHEESELOVEPRICE", OrderedProducts.getString("CHEESELOVEPRICE"));
            Finalization.putString("WHITEPRETZELAMT", OrderedProducts.getString("WHITEPRETZELAMT"));
            Finalization.putString("WHITEPRETZELPRICE", OrderedProducts.getString("WHITEPRETZELPRICE"));
            Finalization.putString("GOLDMILITARYAMT", OrderedProducts.getString("GOLDMILITARYAMT"));
            Finalization.putString("GOLDMILITARYPRICE", OrderedProducts.getString("GOLDMILITARYPRICE"));
            Finalization.putString("SILVERMILITARYAMT", OrderedProducts.getString("SILVERMILITARYAMT"));
            Finalization.putString("SILVERMILITARYPRICE", OrderedProducts.getString("SILVERMILITARYPRICE"));
            Finalization.putString("PAYMENTTYPE", OrderedProducts.getString("PAYMENTTYPE"));
            Finalization.putString("DONATIONAMT", OrderedProducts.getString("DONATIONAMT"));

            //starts the next screen
            finalize.putExtras(Finalization);
            startActivity(finalize);
        }
    }

    public void ToDonation (View view) {
        Intent donation = new Intent(this, Donation.class);
        startActivity(donation);
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
            Intent intent = new Intent(this, SellProducts.class);
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

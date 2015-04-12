package com.mis478.popcornapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class CustomerInfo extends ActionBarActivity {
    public final static String test = "com.mis478.popcornapp.test";
    public final static String test2 = "com.mis478.popcornapp.test2";

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

        //attaches the customers info to the intent
        finalize.putExtra(test, fNameText);
        finalize.putExtra(test2, lNameText);

        //starts the next screen
        startActivity(finalize);
    }
    public void ToProducts(View view)
    {
        Intent products = new Intent(this, OrderFinalization.class);
        startActivity(products);
    }


    @Override
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

        return super.onOptionsItemSelected(item);
    }
}

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
    public final static String test2 = "com.mis478.popcornapp.test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_info);
        Intent intent = getIntent();
    }
    public void ToFinalize(View view)
    {
        Intent finalize = new Intent(this, OrderFinalization.class);
        EditText fName = (EditText) findViewById(R.id.FnameBox);
        EditText lName = (EditText) findViewById(R.id.LnameBox);
        EditText address = (EditText) findViewById(R.id.AddressBox);
        EditText city = (EditText) findViewById(R.id.CityBox);
        EditText state = (EditText) findViewById(R.id.StateBox);
        EditText zip = (EditText) findViewById(R.id.ZipBox);
        EditText phoneNumber = (EditText) findViewById(R.id.PnumberBox);
        EditText email = (EditText) findViewById(R.id.EmailBox);
        String fNameText = fName.getText().toString();
        String lNameText = lName.getText().toString();
        String addressText = address.getText().toString();
        String cityText = city.getText().toString();
        String stateText = state.getText().toString();
        String zipText = zip.getText().toString();
        String phoneNumberText = phoneNumber.getText().toString();
        String emailText = email.getText().toString();
        finalize.putExtra(test, fNameText);
        finalize.putExtra(test2, lNameText);
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

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
    }

    public void Sales(View view) {
        Intent intent = new Intent(this, SellProducts.class);
        startActivity(intent);
    }

    public void CustInfo(View view) {
        Intent intent = new Intent(this, CustomerInfo.class);
        startActivity(intent);
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
        if (id == R.id.SalesModeBtn) {
            Intent intent = new Intent(this, SellProducts.class);
            startActivity(intent);
        }
        if (id == R.id.CustomerInfo) {
            Intent intent = new Intent(this, CustomerInfo.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }
}
package com.mis478.popcornapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Donation extends ActionBarActivity {


    //declaring local variables
    public RadioGroup radioGroup;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        //Get info from the previous screen
        intent = getIntent();
    }

    public void Sales(View view) {
        Intent intent = new Intent(this, SellProducts.class);
        startActivity(intent);
    }

    public void CustInfo(View view) {
        //creates a new intent, pulls the information from the last screen and rebundles it into the new intent
        Intent CustInfo = new Intent(this, CustomerInfo.class);
        Bundle OrderedProducts = intent.getExtras();
        Bundle CustInfoBundle = new Bundle();
        CustInfoBundle.putString("BUFFCHEDAMT", OrderedProducts.getString("BUFFCHEDAMT"));
        CustInfoBundle.putString("BUFFCHEDPRICE", OrderedProducts.getString("BUFFCHEDPRICE"));
        CustInfoBundle.putString("CARMCORNAMT", OrderedProducts.getString("CARMCORNAMT"));
        CustInfoBundle.putString("CARMCORNPRICE", OrderedProducts.getString("CARMCORNPRICE"));
        CustInfoBundle.putString("CHEESELOVEAMT", OrderedProducts.getString("CHEESELOVEAMT"));
        CustInfoBundle.putString("CHEESELOVEPRICE", OrderedProducts.getString("CHEESELOVEPRICE"));
        CustInfoBundle.putString("WHITEPRETZELAMT", OrderedProducts.getString("WHITEPRETZELAMT"));
        CustInfoBundle.putString("WHITEPRETZELPRICE", OrderedProducts.getString("WHITEPRETZELPRICE"));
        CustInfoBundle.putString("GOLDMILITARYAMT", OrderedProducts.getString("GOLDMILITARYAMT"));
        CustInfoBundle.putString("GOLDMILITARYPRICE", OrderedProducts.getString("GOLDMILITARYPRICE"));
        CustInfoBundle.putString("SILVERMILITARYAMT", OrderedProducts.getString("SILVERMILITARYAMT"));
        CustInfoBundle.putString("SILVERMILITARYPRICE", OrderedProducts.getString("SILVERMILITARYPRICE"));

        //finds the objects on the screen
        RadioButton check = (RadioButton) findViewById(R.id.radioButtonCheck);
        RadioButton cash = (RadioButton) findViewById(R.id.radioButtonCash);
        RadioButton credit = (RadioButton) findViewById(R.id.radioButtonCredit);
        EditText DonationAmt = (EditText) findViewById(R.id.DonationAmount);
        String DonationAmtText = DonationAmt.getText().toString();

        //attaches the radio button that was selected or throws an error if there was no method selected
        if (check.isChecked()) {
            CustInfoBundle.putString("PAYMENTTYPE", "check");
        } else if (cash.isChecked()) {
            CustInfoBundle.putString("PAYMENTTYPE", "cash");
        } else if (credit.isChecked()) {
            CustInfoBundle.putString("PAYMENTTYPE", "credit");
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Payment Method")
                    .setMessage("Please select a payment method")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }

        //attaches the donation amount to the bundle
        if (DonationAmtText.isEmpty() || DonationAmtText.equals("0")) {
            CustInfoBundle.putString("DONATIONAMT", "0");
        } else {
            CustInfoBundle.putString("DONATIONAMT", DonationAmtText);
        }


        //attaches the bundle to the intent and starts the next screen
        CustInfo.putExtras(CustInfoBundle);
        startActivity(CustInfo);
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
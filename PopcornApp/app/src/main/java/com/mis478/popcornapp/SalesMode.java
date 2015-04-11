package com.mis478.popcornapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SalesMode extends ActionBarActivity {
    Integer one = 0;
    Integer two = 0;
    Integer three = 0;
    Integer four = 0;
    Integer tot = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_mode);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, Donation.class);
        startActivity(intent);
    }

    public void Total(View view) {
        //calculate total
        new AlertDialog.Builder(this)
                .setTitle("Your total so far is")
                .setMessage("$" + tot.toString())
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void CustInfo(View view) {
        //to cust info

        Intent intent = new Intent(this, CustomerInfo.class);
        startActivity(intent);
    }

    public void one(View view) {
        one++;
        TextView t = (TextView) findViewById(R.id.lbl1);
        t.setText(one.toString());
        tot = tot + 5;
    }

    public void two(View view) {
        two++;
        TextView r = (TextView) findViewById(R.id.lbl2);
        r.setText(two.toString());
        tot = tot + 5;
    }

    public void three(View view) {
        three++;
        TextView t = (TextView) findViewById(R.id.lbl3);
        t.setText(three.toString());
        tot = tot + 5;
    }

    public void four(View view) {
        four++;
        TextView t = (TextView) findViewById(R.id.lbl4);
        t.setText(four.toString());
        tot = tot + 5;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sales_mode, menu);
        return true;
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
        if (id == R.id.BackBtn) {
            Intent intent = new Intent(this, ScoutMainPage.class);
            startActivity(intent);
        }
        if (id == R.id.DonateBtn) {
            Intent intent = new Intent(this, Donation.class);
            startActivity(intent);
        }
        if (id == R.id.TotalBtn) {
            Intent intent = new Intent(this, OrderFinalization.class);
            startActivity(intent);
        }
        //Put Next Page Here
        if (id == R.id.TotalBtn) {
            Intent intent = new Intent(this, Donation.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
        }
}
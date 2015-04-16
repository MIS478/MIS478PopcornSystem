package com.mis478.popcornapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SalesMode extends ActionBarActivity {
    Integer one = 0;
    Integer two = 0;
    Integer three = 0;
    Integer four = 0;
    Integer five = 0;
    Integer six = 0;
    Integer tot = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_mode);
        setTitle("Sales Mode");
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
    public void five(View view) {
        five++;
        TextView t = (TextView) findViewById(R.id.lbl5);
        t.setText(four.toString());
        tot = tot + 5;
    }
    public void six(View view) {
        six++;
        TextView t = (TextView) findViewById(R.id.lbl6);
        t.setText(four.toString());
        tot = tot + 5;
    }
    public void neg1(View view) {
        one--;
        TextView t = (TextView) findViewById(R.id.lbl1);
        t.setText(one.toString());
        tot = tot - 5;
    }
    public void neg2(View view) {
        two--;
        TextView t = (TextView) findViewById(R.id.lbl2);
        t.setText(two.toString());
        tot = tot - 5;
    }
    public void neg3(View view) {
        three--;
        TextView t = (TextView) findViewById(R.id.lbl3);
        t.setText(three.toString());
        tot = tot - 5;
    }
    public void neg4(View view) {
        four--;
        TextView t = (TextView) findViewById(R.id.lbl4);
        t.setText(four.toString());
        tot = tot - 5;
    }
    public void neg5(View view) {
        five--;
        TextView t = (TextView) findViewById(R.id.lbl5);
        t.setText(five.toString());
        tot = tot - 5;
    }
    public void neg6(View view) {
        six--;
        TextView t = (TextView) findViewById(R.id.lbl6);
        t.setText(six.toString());
        tot = tot - 5;
    }
    public void Back(View view) {
        Intent intent = new Intent(this, ScoutMainPage.class);
        startActivity(intent);
    }
    public void PageBack(View view) {
        Intent intent = new Intent(this, SalesPage2.class);
        startActivity(intent);
    }
    public void PageForward(View view) {
        Intent intent = new Intent(this, SalesPage2.class);
        startActivity(intent);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scout_status_page, menu);
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
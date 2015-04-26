package com.mis478.popcornapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ScoutMainPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_main_page);
        setTitle("Welcome, Scout");
        //Get info from the previous screen
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
           String test = extras.getString("string");
           String value = extras.getString("name");
           String[] alldata = extras.getStringArray("all");
        }
    }

    public void Sales(View view) {
        Intent back = new Intent(this, SellProducts.class);
        startActivity(back);
    }
    public void Donation(View view) {

        Intent donate = new Intent(this, Donation.class);
        startActivity(donate);
    }
    public void Delivery(View view) {
        Intent x = new Intent(this, DeliveryMode.class);
        startActivity(x);
    }
    public void Status(View view) {
        Intent x = new Intent(this, ScoutStatusPage.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String test = extras.getString("string");
            String value = extras.getString("name");
            String[] alldata = extras.getStringArray("all");
            x.putExtra("name", value);
            x.putExtra("all", alldata);
            x.putExtra("string",test);
        }

        startActivity(x);
    }
    public void Log(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    public void Past(View view) {
        Intent x = new Intent(this, PastSales.class);
        startActivity(x);
    }
    public void View(View view) {

     //    Intent x = new Intent(this, ViewProducts.class);
     //   startActivity(x);
    }
    public void Goal(View view) {
        Intent x = new Intent(this, ScoutGoal.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String test = extras.getString("string");
            String value = extras.getString("name");
            String[] alldata = extras.getStringArray("all");
            x.putExtra("name", value);
            x.putExtra("all", alldata);
            x.putExtra("string",test);
        }
        startActivity(x);
    }
    @Override
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

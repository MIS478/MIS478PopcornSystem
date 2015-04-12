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

        //Get info from the previous screen
        Intent intent = getIntent();
    }

    public void Sales(View view) {
        Intent back = new Intent(this, SalesMode.class);
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
        startActivity(x);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scout_main_page, menu);
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

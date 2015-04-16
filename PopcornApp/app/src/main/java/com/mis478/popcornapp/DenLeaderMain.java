package com.mis478.popcornapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Lloyd on 3/29/2015.
 */

public class DenLeaderMain extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denleadermain);
        setTitle("Welcome, Den Leader");

        //Get info from the previous screen
        Intent intent = getIntent();
    }

    public void toScouts (View view)
    {
        Intent toScouts = new Intent(this, ViewScouts.class);
        startActivity(toScouts);
    }
    public void toSalesTracking (View view)
    {
        Intent toSalesTracking = new Intent(this, DenSalesTracking.class);
        startActivity(toSalesTracking);
    }
    public void toProducts (View view)
    {
        Intent toProducts = new Intent(this, SalesMode.class);
        startActivity(toProducts);
    }
    public void toAdminButton (View view)
    {
        Intent toAdminButton = new Intent(this, AdminFunctions.class);
        startActivity(toAdminButton);
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
//        if (id == R.id.button2) {
//            Intent intent = new Intent(this, DenSalesTracking.class);
//            startActivity(intent);
//        }
//        if (id == R.id.button3) {
//            Intent intent = new Intent(this, ScoutGoal.class);
//            startActivity(intent);
//        }
        return super.onOptionsItemSelected(item);
    }
}
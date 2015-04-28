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
        Intent toSalesTracking = new Intent(this, PastSales.class);
        startActivity(toSalesTracking);
    }
    public void toProducts (View view)
    {
        Intent toDenProducts = new Intent(this, DenSalesItems.class);
        startActivity(toDenProducts);
    }
    public void toAddScouts (View view)
    {
        Intent toAddScouts = new Intent(this, AddScout.class);
        startActivity(toAddScouts);
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
        if (id == R.id.densalestracking) {
            Intent intent = new Intent(this, PastSales.class);
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
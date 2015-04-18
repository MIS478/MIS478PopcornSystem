package com.mis478.popcornapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class AdminFunctions extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_functions);
    }
    public void toAddScouts (View view)
    {
        Intent toAddScouts = new Intent(this, AddScout.class);
        startActivity(toAddScouts);
    }
    public void toEndSale (View view)
    {
        Intent toEndSale = new Intent(this, AdminFunctions.class);
        startActivity(toEndSale);
    }
    public void toAddProducts (View view)
    {
        Intent toAddProducts = new Intent(this, AddProduct.class);
        startActivity(toAddProducts);
    }
    public void toDenGoal (View view)
    {
        Intent toDenGoal = new Intent(this, DenGoal.class);
        startActivity(toDenGoal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_admin_functions, menu);
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

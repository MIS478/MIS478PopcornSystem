package com.mis478.popcornapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class DenSalesItems extends ActionBarActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.den_sales_page);
        //Get info from the previous screen
        Intent intent = getIntent();
    }

    public void DenMain(View view) {
        Intent intent = new Intent(this, DenLeaderMain.class);
        startActivity(intent);
    }


    public void BuffChedDesc(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Buffalo Cheddar Cheese Corn")
                .setMessage("Spicy buffalo flavors unite with our traditional cheddar cheese popcorn to ignite your taste buds!")
                .show();
    }

    public void CarmCornDesc(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Caramel Corn with Almonds, Cashews & Pecans")
                .setMessage("Sweet caramel corn with crunchy almonds, cashews and pecans!")
                .show();
    }

    public void CheeseLoveDesc(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Cheese Lover's Collection")
                .setMessage("The perfect collection of Cheddar Cheese, White Cheddar Cheese and Buffalo Cheddar Cheese all in one box.")
                .show();
    }

    public void WhitePretzelDesc(View view) {
        new AlertDialog.Builder(this)
                .setTitle("White Chocolatey Pretzels")
                .setMessage("The perfect blend of crispy pretzels wrapped in creamy white chocolatey goodness.")
                .show();
    }

    public void GoldMilitaryDesc(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Gold Level Military")
                .setMessage("Send a gift of popcorn to our military men and women, their families, and veterans' organizations. Over $38 returned to local Scouting!")
                .show();
    }

    public void SilverMilitaryDesc(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Silver Level Military")
                .setMessage("Send a gift of popcorn to our military men and women, their families, and veterans' organizations. Over $24 returned to local Scouting!")
                .show();
    }


    public void Back(View view) {
        Intent intent = new Intent(this, DenLeaderMain.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_den_sales_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.DenLeaderMainMenu) {
            Intent intent = new Intent(this, DenLeaderMain.class);
            startActivity(intent);
        }
        if (id == R.id.AddScoutMenu) {
            Intent intent = new Intent(this, AddScout.class);
            startActivity(intent);
        }
        if (id == R.id.DenSalesTrackingMenu) {
            Intent intent = new Intent(this, PastSales.class);
            startActivity(intent);
        }
        if (id == R.id.ViewProductsMenu) {
            Intent intent = new Intent(this, DenSalesItems.class);
            startActivity(intent);
        }
        if (id == R.id.ViewScoutsMenu) {
            Intent intent = new Intent(this, ViewScouts.class);
            startActivity(intent);
        }
        if (id == R.id.LogoutMenu) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.mis478.popcornapp;

/**
 * Created by Lloyd on 4/26/2015.
 */
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class DenSalesItems extends ActionBarActivity {


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
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
            Intent intent = new Intent(this, SellProducts.class);
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

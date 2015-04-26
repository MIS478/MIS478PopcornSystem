package com.mis478.popcornapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class SellProducts extends ActionBarActivity {
    //initializes the variables for the cost of the products
    Integer BuffChedCost;
    Integer CarmCornCost;
    Integer CheeseLoveCost;
    Integer WhitePretzelCost;
    Integer GoldMilitaryCost;
    Integer SilverMilitaryCost;
    Integer Total;

    //initializes the variables to 0 for the amount of products to order
    Integer BuffChedAmt = 0;
    Integer CarmCornAmt = 0;
    Integer CheeseLoveAmt = 0;
    Integer WhitePretzelAmt = 0;
    Integer GoldMilitaryAmt = 0;
    Integer SilverMilitaryAmt = 0;

    //initializes the TextView boxes from the layout screen
    TextView BuffChedAmtBox;
    TextView CarmCornAmtBox;
    TextView CheeseLoveAmtBox;
    TextView WhitePretzelAmtBox;
    TextView GoldMilitaryAmtBox;
    TextView SilverMilitaryAmtBox;
    TextView TotalBox;

    //makes the Intent
    Intent OrderedProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_products);

        //set the cost of all the products.  This could be done by finding the TextView and doing a toString
        BuffChedCost = 20;
        CarmCornCost = 25;
        CheeseLoveCost = 45;
        WhitePretzelCost = 30;
        GoldMilitaryCost = 55;
        SilverMilitaryCost = 35;

        //Set the quantity of products to 0
        BuffChedAmtBox = (TextView) findViewById(R.id.BuffChedAmt);
        BuffChedAmtBox.setText(BuffChedAmt.toString());

        CarmCornAmtBox = (TextView) findViewById(R.id.CarmCornAmt);
        CarmCornAmtBox.setText(CarmCornAmt.toString());

        CheeseLoveAmtBox = (TextView) findViewById(R.id.CheeseLoveAmt);
        CheeseLoveAmtBox.setText(CheeseLoveAmt.toString());

        WhitePretzelAmtBox = (TextView) findViewById(R.id.WhitePretzelAmt);
        WhitePretzelAmtBox.setText(WhitePretzelAmt.toString());

        GoldMilitaryAmtBox = (TextView) findViewById(R.id.GoldMilitaryAmt);
        GoldMilitaryAmtBox.setText(GoldMilitaryAmt.toString());

        SilverMilitaryAmtBox = (TextView) findViewById(R.id.SilverMilitaryAmt);
        SilverMilitaryAmtBox.setText(SilverMilitaryAmt.toString());

        TotalBox = (TextView) findViewById(R.id.TotalAmt);
        TotalBox.setText("$0");
    }

    public void ComputeTotal() {
        Total = (BuffChedAmt * BuffChedCost) + (CarmCornAmt * CarmCornCost) + (CheeseLoveAmt * CheeseLoveCost) + (WhitePretzelAmt * WhitePretzelCost) + (GoldMilitaryAmt * GoldMilitaryCost) + (SilverMilitaryAmt * SilverMilitaryCost);
        TotalBox.setText("$" + Total.toString());
    }

    public void BuffChedDesc(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Buffalo Cheddar Cheese Corn")
                .setMessage("Spicy buffalo flavors unite with our traditional cheddar cheese popcorn to ignite your taste buds!")
                .show();
    }

    public void BuffChedUp(View view) {
        BuffChedAmt++;
        BuffChedAmtBox.setText(BuffChedAmt.toString());
        ComputeTotal();
    }

    public void BuffChedDown(View view) {
        if (BuffChedAmt == 0) {
        } else {
            BuffChedAmt--;
            BuffChedAmtBox.setText(BuffChedAmt.toString());
            ComputeTotal();
        }

    }

    public void CarmCornDesc(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Caramel Corn with Almonds, Cashews & Pecans")
                .setMessage("Sweet caramel corn with crunchy almonds, cashews and pecans!")
                .show();
    }

    public void CarmCornUp(View view) {
        CarmCornAmt++;
        CarmCornAmtBox.setText(CarmCornAmt.toString());
        ComputeTotal();
    }

    public void CarmCornDown(View view) {
        if (CarmCornAmt == 0) {
        } else {
            CarmCornAmt--;
            CarmCornAmtBox.setText(CarmCornAmt.toString());
            ComputeTotal();
        }

    }

    public void CheeseLoveDesc(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Cheese Lover's Collection")
                .setMessage("The perfect collection of Cheddar Cheese, White Cheddar Cheese and Buffalo Cheddar Cheese all in one box.")
                .show();
    }

    public void CheeseLoveUp(View view) {
        CheeseLoveAmt++;
        CheeseLoveAmtBox.setText(CheeseLoveAmt.toString());
        ComputeTotal();
    }

    public void CheeseLoveDown(View view) {
        if (CheeseLoveAmt == 0) {
        } else {
            CheeseLoveAmt--;
            CheeseLoveAmtBox.setText(CheeseLoveAmt.toString());
            ComputeTotal();
        }

    }

    public void WhitePretzelDesc(View view) {
        new AlertDialog.Builder(this)
                .setTitle("White Chocolatey Pretzels")
                .setMessage("The perfect blend of crispy pretzels wrapped in creamy white chocolatey goodness.")
                .show();
    }

    public void WhitePretzelUp(View view) {
        WhitePretzelAmt++;
        WhitePretzelAmtBox.setText(WhitePretzelAmt.toString());
        ComputeTotal();
    }

    public void WhitePretzelDown(View view) {
        if (WhitePretzelAmt == 0) {
        } else {
            WhitePretzelAmt--;
            WhitePretzelAmtBox.setText(WhitePretzelAmt.toString());
            ComputeTotal();
        }

    }

    public void GoldMilitaryDesc(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Gold Level Military")
                .setMessage("Send a gift of popcorn to our military men and women, their families, and veterans' organizations. Over $38 returned to local Scouting!")
                .show();
    }

    public void GoldMilitaryUp(View view) {
        GoldMilitaryAmt++;
        GoldMilitaryAmtBox.setText(GoldMilitaryAmt.toString());
        ComputeTotal();
    }

    public void GoldMilitaryDown(View view) {
        if (GoldMilitaryAmt == 0) {
        } else {
            GoldMilitaryAmt--;
            GoldMilitaryAmtBox.setText(GoldMilitaryAmt.toString());
            ComputeTotal();
        }

    }

    public void SilverMilitaryDesc(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Silver Level Military")
                .setMessage("Send a gift of popcorn to our military men and women, their families, and veterans' organizations. Over $24 returned to local Scouting!")
                .show();
    }

    public void SilverMilitaryUp(View view) {
        SilverMilitaryAmt++;
        SilverMilitaryAmtBox.setText(SilverMilitaryAmt.toString());
        ComputeTotal();
    }

    public void SilverMilitaryDown(View view) {
        if (SilverMilitaryAmt == 0) {
        } else {
            SilverMilitaryAmt--;
            SilverMilitaryAmtBox.setText(SilverMilitaryAmt.toString());
            ComputeTotal();
        }

    }

    public void Donate(View view) {
        //bundles the ordered products into an intent and then goes to the donation screen
        OrderedProducts = new Intent(this, Donation.class);
        BundleIntent();
        startActivity(OrderedProducts);
    }

//not used at the moment
    public void CustInfo(View view) {
        //bundles the ordered products into an intent and then goes to the customer screen
        OrderedProducts = new Intent(this, CustomerInfo.class);
        BundleIntent();
        startActivity(OrderedProducts);
    }

    public void Back(View view) {
        Intent intent = new Intent(this, ScoutMainPage.class);
        startActivity(intent);
    }

    public void BundleIntent() {
        Bundle Products = new Bundle();
        Products.putString("BUFFCHEDAMT", BuffChedAmt.toString());
        Products.putString("BUFFCHEDPRICE", BuffChedCost.toString());
        Products.putString("CARMCORNAMT", CarmCornAmt.toString());
        Products.putString("CARMCORNPRICE", CarmCornCost.toString());
        Products.putString("CHEESELOVEAMT", CheeseLoveAmt.toString());
        Products.putString("CHEESELOVEPRICE", CheeseLoveCost.toString());
        Products.putString("WHITEPRETZELAMT", WhitePretzelAmt.toString());
        Products.putString("WHITEPRETZELPRICE", WhitePretzelCost.toString());
        Products.putString("GOLDMILITARYAMT", GoldMilitaryAmt.toString());
        Products.putString("GOLDMILITARYPRICE", GoldMilitaryCost.toString());
        Products.putString("SILVERMILITARYAMT", SilverMilitaryAmt.toString());
        Products.putString("SILVERMILITARYPRICE", SilverMilitaryCost.toString());
        OrderedProducts.putExtras(Products);
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

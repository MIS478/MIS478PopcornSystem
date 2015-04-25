package com.mis478.popcornapp;

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
    Integer BuffChedQuantity = 0;
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
       // BuffChedAmtBox.setText(BuffChedQuantity);

        CarmCornAmtBox = (TextView) findViewById(R.id.CarmCornAmt);
        //CarmCornAmtBox.setText(CarmCornAmt);

        CheeseLoveAmtBox = (TextView) findViewById(R.id.CheeseLoveAmt);
        //CheeseLoveAmtBox.setText(CheeseLoveAmt);

        WhitePretzelAmtBox = (TextView) findViewById(R.id.WhitePretzelAmt);
       // WhitePretzelAmtBox.setText(WhitePretzelAmt);

        GoldMilitaryAmtBox = (TextView) findViewById(R.id.GoldMilitaryAmt);
       // GoldMilitaryAmtBox.setText(GoldMilitaryAmt);

        SilverMilitaryAmtBox = (TextView) findViewById(R.id.SilverMilitaryAmt);
       // SilverMilitaryAmtBox.setText(SilverMilitaryAmt);

        TotalBox = (TextView) findViewById(R.id.TotalAmt);
        //TotalBox.setText("$0");
    }

    public void ComputeTotal() {
        Total = (BuffChedQuantity * BuffChedCost) + (CarmCornAmt * CarmCornCost) + (CheeseLoveAmt * CheeseLoveCost) + (WhitePretzelAmt * WhitePretzelCost) + (GoldMilitaryAmt * GoldMilitaryCost) + (SilverMilitaryAmt * SilverMilitaryCost);
        TotalBox.setText("$" + Total);
    }

    public void BuffChedUp(View view) {
        BuffChedQuantity++;
        BuffChedAmtBox.setText(BuffChedQuantity);
        ComputeTotal();
    }

    public void BuffChedDown(View view) {
        if (BuffChedQuantity == 0) {
        } else {
            BuffChedQuantity--;
            BuffChedAmtBox.setText(BuffChedQuantity);
            ComputeTotal();
        }

    }
    public void CarmCornUp(View view) {
        CarmCornAmt++;
        CarmCornAmtBox.setText(CarmCornAmt);
        ComputeTotal();
    }

    public void CarmCornDown(View view) {
        if (CarmCornAmt == 0) {
        } else {
            CarmCornAmt--;
            CarmCornAmtBox.setText(CarmCornAmt);
            ComputeTotal();
        }

    }
    public void CheeseLoveUp(View view) {
        CheeseLoveAmt++;
        CheeseLoveAmtBox.setText(CheeseLoveAmt);
        ComputeTotal();
    }

    public void CheeseLoveDown(View view) {
        if (CheeseLoveAmt == 0) {
        } else {
            CheeseLoveAmt--;
            CheeseLoveAmtBox.setText(CheeseLoveAmt);
            ComputeTotal();
        }

    }
    public void WhitePretzelUp(View view) {
        WhitePretzelAmt++;
        WhitePretzelAmtBox.setText(WhitePretzelAmt);
        ComputeTotal();
    }

    public void WhitePretzelDown(View view) {
        if (WhitePretzelAmt == 0) {
        } else {
            WhitePretzelAmt--;
            WhitePretzelAmtBox.setText(WhitePretzelAmt);
            ComputeTotal();
        }

    }
    public void GoldMilitaryUp(View view) {
        GoldMilitaryAmt++;
        GoldMilitaryAmtBox.setText(GoldMilitaryAmt);
        ComputeTotal();
    }

    public void GoldMilitaryDown(View view) {
        if (GoldMilitaryAmt == 0) {
        } else {
            GoldMilitaryAmt--;
            GoldMilitaryAmtBox.setText(GoldMilitaryAmt);
            ComputeTotal();
        }

    }
    public void SilverMilitaryUp(View view) {
        SilverMilitaryAmt++;
        SilverMilitaryAmtBox.setText(SilverMilitaryAmt);
        ComputeTotal();
    }

    public void SilverMilitaryDown(View view) {
        if (SilverMilitaryAmt == 0) {
        } else {
            SilverMilitaryAmt--;
            SilverMilitaryAmtBox.setText(SilverMilitaryAmt);
            ComputeTotal();
        }

    }
    public void Donate(View view) {
        Intent intent = new Intent(this, Donation.class);
        startActivity(intent);
    }
    public void CustInfo(View view) {
        //to cust info

        Intent intent = new Intent(this, CustomerInfo.class);
        startActivity(intent);
    }
    public void Back(View view) {
        Intent intent = new Intent(this, ScoutMainPage.class);
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

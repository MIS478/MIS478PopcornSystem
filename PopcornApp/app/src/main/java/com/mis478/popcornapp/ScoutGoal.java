package com.mis478.popcornapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;


public class ScoutGoal extends ActionBarActivity {
    int PersonalGoalInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_goal);
        setTitle("Your Goals");
        //Get info from the previous screen
      //  Intent intent = getIntent();
        //db world
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String test = extras.getString("string");
            String[] SplitByComma = test.split(",");
            String[] personal = SplitByComma[9].split(":");
            String temp = personal[1];
            temp = temp.substring(1,temp.length() -1);

            String value = extras.getString("name");

            String[] alldata = extras.getStringArray("all");

            //find the Scout's personal goal amount
            TextView textView = (TextView) findViewById(R.id.PersonalAmt);
            PersonalGoalInt = Integer.parseInt(temp);
            textView.setText("$" + PersonalGoalInt);

            //find the total amount of goods sold
            TextView textView2 = (TextView) findViewById(R.id.TotalSoldAmt);
            String[] TotalSales = SplitByComma[8].split(":");
            String temp2 = TotalSales[1];
            temp2 = temp2.substring(1,temp2.length() -1);
            textView2.setText("$" + temp2);

            //pack goal
            TextView textView3 = (TextView) findViewById(R.id.PackAmt);
            String[] pack = SplitByComma[10].split(":");
            String temp3 = pack[1];
            temp3 = temp3.substring(1,temp3.length() -1);
            textView3.setText("$" + temp3);

            int hold = Integer.parseInt(temp2);
            //find the progress bar and then set the progress amount
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.SaleProgressBar);
            progressBar.setMax(PersonalGoalInt);
            progressBar.setProgress(hold);

        }
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

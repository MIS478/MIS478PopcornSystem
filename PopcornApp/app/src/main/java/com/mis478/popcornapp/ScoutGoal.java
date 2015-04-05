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

        //Get info from the previous screen
        Intent intent = getIntent();

        //find the Scout's personal goal amount
        TextView textView = (TextView) findViewById(R.id.PersonalAmt);
        String message = textView.getText().toString();
        PersonalGoalInt=Integer.parseInt(message.replaceAll("[\\D]", ""));

        //find the total amount of goods sold
        TextView textView2 = (TextView) findViewById(R.id.TotalSoldAmt);
        String message2 = textView2.getText().toString();
        int i=Integer.parseInt(message2.replaceAll("[\\D]", ""));

        //find the progress bar and then set the progress amount
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.SaleProgressBar);
        progressBar.setMax(PersonalGoalInt);
        progressBar.setProgress(i);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scout_goal, menu);
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

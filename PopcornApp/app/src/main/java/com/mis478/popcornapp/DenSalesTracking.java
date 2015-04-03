package com.mis478.popcornapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

/**
 * Created by Lloyd on 3/29/2015.
 */
public class DenSalesTracking extends ActionBarActivity

{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.den_sales_tracking);

        //Get info from the previous screen
        Intent intent = getIntent();
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
        if (id == R.id.button4) {
            Intent intent = new Intent(this, DenLeaderMain.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}

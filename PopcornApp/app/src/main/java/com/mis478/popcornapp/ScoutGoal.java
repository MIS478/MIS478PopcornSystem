package com.mis478.popcornapp;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ScoutGoal extends ActionBarActivity {
    int PersonalGoalInt;
    public static final String url_create_product = "http://207.179.202.218:1515/joe/updategoal.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_goal);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
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

    public void magic(View view) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            EditText amt = (EditText) findViewById(R.id.SetGoalEditText);
            String amtholder = amt.getText().toString();
            String test = extras.getString("string");
            String value = extras.getString("name");
            String[] SplitByComma = test.split(",");

            String[] pass = SplitByComma[7].split(":");
            String temp = pass[1];
            temp = temp.substring(1,temp.length() -1);
            JSONParser jsonParser = new JSONParser();

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("a", value));
            params.add(new BasicNameValuePair("b", amtholder));
            params.add(new BasicNameValuePair("c", temp));

            JSONObject json = jsonParser.makeHttpRequest(url_create_product,
                    "POST", params);
            Log.d("Create Response", json.toString());

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
        if (id == R.id.ScoutMainMenu) {
            Intent intent = new Intent(this, ScoutMainPage.class);
            startActivity(intent);
        }
        if (id == R.id.SaleModeMenu) {
            Intent intent = new Intent(this, SellProducts.class);
            startActivity(intent);
        }
        if (id == R.id.ScoutGoalMenu) {
            Intent intent = new Intent(this, ScoutGoal.class);
            startActivity(intent);
        }
        if (id == R.id.DeliveryModeMenu) {
            Intent intent = new Intent(this, DeliveryMode.class);
            startActivity(intent);
        }

        if (id == R.id.PastSalesMenu) {
            Intent intent = new Intent(this, PastSales.class);
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

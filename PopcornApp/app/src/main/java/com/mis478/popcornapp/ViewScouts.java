package com.mis478.popcornapp;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Lloyd on 3/29/2015.
 */
public class ViewScouts extends ListActivity {
    public static final String KEY_121 = "http://207.179.202.218:1515/joe/1.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        InputStream is = null;
        StrictMode.setThreadPolicy(policy);
        setTitle("List of Scouts");

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("year", "420"));


        //http post
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(KEY_121);
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();


        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }
        //convert response to string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            line = reader.readLine();

            line.toString();
            String[] splitArray = line.split("\\}");
            String[] temp;
            //load into temp array
            String[] holder = new String[10];
            int delim = 1;
            String ts;
            for (int i = 0; i < splitArray.length - 1; i++) {
                temp = splitArray[i].split(",");
                temp = temp[delim].split(":");
                delim = 2;
                ts = temp[1];
                ts = ts.substring(1, ts.length() - 1);
                holder[i] = ts;
            }
            splitArray[10] = "";


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    R.layout.activity_delivery_mode, R.id.label, holder);
            setListAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
            //Get info from the previous screen
            Bundle extras = getIntent().getExtras();
            if (extras != null) {

                String value = extras.getString("name");


                String[] alldata = extras.getStringArray("all");


                String test = extras.getString("string");

                // use your custom layout
                //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                //         R.layout.activity_delivery_mode, R.id.label, values);
                //   setListAdapter(adapter);
            }
        }

    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("year", "420"));

        InputStream is = null;
        //http post
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(KEY_121);
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();


        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }
        //convert response to string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            line = reader.readLine();

            line.toString();
            String[] splitArray = line.split("\\}");
            int delim = 2;
            if (position == 0) {
                delim = 1;
            }

            String[] SplitByComma = splitArray[position].split(",");


            String name, phone, email, salesgoal, total, paid, delivered;

            String[] namea, phonea, emaila, salesgoala, totala, paida, delivereda;

            namea = SplitByComma[delim].split(":");
            name = namea[1];
            name = name.substring(1, name.length() - 1);
            delim++;
            delim++;
            delim++;

            salesgoala = SplitByComma[delim].split(":");
            salesgoal = salesgoala[1];
            salesgoal = salesgoal.substring(1, salesgoal.length() - 1);
            delim++;
            delim++;
            delim++;
            delim++;

            totala = SplitByComma[delim].split(":");
            total = totala[1];
            total = total.substring(1, total.length() - 1);


            new AlertDialog.Builder(this)
                    .setTitle("Scout Information")
                    .setMessage("Username: " + name + "\n" +

                            "Sales Goal: $" + salesgoal + "\n" +
                            "Total sales: $" + total)
                    .show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_scouts, menu);
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
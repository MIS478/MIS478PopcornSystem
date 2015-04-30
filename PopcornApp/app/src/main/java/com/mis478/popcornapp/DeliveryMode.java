package com.mis478.popcornapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.app.ListActivity;
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


public class DeliveryMode extends ListActivity {
    public static final String KEY_121 = "http://207.179.202.218:1515/joe/2.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Delivery Mode");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        InputStream is = null;
        StrictMode.setThreadPolicy(policy);


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
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            line = reader.readLine();

                line.toString();
                String[] splitArray = line.split("\\}");
                String[] temp;
                //load into temp array
                String[] holder = new String[10];
                int delim = 0;
                String ts;
            for (int i = 0; i < splitArray.length -1; i++)
            {
                temp = splitArray[i].split(",");
                temp = temp[delim].split(":");
                delim =1;
                ts = temp[1];
                ts = ts.substring(1,ts.length() -1);
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
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            line = reader.readLine();

            line.toString();
            String[] splitArray = line.split("\\}");
           int delim = 1;
            if (position == 0)
            {
                delim = 0;
            }

            String[] SplitByComma = splitArray[position].split(",");

            String name, address, phone, email, ordered, total,paid,delivered;

            String[] namea, addressa, phonea, emaila, ordereda, totala,paida,delivereda;

            namea = SplitByComma[delim].split(":");
            name = namea[1];
            name = name.substring(1,name.length() -1);
            delim++;

            addressa = SplitByComma[delim].split(":");
            address = addressa[1];
            address = address.substring(1,address.length() -1);
            delim++;

            phonea = SplitByComma[delim].split(":");
            phone = phonea[1];
            phone = phone.substring(1,phone.length() -1);
            delim++;

            emaila = SplitByComma[delim].split(":");
            email = emaila[1];
            email = email.substring(1,email.length() -1);
            delim++;

            ordereda = SplitByComma[delim].split(":");
            ordered = ordereda[1];
            ordered = ordered.substring(1,ordered.length() -1);
            delim++;

            totala = SplitByComma[delim].split(":");
            total = totala[1];
            total = total.substring(1,total.length() -1);
            delim++;

            paida = SplitByComma[delim].split(":");
            paid = paida[1];
            paid = paid.substring(1,paid.length() -1);
            delim++;

            delivereda = SplitByComma[delim].split(":");
            delivered = delivereda[1];
            delivered = delivered.substring(1,delivered.length() -1);
            delim++;


            new AlertDialog.Builder(this)
                    .setTitle("Customer Information")
                    .setMessage("Name: " + name + "\n" +
                            "Address: " + address + "\n" +
                            "Phone: " + phone +"\n" +
                            "Email: " + email +"\n" +
                            "Ordered Products: " + ordered +"\n" +
                            "Total: $" + total + "\n" +
                            "Paid: " + paid + "\n" +
                            "Delivered: "+ delivered)
                    .setPositiveButton("Set order Delivered",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //stoopid android

                                }
                            })

                    .show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_delivery_mode, menu);
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
package com.mis478.popcornapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class AddScout extends ActionBarActivity {
    public static final String url_create_product = "http://207.179.202.218:1515/joe/addscout.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_scout);
    }


    public void back(View view) {
        Intent intent = new Intent(this, DenLeaderMain.class);
        startActivity(intent);
    }

    public void AddScout(View view) {
        TextView sn = (TextView) findViewById(R.id.Scout_number);
        TextView un = (TextView) findViewById(R.id.user_name);
        TextView fn = (TextView) findViewById(R.id.fname);
        TextView ln = (TextView) findViewById(R.id.lname);
        TextView sg = (TextView) findViewById(R.id.sales_goal);
        TextView pp = (TextView) findViewById(R.id.prize_progress);
        TextView dn = (TextView) findViewById(R.id.den_number);
        TextView p = (TextView) findViewById(R.id.pass);
        TextView ts = (TextView) findViewById(R.id.total_sales);
        TextView pg = (TextView) findViewById(R.id.personal_goal);
        TextView dg = (TextView) findViewById(R.id.den_goal);
        String a = sn.getText().toString();//
        String b = un.getText().toString();//
        String c = fn.getText().toString();//
        String d = ln.getText().toString();//
        String e = sg.getText().toString(); //
        String f = pp.getText().toString();//
        String g = dn.getText().toString();//
        String h = p.getText().toString(); //
        String i = ts.getText().toString();//
        String j = pg.getText().toString();//
        String k = dg.getText().toString(); //

        JSONParser jsonParser = new JSONParser();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("a", a));
        params.add(new BasicNameValuePair("b", b));
        params.add(new BasicNameValuePair("c", c));
        params.add(new BasicNameValuePair("d", d));
        params.add(new BasicNameValuePair("e", e));
        params.add(new BasicNameValuePair("f", f));
        params.add(new BasicNameValuePair("g", g));
        params.add(new BasicNameValuePair("h", h));
        params.add(new BasicNameValuePair("i", i));
        params.add(new BasicNameValuePair("j", j));
        params.add(new BasicNameValuePair("k", k));


        // wont allow duplicates
        // getting JSON Object
        // Note that create product url accepts POST method
        JSONObject json = jsonParser.makeHttpRequest(url_create_product,
                "POST", params);
        Log.d("Create Response", json.toString());
        Intent intent = new Intent(this, DenLeaderMain.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_scout, menu);
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

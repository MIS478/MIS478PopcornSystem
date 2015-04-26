package com.mis478.popcornapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;


public class ScoutStatusPage extends ActionBarActivity {
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_status_page);
        setTitle("Scout Status");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             value = extras.getString("name");
            TextView a = (TextView) findViewById(R.id.ScoutNameInput);
            a.setText(value);

            String test = extras.getString("string");
            String[] SplitByComma = test.split(",");
            TextView b = (TextView) findViewById(R.id.TotalSalesInput);
            String[] TotalSales = SplitByComma[8].split(":");
            String temp = TotalSales[1];
            temp = temp.substring(1,temp.length() -1);
            b.setText("$" + temp);

            TextView Personal = (TextView) findViewById(R.id.PersonalGoalAmt);
            String[] persongoal = SplitByComma[9].split(":");
            String temp2 = persongoal[1];
            temp2 = temp2.substring(1,temp2.length() -1);
            Personal.setText("$" + temp2);

            TextView DenG = (TextView) findViewById(R.id.DenGoalAmt);
            String[] dengoal = SplitByComma[10].split(":");
            String temp3 = dengoal[1];
            temp3 = temp3.substring(1,temp3.length() -1);
            DenG.setText("$" + temp3);

            //leaderboard stuff
            //gota declare all of those lame text views
            //names
            TextView name1 = (TextView) findViewById(R.id.name1);
            TextView name2 = (TextView) findViewById(R.id.name2);
            TextView name3 = (TextView) findViewById(R.id.name3);
            TextView name4 = (TextView) findViewById(R.id.name4);
            TextView name5 = (TextView) findViewById(R.id.name5);
            TextView name6 = (TextView) findViewById(R.id.name6);
            TextView name7 = (TextView) findViewById(R.id.name7);
            TextView name8 = (TextView) findViewById(R.id.name8);
            TextView name9 = (TextView) findViewById(R.id.name9);
            TextView name10 = (TextView) findViewById(R.id.name10);
            //totals
            TextView tot1 = (TextView) findViewById(R.id.total1);
            TextView tot2 = (TextView) findViewById(R.id.total2);
            TextView tot3 = (TextView) findViewById(R.id.total3);
            TextView tot4 = (TextView) findViewById(R.id.total4);
            TextView tot5 = (TextView) findViewById(R.id.total5);
            TextView tot6 = (TextView) findViewById(R.id.total6);
            TextView tot7 = (TextView) findViewById(R.id.total7);
            TextView tot8 = (TextView) findViewById(R.id.total8);
            TextView tot9 = (TextView) findViewById(R.id.total9);
            TextView tot10 = (TextView) findViewById(R.id.total10);


            String[] alldata = extras.getStringArray("all");
            //worlds sloppiest sorting loop
            Integer top = 0;
            Integer  two = 0;
            Integer  three = 0;
            Integer  four = 0;
            Integer  five = 0;
            Integer  six = 0;
            Integer  seven = 0;
            Integer  eight = 0;
            Integer  nine = 0;
            Integer  ten = 0;
            //totholder
            String[] holder;
            String holder2;
            //name holder
            String[] namehold;
            String namehold2;
            //integer holding area
            Integer anarray[];
            anarray = new Integer[10];
            //had to do some dome delim
            Integer delim = 8;
            Integer delimname = 2;

            Integer inthold;
            String inttostring;

            //name and int holder
            String[] dub = new String[10];

            //final holders before display
            String[] finalarrayname = new String[10];
            String[] finalarraytot = new String[10];
            //       temp = alldata[1];
            for (int i = 0; i < alldata.length -1; i++)
            {
                //tot
              holder = alldata[i].split(",");
              holder = holder[delim].split(":");
                //for whatever reason 8 is the total sales point for the first loop
                // and 9 is the total sales point for all others
                delim = 9;
              holder2 = holder[1];
              holder2 = holder2;
              holder2 = holder2.substring(1, holder2.length() -1);
              inthold = Integer.parseInt(holder2);
              anarray[i] = inthold;
              //name
              namehold = alldata[i].split(",");
              namehold = namehold[delimname].split(":");
              delimname =3;
              namehold2 = namehold[1];
              namehold2 = namehold2.substring(1, namehold2.length() -1);
                //loading the double
              dub[i] = (namehold2 +":"+ inthold.toString());

            }
            Arrays.sort(anarray, Collections.reverseOrder());
            for (int i = 0; i < dub.length; i++)
            {

                namehold = dub[i].split(":");
                namehold2 = namehold[1];
                inthold = Integer.parseInt(namehold2);
                for (int h = 0; h < anarray.length ; h++) {

                    if (inthold == anarray[h]) {
                        finalarrayname[h] = namehold[0];
                        finalarraytot[h] = namehold[1];
                    }
                }
            }
            //names
            name1.setText(finalarrayname[0]);
            name2.setText(finalarrayname[1]);
            name3.setText(finalarrayname[2]);
            name4.setText(finalarrayname[3]);
            name5.setText(finalarrayname[4]);
            name6.setText(finalarrayname[5]);
            name7.setText(finalarrayname[6]);
            name8.setText(finalarrayname[7]);
            name9.setText(finalarrayname[8]);
            name10.setText(finalarrayname[9]);

            //totals
            tot1.setText("$" + finalarraytot[0].toString());
            tot2.setText("$" + finalarraytot[1].toString());
            tot3.setText("$" + finalarraytot[2].toString());
            tot4.setText("$" + finalarraytot[3].toString());
            tot5.setText("$" + finalarraytot[4].toString());
            tot6.setText("$" + finalarraytot[5].toString());
            tot7.setText("$" + finalarraytot[6].toString());
            tot8.setText("$" + finalarraytot[7].toString());
            tot9.setText("$" + finalarraytot[8].toString());
            tot10.setText("$" + finalarraytot[9].toString());


        }

    }

    public void Next(View view) {
        Intent ToScoutMain = new Intent(this, ScoutMainPage.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            value = extras.getString("name");
       ToScoutMain.putExtra("name", value);

       String[] alldata = extras.getStringArray("all");
        ToScoutMain.putExtra("all", alldata);

            String test =  extras.getString("string");
        ToScoutMain.putExtra("string",test);
        }

        startActivity(ToScoutMain);
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

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


public class ScoutStatusPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_status_page);
        setTitle("Scout Status");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("name");
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

            Integer inthold;
            String inttostring;
            //       temp = alldata[1];
            for (int i = 0; i < alldata.length -1; i++)
            {
                //tot
              holder = alldata[i].split(",");
              holder = holder[9].split(":");
              holder2 = holder[1];
              holder2 = holder2;
              holder2 = holder2.substring(1, holder2.length() -1);
              inthold = Integer.parseInt(holder2);
              //name
              namehold = alldata[i].split(",");
              namehold = namehold[2].split(":");
              namehold2 = namehold[1];
              namehold2 = namehold2.substring(1, namehold2.length() -1);
                //top
              if (inthold > top)
               {
                   //update the old
                   two = top;
                   name2.setText(name1.getText());
                   tot2.setText(top.toString());

                   top = inthold;

                   name1.setText(namehold2);
                   inttostring = inthold.toString();
                   tot1.setText(inttostring);

               }
                //2
                if (inthold >= two  && inthold <= top)
                {
                    //update the old
                    three = two;
                    name3.setText(name2.getText());
                    tot3.setText(two.toString());

                    two = inthold;

                    name2.setText(namehold2);
                    inttostring = inthold.toString();
                    tot2.setText(inttostring);

                }
                //3
                if (inthold >= three && inthold <= two )
                {
                    //update the old
                    four = three;
                    name4.setText(name3.getText());
                    tot4.setText(three.toString());

                    three = inthold;

                    name3.setText(namehold2);
                    inttostring = inthold.toString();
                    tot3.setText(inttostring);

                }
                //4

                if (inthold >= four&& inthold <= three )
                {
                    //update the old
                    five = four;
                    name5.setText(name4.getText());
                    tot5.setText(four.toString());

                    four = inthold;

                    name4.setText(namehold2);
                    inttostring = inthold.toString();
                    tot4.setText(inttostring);

                }
                //5
                if (inthold >= five && inthold <= four)
                {
                    //update the old
                    six = five;
                    name6.setText(name5.getText());
                    tot6.setText(six.toString());

                    five = inthold;

                    name5.setText(namehold2);
                    inttostring = inthold.toString();
                    tot5.setText(inttostring);

                }
                //6
                if (inthold >= six && inthold <= five)
                {
                    //update the old
                    seven = six;
                    name7.setText(name6.getText());
                    tot7.setText(six.toString());

                    six = inthold;

                    name6.setText(namehold2);
                    inttostring = inthold.toString();
                    tot6.setText(inttostring);

                }
                //7
                if (inthold >= seven && inthold <= six )
                {
                    //update the old
                    eight = seven;
                    name8.setText(name7.getText());
                    tot8.setText(seven.toString());

                    seven = inthold;

                    name7.setText(namehold2);
                    inttostring = inthold.toString();
                    tot7.setText(inttostring);

                }
                //8
                if (inthold >= eight && inthold <= seven)
                {
                    //update the old
                    nine = eight;
                    name9.setText(name8.getText());
                    tot9.setText(eight.toString());

                    eight = inthold;

                    name8.setText(namehold2);
                    inttostring = inthold.toString();
                    tot8.setText(inttostring);

                }
                //9
                if (inthold >= nine && inthold <= eight )
                {
                    //update the old
                    ten = nine;
                    name10.setText(name9.getText());
                    tot10.setText(nine.toString());

                    nine = inthold;

                    name9.setText(namehold2);
                    inttostring = inthold.toString();
                    tot9.setText(inttostring);

                }
                //10
                if (inthold >= ten && inthold <= nine )
                {
                    ten = inthold;

                    name10.setText(namehold2);
                    inttostring = inthold.toString();
                    tot10.setText(inttostring);

                }
            }



        }

    }

    public void Next(View view) {
        Intent ToScoutMain = new Intent(this, ScoutMainPage.class);
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

package com.example.hofmanno.raidsetup;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Roster extends AppCompatActivity {

    int member_count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);

        initiateSpinners();
    }

    @Override
    protected void onStop() {
        EditText name;
        EditText gear;
        int count = 1;
        int id;

        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor e=prefs.edit();

        while (count <= member_count){
            id = getResources().getIdentifier("name_"+String.valueOf(count),"id",getPackageName());
            name = (EditText)findViewById(id);
            e.putString("name_"+String.valueOf(count),name.getText().toString());

            id = getResources().getIdentifier("gear_"+String.valueOf(count),"id",getPackageName());
            gear = (EditText)findViewById(id);
            e.putString("gear_"+String.valueOf(count),gear.getText().toString());

            count++;
        }


        //For later reference, to save the new rows
        /*if (member_count>3){
            name=(EditText)findViewById(Integer.valueOf(member_count));
            gear=(EditText)findViewById(Integer.valueOf(member_count));
            e.putString("name_4",name.getText().toString());
            e.putString("gear_4",gear.getText().toString());
            System.out.println("onstop");
        }

        e.putInt("member_count",member_count);
        System.out.println("member_count: " + member_count);*/

        e.commit();
        super.onStop();
    }

    @Override
    protected void onStart() {
        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        String content;
        EditText name;
        String gearscore;
        EditText gear;
        int count=1;
        int id;
        int member_test;

        while (count <= member_count){
            content=prefs.getString("name_"+count,"");
            id = getResources().getIdentifier("name_"+String.valueOf(count),"id",getPackageName());
            name=(EditText)findViewById(id);
            name.setText(content);

            content=prefs.getString("gear_"+count,"");
            id = getResources().getIdentifier("gear_"+String.valueOf(count),"id",getPackageName());
            gear=(EditText)findViewById(id);
            gear.setText(content);

            count++;
        }

        /*content=prefs.getString("name_1", "");
        name=(EditText)findViewById(R.id.name_1);
        name.setText(content);
        gearscore = prefs.getString("gear_1","");
        gear = (EditText)findViewById(R.id.gear_1);
        gear.setText(gearscore);

        content=prefs.getString("name_2", "");
        name=(EditText)findViewById(R.id.name_2);
        name.setText(content);
        gearscore = prefs.getString("gear_2","");
        gear = (EditText)findViewById(R.id.gear_2);
        gear.setText(gearscore);

        content=prefs.getString("name_3", "");
        name=(EditText)findViewById(R.id.name_3);
        name.setText(content);
        gearscore = prefs.getString("gear_3","");
        gear = (EditText)findViewById(R.id.gear_3);
        gear.setText(gearscore);*/


        //For later reference, to save the new rows
        /*member_test=prefs.getInt("member_count",4711);

        if (member_test>1){
            content=prefs.getString("name_4", "");
            name=(EditText)findViewById(Integer.valueOf(member_count));
            name.setText(content);
            gearscore = prefs.getString("gear_4","");
            gear = (EditText)findViewById(Integer.valueOf(member_count));
            gear.setText(gearscore);
            System.out.println("onstart");
        }*/

        super.onStart();
    }

    public void initiateSpinners(){
        ArrayAdapter<CharSequence> adapter_class = ArrayAdapter.createFromResource(this, R.array.class_array, android.R.layout.simple_spinner_item);
        adapter_class.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapter_role = ArrayAdapter.createFromResource(this, R.array.role_array, android.R.layout.simple_spinner_item);
        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner_class = (Spinner) findViewById(R.id.spinner_class_1);
        spinner_class.setAdapter(adapter_class);

        Spinner spinner_role = (Spinner) findViewById(R.id.spinner_role_1);
        spinner_role.setAdapter(adapter_role);

        Spinner spinner_off_role = (Spinner) findViewById(R.id.spinner_off_role_1);
        spinner_off_role.setAdapter(adapter_role);
    }

    public void new_member(View aView){
        member_count++;
        String count = String.valueOf(member_count);

        TableLayout tbl = (TableLayout) findViewById(R.id.members);
        TableRow row = new TableRow(this);
        EditText name = new EditText(this);
        name.setHint("Member " + count);
        name.setId(Integer.valueOf(member_count));
        EditText gearscore = new EditText(this);
        gearscore.setHint("Gearscore");
        Spinner clas = new Spinner(this);
        Spinner role = new Spinner(this);
        Spinner off_role = new Spinner(this);

        row.addView(name);
        row.addView(clas);
        row.addView(role);
        row.addView(off_role);
        row.addView(gearscore);
        tbl.addView(row);

        int id_test = name.getId();

        System.out.println("id der letzten Reihe: " + id_test);
    }
}

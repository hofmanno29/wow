package com.example.hofmanno.raidsetup;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int member_count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                EditText name=(EditText)findViewById(R.id.name_1);
                name.setText("hallooaoaoa");
            }
        });

        FloatingActionButton fab_clear = (FloatingActionButton) findViewById(R.id.fab_clear);
        fab_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                EditText name=(EditText)findViewById(R.id.name_1);
                name.setText("");
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initiateSpinners();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStop() {
        EditText name;
        EditText gear;
        Spinner spinner_class;
        Spinner spinner_role;
        Spinner spinner_off_role;
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

            id = getResources().getIdentifier("spinner_class_"+String.valueOf(count),"id",getPackageName());
            spinner_class = (Spinner)findViewById(id);
            e.putInt("spinner_class_"+String.valueOf(count),spinner_class.getSelectedItemPosition());

            id = getResources().getIdentifier("spinner_role_"+String.valueOf(count),"id",getPackageName());
            spinner_role = (Spinner)findViewById(id);
            e.putInt("spinner_role_"+String.valueOf(count),spinner_role.getSelectedItemPosition());

            id = getResources().getIdentifier("spinner_off_role_"+String.valueOf(count),"id",getPackageName());
            spinner_off_role = (Spinner)findViewById(id);
            e.putInt("spinner_off_role_"+String.valueOf(count),spinner_off_role.getSelectedItemPosition());

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
        int spinner_position;
        Spinner spinner_class;
        Spinner spinner_role;
        Spinner spinner_off_role;
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

            spinner_position=prefs.getInt("spinner_class_"+count,0);
            id = getResources().getIdentifier("spinner_class_"+String.valueOf(count),"id",getPackageName());
            spinner_class=(Spinner)findViewById(id);
            spinner_class.setSelection(spinner_position);

            spinner_position=prefs.getInt("spinner_role_"+count,0);
            id = getResources().getIdentifier("spinner_role_"+String.valueOf(count),"id",getPackageName());
            spinner_role=(Spinner)findViewById(id);
            spinner_role.setSelection(spinner_position);

            spinner_position=prefs.getInt("spinner_off_role_"+count,0);
            id = getResources().getIdentifier("spinner_off_role_"+String.valueOf(count),"id",getPackageName());
            spinner_off_role=(Spinner)findViewById(id);
            spinner_off_role.setSelection(spinner_position);

            count++;
        }


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
        int count = 1;
        int id;

        Spinner spinner_class;
        Spinner spinner_role;
        Spinner spinner_off_role;

        ArrayAdapter<CharSequence> adapter_class = ArrayAdapter.createFromResource(this, R.array.class_array, android.R.layout.simple_spinner_item);
        adapter_class.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapter_role = ArrayAdapter.createFromResource(this, R.array.role_array, android.R.layout.simple_spinner_item);
        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        while (count<=member_count){
            id = getResources().getIdentifier("spinner_class_"+String.valueOf(count),"id",getPackageName());
            spinner_class = (Spinner)findViewById(id);
            spinner_class.setAdapter(adapter_class);

            id = getResources().getIdentifier("spinner_role_"+String.valueOf(count),"id",getPackageName());
            spinner_role = (Spinner)findViewById(id);
            spinner_role.setAdapter(adapter_role);

            id = getResources().getIdentifier("spinner_off_role_"+String.valueOf(count),"id",getPackageName());
            spinner_off_role = (Spinner)findViewById(id);
            spinner_off_role.setAdapter(adapter_role);

            count++;
        }
    }

    public void new_member(View aView){
        /*member_count++;
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

        System.out.println("id der letzten Reihe: " + id_test);*/
    }

    public void clear(View aView){
        int count = 1;
        int id;
        EditText name;
        EditText gear;
        Spinner spinner_class;
        Spinner spinner_role;
        Spinner spinner_off_role;

        while (count <= member_count){
            id = getResources().getIdentifier("name_"+String.valueOf(count),"id",getPackageName());
            name = (EditText)findViewById(id);
            name.setText("");

            id = getResources().getIdentifier("gear_"+String.valueOf(count),"id",getPackageName());
            gear = (EditText)findViewById(id);
            gear.setText("");

            id = getResources().getIdentifier("spinner_class_"+String.valueOf(count),"id",getPackageName());
            spinner_class = (Spinner)findViewById(id);
            spinner_class.setSelection(0);

            id = getResources().getIdentifier("spinner_role_"+String.valueOf(count),"id",getPackageName());
            spinner_role = (Spinner)findViewById(id);
            spinner_role.setSelection(0);

            id = getResources().getIdentifier("spinner_off_role_"+String.valueOf(count),"id",getPackageName());
            spinner_off_role = (Spinner)findViewById(id);
            spinner_off_role.setSelection(0);

            count++;
        }
    }
}

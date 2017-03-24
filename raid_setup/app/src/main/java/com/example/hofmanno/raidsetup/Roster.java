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

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);

        initiateSpinners();
    }

    @Override
    protected void onStop() {
        EditText editText=(EditText)findViewById(R.id.name_1);
        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor e=prefs.edit();
        e.putString("content",editText.getText().toString());
        e.putString("gearscore","1");
        e.commit();
        super.onStop();
    }

    @Override
    protected void onStart() {
        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        String content=prefs.getString("content", "default");
        EditText name=(EditText)findViewById(R.id.name_1);
        name.setText(content);
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
        TableLayout tbl = (TableLayout) findViewById(R.id.members);
        TableRow row = new TableRow(this);
        EditText name = new EditText(this);
        name.setHint("Name");
        //name.setId(i);
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
        i++;
    }
}

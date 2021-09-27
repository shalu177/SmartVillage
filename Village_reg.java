package com.example.dellpc.smartvillage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Village_reg extends AppCompatActivity {
    Spinner sp;
    EditText et;
    List<String> li;

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village_reg);
        li=new ArrayList<String>();
        li.add("S.K. Singh");
       // li.add("Item 2");
        //li.add("Item 3");

        sp=(Spinner) findViewById(R.id.spinner);
        Button b=(Button) findViewById(R.id.btn_add);
        et=(EditText)findViewById(R.id.txtHeads);
        b1 =(Button) findViewById(R.id.btnSubmit);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Village_reg.this, Login.class);
                Village_reg.this.startActivity(mainIntent);
                Village_reg.this.finish();
            }
        });

        add();

        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                li.add(et.getText().toString());
                et.setText(null);
                add();
            }
        });
    }

    private void add() {
        // TODO Auto-generated method stub
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,li);
        sp.setAdapter(adp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}



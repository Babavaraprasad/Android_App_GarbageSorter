package com.example.garbagesorting;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;

public class AddPage extends AppCompatActivity {
    private static ItemsDB itemsDB;
    private Button addItem;
    private EditText newWhat;
    private EditText newWhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnewitem);
        //new_activity-Adding text from fields to ItemDB using listener
        ItemsDB.initialize(AddPage.this);
        itemsDB= ItemsDB.get();
        //Text Fields
        newWhat=  findViewById(R.id.what_text);
        newWhere= findViewById(R.id.where_text);
        addItem= findViewById(R.id.add_button);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String whatS= newWhat.getText().toString().trim();
                String whereS= newWhere.getText().toString().trim();
                if ((whatS.length() > 0) && (whereS.length() > 0)) {
                    Log.d("ItemsDB","what: " + whatS + " where: " + whereS);
                    itemsDB.addItem(whatS, whereS);
                    newWhat.setText("");
                    newWhere.setText("");
                } else Toast.makeText(AddPage.this, "Not valid", Toast.LENGTH_LONG).show();
            }
        });
    }
    //new_activity-Added text from fields to ItemDB using listener
    }


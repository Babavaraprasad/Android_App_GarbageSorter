package com.example.garbagesorting;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import android.widget.TextView;


public class SortingActivity extends AppCompatActivity {

    //garbage sorting v1

    //GUI variables(graphical user interface)
    private Button placeofitem;
    //private TextView items;
    private EditText inputcontent;
    //Main activity Add button field
    private Button mainpageadd;
    // Model: Database of items
    private static ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garbagesorting);

        //garbage app V1 code starts here
        ItemsDB.initialize(SortingActivity.this);
        itemsDB=ItemsDB.get();
        //itemsDB = new ItemsDB();
        /* note:if we create a object with the same name(itemsDB) defined in above line this
        is resulting in overwriting the memory stack and couldn't get dataset required
        and hence picking the old dataset records stored.
        */
        //itemsDB.fillItemsDB();
        inputcontent = findViewById(R.id.Enter_text);
        placeofitem = findViewById(R.id.where_button);
        placeofitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputcontent.getText().toString();
                inputcontent.setText(itemsDB.search(name));
            }
        });
        //garbage app V1 code ends here

        //garbage activity V2(new activity) code starts from here
        Button mainpageadd = (Button) findViewById(R.id.add_new_btn);
        mainpageadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity();
            }
        });
    }
        public void openactivity() {
            Intent intent = new Intent(SortingActivity.this, AddPage.class);
            startActivity(intent);
        }
     //garbage activity V2(new activity) code ends here

}

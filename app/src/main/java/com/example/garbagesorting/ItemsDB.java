package com.example.garbagesorting;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemsDB {
    private static ItemsDB sItemsDB;
    //private List<Item> itemsDB= new ArrayList<>();
    private final HashMap<String, String> itemsMap= new HashMap<String, String>();

    public ItemsDB(Context context) {fillItemsDB(context,"items.txt"); }

    public static void initialize(Context context) {
        if (sItemsDB == null) {
            sItemsDB = new ItemsDB(context);
        }
    }
    public static ItemsDB get() {
        if (sItemsDB == null) throw new IllegalStateException("ItemsDB must be initialized");
        return sItemsDB;
    }

    public HashMap<String, String> getItemsDB() {
        return itemsMap;
    }
    /* Reason for commenting: this code is only used as part for shopping app
    public String listItems() {
        String r= "";
        for(Item i: ItemsDB)
            r= r+"\n Buy " + i.toString();
        return r;
    }
    */
    public int size() {
        return itemsMap.size();
    }
    public String getWhere(String what) {
        return itemsMap.get(what);
    }
    public void addItem(String what, String where) {
        itemsMap.put(what, where);
        Log.d("ItemsDB","what: " + what + " where: " + where);
        //Log.d("ItemsDB","items: "+sItemsDB);
    }
    public void removeItem(String what){
        if (itemsMap.get(what) != null) {
            itemsMap.remove(what);
        }
    }
    public void fillItemsDB(Context context, String filename) {
        try {
            BufferedReader reader= new BufferedReader(
                    new InputStreamReader(context.getAssets().open(filename)));
            String line= reader.readLine();
            while (line != null) {
                String[] gItem= line.split(",");
                itemsMap.put(gItem[0], gItem[1]);
                line= reader.readLine();
            }
        } catch (IOException e) {  // Error occurred when opening raw file for reading.
        }
    }

    public String search(String query)
        {
            String result= "";
            if(query!=null) {
                    if(itemsMap.containsKey(query))
                    {
                        Log.d("ItemsDB","search what: "+query);
                        String wherevalue = getWhere(query);
                        Log.d("ItemsDB","search where: "+query);
                        result = query+" should be placed in: "+wherevalue;
                    }
                    else
                    {
                        result = query + " should be placed in: not found";
                    }
                }
                return result;
        }
}


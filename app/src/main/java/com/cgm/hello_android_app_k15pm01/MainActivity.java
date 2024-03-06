package com.cgm.hello_android_app_k15pm01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cgm.hello_android_app_k15pm01.entities.Product;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //put data list to productLisView
        ListView listView =  findViewById(R.id.productListView);

        List<Product> dataList = Arrays.asList(
                new Product("Sam sung galaxy s 3", 700, "p1.jpg"),
                new Product("Iphone 15 promax 2024", 200, "p2.jpg")
        );

        ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(this,
                android.R.layout.simple_list_item_1, dataList);

        listView.setAdapter(adapter);
    }
}
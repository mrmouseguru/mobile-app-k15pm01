package com.cgm.hello_android_app_k15pm01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cgm.hello_android_app_k15pm01.entities.Product;
import com.cgm.hello_android_app_k15pm01.services.ProductService;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //put data list to productLisView
        ListView listView =  findViewById(R.id.productListView);

//        List<Product> dataList = Arrays.asList(
//                new Product("Sam sung galaxy s 3", 700, "p1.jpg"),
//                new Product("Iphone 15 promax 2024", 200, "p2.jpg")
//        );

        Retrofit retrofit = null;
        Call<List<Product>> call = null;
        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8080/hello-web-app/rest/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ProductService productService = retrofit.create(ProductService.class);

         call   = productService.getAllProducts();
            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    if(response.isSuccessful()){
                        List<Product> productList = response.body();
                        //System.out.println("productlsit" + productList);
                        ArrayAdapter<Product> adapter =
                                new ArrayAdapter<Product>(MainActivity.this,
                                        android.R.layout.simple_list_item_1, productList);
                        listView.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {
                    System.out.println("error: " + t.getMessage());
                }
            });
        }catch (Exception ex){
           ex.printStackTrace();
        }





    }
}
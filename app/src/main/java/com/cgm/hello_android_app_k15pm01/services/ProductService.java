package com.cgm.hello_android_app_k15pm01.services;

import com.cgm.hello_android_app_k15pm01.entities.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {

    @GET("/rest/products")
    Call<List<Product>> getAllProducts();
}

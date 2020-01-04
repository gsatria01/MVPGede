package com.example.mvp2nd.Model;

import com.google.gson.annotations.SerializedName;

public class ProductDetailResponse {

    @SerializedName("product_id")
    public int productId;

    @SerializedName("kategori_fk")
    public int kategori_fk;


    @SerializedName("product_name")
    public String product_name;

    @SerializedName("product_price")
    public String product_price;

    @SerializedName("product_stock")
    public String product_stock;

    @SerializedName("product_status")
    public String product_status;

    @SerializedName("kategori_id")
    public String kategori_id;

    @SerializedName("kategori_name")
    public String kategori_name;

    @SerializedName("kategori_status")
    public String kategori_status;

}

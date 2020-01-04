package com.example.mvp2nd.Retrofit;

import com.example.mvp2nd.Config.Link;
import com.example.mvp2nd.Model.LoginResponse;
import com.example.mvp2nd.Model.ProductDetailResponse;
import com.example.mvp2nd.Model.UploadResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {

    @GET(Link.BASE_APIKEY)
    Call<List<ProductDetailResponse>> getAllProducts();

    @POST("addcourse")
    @FormUrlEncoded
    Call<UploadResponse> retrofitPostCourse(

            @Field("trx_product_fk") int product,
            @Field("trx_user_fk") int user,
            @Field("trx_qty") int qty,
            @Field("trx_date") String date,
            @Field("trx_amount") double amount



    );

    @POST("login")
    @FormUrlEncoded
    Call<LoginResponse> retrofitPostLogin(

            @Field("email") String username,
            @Field("password") String password

    );
}

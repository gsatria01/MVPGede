package com.example.mvp2nd.Presenter;

import com.example.mvp2nd.Contract.GlobalContract;
import com.example.mvp2nd.Model.ProductDetailResponse;
import com.example.mvp2nd.Retrofit.GetDataService;
import com.example.mvp2nd.Retrofit.RetrofitClientInstance;
import com.example.mvp2nd.ShowProduct;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowProductPresenter implements GlobalContract.ShowProductPresenterContract {

    GlobalContract.ShowProductContract iShowProductView;

    public ShowProductPresenter(GlobalContract.ShowProductContract iShowProductView) {

        this.iShowProductView = iShowProductView;
    }

    @Override
    public void loadProduct() {

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<ProductDetailResponse>> call = service.getAllProducts();

        call.enqueue(new Callback<List<ProductDetailResponse>>() {
            @Override
            public void onResponse(Call<List<ProductDetailResponse>> call, Response<List<ProductDetailResponse>> response) {

                if (response.isSuccessful()) {
                    List<ProductDetailResponse> generatedProduct = response.body();

                    iShowProductView.populateProduct(generatedProduct);
                }

            }

            @Override
            public void onFailure(Call<List<ProductDetailResponse>> call, Throwable t) {

            }
        });

    }
}

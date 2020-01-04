package com.example.mvp2nd.Presenter;

import com.example.mvp2nd.Contract.GlobalContract;
import com.example.mvp2nd.Model.UploadResponse;
import com.example.mvp2nd.Retrofit.GetDataService;
import com.example.mvp2nd.Retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadPresenter implements GlobalContract.UploadPresenterContract {

    GlobalContract.UploadFormActivityContract iUploadView;

    public UploadPresenter(GlobalContract.UploadFormActivityContract iUploadView) {

        this.iUploadView = iUploadView;
    }


    @Override
    public void postUploadToDb(int product, int user, int qty, String date, double amount) {

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<UploadResponse> call = service.retrofitPostCourse(product, user, qty, date, amount);

        call.enqueue(new Callback<UploadResponse>() {
            @Override
            public void onResponse(Call<UploadResponse> call, Response<UploadResponse> response) {

                UploadResponse uploadRes = response.body();

                if(response.isSuccessful()){



                    iUploadView.ShowNotification(uploadRes.message);


                }
                else{

                    iUploadView.ShowNotification(uploadRes.message);

                }

            }

            @Override
            public void onFailure(Call<UploadResponse> call, Throwable t) {

            }
        });

    }
}

package com.example.mvp2nd.Presenter;

import android.widget.EditText;
import android.widget.TextView;

import com.example.mvp2nd.ConfirmProduct;
import com.example.mvp2nd.Contract.GlobalContract;
import com.example.mvp2nd.Model.UploadResponse;
import com.example.mvp2nd.Retrofit.GetDataService;
import com.example.mvp2nd.Retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmProductPresenter implements GlobalContract.confirmProductContractPresenter {

    GlobalContract.ConfirmProductContractView iConfirmProductView;

    public ConfirmProductPresenter(GlobalContract.ConfirmProductContractView iConfirmProductView) {

        this.iConfirmProductView = iConfirmProductView;
    }

    @Override
    public void prosesKalkulasi(EditText ed, String result) {

        ed.setText(result);

    }

    @Override
    public void prosesAmount(TextView tv) {

        iConfirmProductView.totalAmount(tv);

    }

    @Override
    public void postBeliProduct(int product, int user, int qty, String date, double amount) {

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<UploadResponse> call = service.retrofitPostCourse(product, user, qty, date, amount);

        call.enqueue(new Callback<UploadResponse>() {
            @Override
            public void onResponse(Call<UploadResponse> call, Response<UploadResponse> response) {

                UploadResponse uploadRes = response.body();

                if(response.isSuccessful()){



                    iConfirmProductView.ShowNotif(uploadRes.message);


                }
                else{

                    iConfirmProductView.ShowNotif(uploadRes.message);

                }

            }

            @Override
            public void onFailure(Call<UploadResponse> call, Throwable t) {

            }
        });

    }

    public Integer addCounter(int basic){

        basic = 0;

        basic = basic + 1;

        return basic;
    }
}

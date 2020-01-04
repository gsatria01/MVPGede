package com.example.mvp2nd.Presenter;

import android.util.Log;

import com.example.mvp2nd.Contract.GlobalContract;
import com.example.mvp2nd.Model.LoginResponse;
import com.example.mvp2nd.Retrofit.GetDataService;
import com.example.mvp2nd.Retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements GlobalContract.LoginPresenterContract {

    GlobalContract.LoginViewContract iLoginView;

    public LoginPresenter (GlobalContract.LoginViewContract iLoginView){

        this.iLoginView = iLoginView;
    }

    @Override
    public void authLogin(String username, String password) {

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<LoginResponse> call = service.retrofitPostLogin(username,password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){

                    LoginResponse respondLogin = response.body();



                    Log.d("trace login",respondLogin.message);
                    iLoginView.pageChange(respondLogin.message);
                }
                else {
                    LoginResponse respondLogin = response.body();

                    Log.d("trace login","gagal");
                    iLoginView.pageChange(respondLogin.message);
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }
}

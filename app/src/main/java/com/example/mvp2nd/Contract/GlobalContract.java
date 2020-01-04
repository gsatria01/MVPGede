package com.example.mvp2nd.Contract;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvp2nd.Model.ProductDetailResponse;

import java.util.List;

public interface GlobalContract {

    //UploadForm act
    interface UploadPresenterContract{

        void postUploadToDb(int product, int user, int qty, String date, double amount);
    }

    interface UploadFormActivityContract{

        void ShowNotification(String message);
    }

    //======================================================================================

    //LoginPresenter Contract
    interface LoginPresenterContract {

        void authLogin(String username,String password);
    }

    interface LoginViewContract {

        void pageChange (String status);
    }

    //====================================================================================

    //ShowProduct Contract
    interface ShowProductPresenterContract {

        void loadProduct();
    }

    interface ShowProductContract {
        void populateProduct(List<ProductDetailResponse> generatedProduct);
    }

    interface ConfirmProductContractView{
        void calculatedButtonExtion(Button btn, int flag);
        void showResult(TextView tv);
        void totalAmount(TextView tv);
        void ShowNotif(String message);


    }

    interface confirmProductContractPresenter{
        void prosesKalkulasi(EditText tv, String result);
        void prosesAmount(TextView tv);
        void postBeliProduct(int product, int user, int qty, String date, double amount);
    }
}

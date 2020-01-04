package com.example.mvp2nd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp2nd.Contract.GlobalContract;
import com.example.mvp2nd.Presenter.UploadPresenter;

public class UploadForm extends AppCompatActivity implements GlobalContract.UploadFormActivityContract {

    EditText edproductfk, eduserfk, edqty, eddate, edamount;
    Button btndone;

    UploadPresenter uploadPresenter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_form);

        edproductfk = findViewById(R.id.product_fk);
        eduserfk = findViewById(R.id.user_fk);
        edqty = findViewById(R.id.qty);
        eddate = findViewById(R.id.date);
        edamount = findViewById(R.id.amount);
        btndone = findViewById(R.id.btn_done);

        uploadPresenter = new UploadPresenter(UploadForm.this);

        uploadPresenter.postUploadToDb(1,1,1,"1999-04-28",150000.0);
    }

    @Override
    public void ShowNotification(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}

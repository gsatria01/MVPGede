package com.example.mvp2nd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp2nd.Contract.GlobalContract;
import com.example.mvp2nd.Presenter.LoginPresenter;

public class HalLogin extends AppCompatActivity implements GlobalContract.LoginViewContract {

    EditText uname,password;
    Button btn_login;

    LoginPresenter loginPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal_login);

        loginPresenter = new LoginPresenter(HalLogin.this);

        uname = findViewById(R.id.uname);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.authLogin(uname.getText().toString().trim(),password.getText().toString());
            }
        });
    }

    @Override
    public void pageChange(String status) {
        if (status.equals("success")) {

            Intent intentShowProduct = new Intent(HalLogin.this,ShowProduct.class);
            startActivity(intentShowProduct);
        }

        else if (!status.equals("success")) {
            Toast.makeText(getApplicationContext(),"data invalid",Toast.LENGTH_LONG).show();
        }
    }
}

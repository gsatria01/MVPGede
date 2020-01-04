package com.example.mvp2nd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp2nd.Contract.GlobalContract;
import com.example.mvp2nd.Presenter.ConfirmProductPresenter;

public class ConfirmProduct extends AppCompatActivity implements GlobalContract.ConfirmProductContractView {

    TextView prod_name,price,result;
    EditText total_prod;
    Button btn_min,btn_plus;
    String tampung_id,tampung_name,tampung_price;
    int harga_dasar = 0, counter = 0;

    ConfirmProductPresenter confirmProductPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_product);
        confirmProductPresenter = new ConfirmProductPresenter(ConfirmProduct.this);

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            tampung_id = "";
            tampung_name = "";
            tampung_price = "";
        } else {
            tampung_id = extras.getString("STRING_ID");
            tampung_name = extras.getString("STRING_PRODUCT");
            tampung_price = extras.getString("STRING_PRICE");
            harga_dasar = Integer.parseInt(tampung_price);
        }

        prod_name = findViewById(R.id.prod_name);
        price = findViewById(R.id.price);
        result = findViewById(R.id.shop_result);
        total_prod = findViewById(R.id.total_prod);
        btn_min = findViewById(R.id.btn_min);
        btn_plus = findViewById(R.id.btn_plus);

        prod_name.setText(tampung_name);
        price.setText(tampung_price);
        total_prod.setText("1");

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                counter = counter + 1 ;
                Log.d("trace_counter", String.valueOf(counter));
                confirmProductPresenter.prosesKalkulasi(total_prod, String.valueOf(counter));
                confirmProductPresenter.prosesAmount(result);
            }
        });

    }

    @Override
    public void calculatedButtonExtion(Button btn, int flag) {

    }

    @Override
    public void showResult(TextView tv) {

    }

    @Override
    public void totalAmount(TextView tv) {

    }

    @Override
    public void ShowNotif(String message) {

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }
}

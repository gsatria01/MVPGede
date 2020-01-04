package com.example.mvp2nd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvp2nd.Adapter.ProductAdapter;
import com.example.mvp2nd.Contract.GlobalContract;
import com.example.mvp2nd.Model.ProductDetailResponse;
import com.example.mvp2nd.Presenter.ShowProductPresenter;

import java.util.List;

public class ShowProduct extends AppCompatActivity implements GlobalContract.ShowProductContract {

    RecyclerView rv_prod_id;

    ProductAdapter productAdapter;

    ShowProductPresenter showProductPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);

        showProductPresenter = new ShowProductPresenter(ShowProduct.this);

        rv_prod_id = findViewById(R.id.rv_prod_id);

        showProductPresenter.loadProduct();

    }

    @Override
    public void populateProduct(List<ProductDetailResponse> generatedProduct) {

        productAdapter = new ProductAdapter(ShowProduct.this,generatedProduct);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ShowProduct.this,LinearLayoutManager.VERTICAL,false);

        rv_prod_id.setLayoutManager(layoutManager);
        rv_prod_id.setAdapter(productAdapter);

    }
}

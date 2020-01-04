package com.example.mvp2nd.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp2nd.ConfirmProduct;
import com.example.mvp2nd.Model.ProductDetailResponse;
import com.example.mvp2nd.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.CustomViewHolder> {

    private List<ProductDetailResponse> myProduct;
    private Context context;

    public ProductAdapter(Context context, List<ProductDetailResponse> myProduct) {

        this.myProduct = myProduct;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_product, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.CustomViewHolder customViewHolder, final int i) {

        customViewHolder.titlePhotos.setText(myProduct.get(i).product_name);
        customViewHolder.pricePhotos.setText("Rp."+myProduct.get(i).product_price);

        customViewHolder.Ll_rowID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,myProduct.get(i).product_name,Toast.LENGTH_LONG).show();

                Intent in = new Intent(context, ConfirmProduct.class);
                in.putExtra("STRING_ID",myProduct.get(i).productId);
                in.putExtra("STRING_PRODUCT",myProduct.get(i).product_name);
                in.putExtra("STRING_PRICE",myProduct.get(i).product_price);
                context.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myProduct.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {


        ImageView iconPhotos;
        TextView titlePhotos;
        TextView pricePhotos;
        LinearLayout Ll_rowID;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            iconPhotos = itemView.findViewById(R.id.imageID);
            titlePhotos= itemView.findViewById(R.id.prodID);
            pricePhotos= itemView.findViewById(R.id.priceID);
            Ll_rowID= itemView.findViewById(R.id.rowID);


        }
    }
}

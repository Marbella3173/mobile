package com.example.rangkumanuts;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {

    Context context;
    ArrayList<Customer> customers;

    public CustomerAdapter(Context context, ArrayList<Customer> customers){
        this.context = context;
        this.customers = customers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String customerName = customers.get(position).getCustomerName();
        int customerImg = customers.get(position).getImgId();

        holder.txtCustomerName.setText(customerName);
        holder.imgCustomer.setImageResource(customerImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CLICKED", "onClick: CLICKED AN ITEM");

                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("name", customerName);
                intent.putExtra("image", customerImg);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        // ambil elemen2 yang ada di item layout (item_customer)
        TextView txtCustomerName;
        ImageView imgCustomer;
        Button btnCustomer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCustomerName = itemView.findViewById(R.id.tvCustomerName);
            imgCustomer = itemView.findViewById(R.id.imgCustomer);
            btnCustomer = itemView.findViewById(R.id.btnCustomer);
        }
    }
}

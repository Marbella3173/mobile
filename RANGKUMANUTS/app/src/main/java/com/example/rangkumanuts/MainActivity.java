package com.example.rangkumanuts;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvCustomer;
    ArrayList<Customer> customers;
    CustomerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvCustomer = findViewById(R.id.rvCustomer);
        customers = new ArrayList<>();
        customers.add(new Customer("Seungmin", R.drawable.umin));
        customers.add(new Customer("Seungmin", R.drawable.umin));
        customers.add(new Customer("Seungmin", R.drawable.umin));

        adapter = new CustomerAdapter(this, customers);
        rvCustomer.setLayoutManager(new GridLayoutManager(this, 2));
        rvCustomer.setAdapter(adapter);
    }
}
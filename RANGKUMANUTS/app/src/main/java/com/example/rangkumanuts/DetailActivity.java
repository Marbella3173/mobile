package com.example.rangkumanuts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    TextView tvCustomerName;
    ImageView imgCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvCustomerName = findViewById(R.id.tvCustomerName);
        imgCustomer = findViewById(R.id.imgCustomer);

        Intent intent = getIntent();
        String customerName = intent.getStringExtra("name");
        int imageId = intent.getIntExtra("image", 1);

        tvCustomerName.setText(customerName);
        imgCustomer.setImageResource(imageId);
    }
}
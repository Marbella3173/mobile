package com.example.gslcsesi4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    TextView homeNameTV, homeBinusianTV;

    GridView homeGV;

    int[] imageList = {R.drawable.twotone_home_24,
            R.drawable.twotone_calendar_month_24,
            R.drawable.twotone_book_24,
            R.drawable.twotone_account_balance_wallet_24,
            R.drawable.twotone_build_24,
            R.drawable.twotone_logout_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        homeNameTV = findViewById(R.id.homeNameTV);
        homeBinusianTV = findViewById(R.id.homeBinusianTV);

        Intent ambilIntent = getIntent();

        String name = ambilIntent.getStringExtra("Name");
        String id = ambilIntent.getStringExtra("ID");
        String role = ambilIntent.getStringExtra("Role");

        homeNameTV.setText(name);
        homeBinusianTV.setText(id + " - " + role);

        homeGV = findViewById(R.id.homeGV);

        CustomAdapter adapter = new CustomAdapter(this, imageList);
        homeGV.setAdapter(adapter);
    }
}
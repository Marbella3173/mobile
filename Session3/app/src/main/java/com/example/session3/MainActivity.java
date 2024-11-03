package com.example.session3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        Log.d("lifecycle", "activity created");

        Button mainSubmitBtn = findViewById(R.id.mainSubmitBtn);
        mainSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
                Toast.makeText(MainActivity.this, "Pindah halaman", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "activity started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "activity resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "activity paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "activity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "activity destroyed");
    }
}
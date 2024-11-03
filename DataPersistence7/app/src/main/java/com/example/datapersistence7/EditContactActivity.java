package com.example.datapersistence7;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditContactActivity extends AppCompatActivity {
    EditText editNameET, editPhoneET;
    Button editSaveBtn;
    TextView editDeleteTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editNameET = findViewById(R.id.editNameET);
        editPhoneET = findViewById(R.id.editPhoneET);
        editSaveBtn = findViewById(R.id.editSaveBtn);
        editDeleteTV = findViewById(R.id.editDeleteTV);
    }
}
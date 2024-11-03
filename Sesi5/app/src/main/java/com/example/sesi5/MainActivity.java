package com.example.sesi5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ContactData> contactList;

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

        prepareData();

        RecyclerView mainContactRV = findViewById(R.id.mainContactRV);
        ContactAdapter adapter = new ContactAdapter(contactList);
        mainContactRV.setLayoutManager(new LinearLayoutManager(this));
        // kalau bikin bentuk list, kalo mo grid pilih grid sama tentuin brp gridny (grid lalala, 3)
        mainContactRV.setAdapter(adapter);
    }

    private void prepareData(){
        contactList = new ArrayList<>();

        contactList.add(new ContactData("John", "08123456789"));
        contactList.add(new ContactData("John", "08123456789"));
        contactList.add(new ContactData("John", "08123456789"));
        contactList.add(new ContactData("John", "08123456789"));
        contactList.add(new ContactData("John", "08123456789"));
        contactList.add(new ContactData("John", "08123456789"));
        contactList.add(new ContactData("John", "08123456789"));
        contactList.add(new ContactData("John", "08123456789"));
        contactList.add(new ContactData("John", "08123456789"));
        contactList.add(new ContactData("John", "08123456789"));
        // ctrl + D --> copas kebwh
    }
}
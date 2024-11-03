package com.example.sesi5;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private Context activityContext;
    private List<ContactData> contactList;

    public ContactAdapter(List<ContactData> dataContact){
        contactList = dataContact;
    }

    @NonNull
    @Override
    public ContactAdapter.ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        activityContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(activityContext);
        View layoutView = inflater.inflate(R.layout.item_contact, parent, false);
        ContactHolder holder = new ContactHolder(layoutView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactHolder holder, int position) {
        String name = contactList.get(position).getName();
        String phoneNumber = contactList.get(position).getPhoneNumber();

        holder.itemNameTV.setText(name);
        holder.itemNumberTV.setText(phoneNumber);

        holder.itemProfileIV.setImageResource(R.drawable.ic_launcher_background);

        holder.itemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri phone = Uri.parse("tel: " + phoneNumber);

                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(phone);

                activityContext.startActivity(phoneIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ContactHolder extends RecyclerView.ViewHolder {

        TextView itemNameTV, itemNumberTV;
        ConstraintLayout itemContainer;
        ImageView itemProfileIV;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);

            itemNameTV = itemView.findViewById(R.id.itemNameTV);
            itemNumberTV = itemView.findViewById(R.id.itemNumberTV);
            itemContainer = itemView.findViewById(R.id.itemContainer);
            itemProfileIV = itemView.findViewById(R.id.itemProfileIV);
        }
    }
}

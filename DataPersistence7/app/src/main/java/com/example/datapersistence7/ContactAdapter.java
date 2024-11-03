package com.example.datapersistence7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {
    private Context context;
    private List<ContactModel> contactList;

    public ContactAdapter(List<ContactModel> contactList){
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactAdapter.ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_contact, parent, false);
        ContactHolder holder = new ContactHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactHolder holder, int position) {
        String contactName = contactList.get(position).getName();
        String contactPhone = contactList.get(position).getPhone();
        int id = contactList.get(position).getId();

        holder.itemNameTV.setText(contactName);
        holder.itemPhoneTV.setText(contactPhone);

        holder.itemContainerLL.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ContactHolder extends RecyclerView.ViewHolder {
        TextView itemNameTV, itemPhoneTV;
        LinearLayout itemContainerLL;
        public ContactHolder(@NonNull View itemView) {
            super(itemView);

            itemNameTV = itemView.findViewById(R.id.itemNameTV);
            itemPhoneTV = itemView.findViewById(R.id.itemPhoneTV);
            itemContainerLL = itemView.findViewById(R.id.itemContainerLL);
        }
    }
}
